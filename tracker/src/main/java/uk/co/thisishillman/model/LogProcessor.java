/*
 * The MIT License
 *
 * Copyright 2015 M Hillman - thisishillman.co.uk
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package uk.co.thisishillman.model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Reads SSH logs and build Request objects
 * 
 * @author M Hillman
 */
public class LogProcessor extends Thread {
    
    // Polling interval in seconds
    public static final int POLL_DELAY = 60;
    
    // Time out on single request process
    public static final int TIME_OUT = 10;
    
    // Running flag
    public static volatile boolean RUNNING;
    
    // Location of log file
    private final Path logFile;
    
    // WatchService
    private WatchService watcher;
    
    // WatchKey
    private WatchKey key;
    
    /**
     * Initialise a new processor with the input log file at the data source
     * 
     * @param logFile 
     */
    public LogProcessor(Path logFile) {
        this.logFile = logFile;
        
        this.setDaemon(false);
        this.setName("Log Reading Thread");
    }
    
    /**
     * Start listening for changes in the log file
     */
    @Override
    public void start() {
        try {
            RUNNING = true;
            
            this.watcher = FileSystems.getDefault().newWatchService();
            this.key = logFile.getParent().register(watcher, ENTRY_MODIFY);
            super.start();
            
        } catch(Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    /**
     * Stop running the listening thread
     */
    public void stopRunning() {
        RUNNING = false;
    }
    
    /**
     *  Run the thread continually listening for changes to the log file
     */
    @Override
    public void run() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        while(RUNNING) {
            try {
                WatchKey wKey = watcher.take();
                
                for(WatchEvent<?> event : wKey.pollEvents()) {
                    Path changedFile = (Path) event.context();
                    
                    if (changedFile.endsWith(logFile.getFileName())) {
                        parseLine(executor);
                    }
                }
                wKey.reset();
                
            } catch(Exception excep) {
                excep.printStackTrace(System.out);
            }
        }
        
        executor.shutdownNow();
    }
    
    /**
     * Attempts to parse the last line of the log file into an actual Request object before pooling it. Include a timeout
     * on the parsing logic in case it takes ages for a IP location to be found.
     * 
     * @param executor executor service
     * @throws Exception 
     */
    private void parseLine(ExecutorService executor) throws Exception {
        String lastLine = getLastLine();
        if(lastLine == null || lastLine.trim().isEmpty()) return;
        
        if(lastLine.contains(": Invalid user")
                || lastLine.contains(": Failed password for")
                || lastLine.contains(": Accepted password for")) {
            
            String timeStr = lastLine.split("localhost")[0].trim();
            String ipStr = lastLine.split("from")[1].split("port")[0].trim();
            boolean approved = lastLine.contains("Accepted");
            
            Request request = new Request(ipStr, timeStr, approved);
            Future<Boolean> future = executor.submit(request);
            
            if(future.get(TIME_OUT, TimeUnit.SECONDS)) {
                RequestPool.addNewRequest(request);
            }
        }
    }
    
    /**
     * Returns the last line of the log file
     * 
     * @return last line
     */
    private String getLastLine() {
        RandomAccessFile ramFile = null;

        try {
            ramFile = new RandomAccessFile(logFile.toString(), "r");
            long fileLength = ramFile.length() - 1;
            StringBuilder sb = new StringBuilder();

            for (long fp = fileLength; fp != -1; fp--) {
                ramFile.seek(fp);
                int readByte = ramFile.readByte();

                if (readByte == 0xA) {
                    if (fp == fileLength) continue;
                    break;

                } else if (readByte == 0xD) {
                    if (fp == fileLength - 1) continue;
                    break;
                }

                sb.append((char) readByte);
            }

            return sb.reverse().toString();
            
        } catch (Exception excep) {
            excep.printStackTrace(System.out);
            return null;
            
        } finally {
            if (ramFile != null) {
                try {
                    ramFile.close();
                } catch (IOException e) { }
            }
        }
    }
    
}
// End of class