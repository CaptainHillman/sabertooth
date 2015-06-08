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

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import org.apache.commons.io.IOUtils;
import uk.co.thisishillman.Settings;
import uk.co.thisishillman.ui.MapPanel;

/**
 * Reads SSH logs and build AccessAttempt objects
 * 
 * @author M Hillman
 */
public abstract class AbstractLogProcessor extends Thread {
    
    // Time out on single request process
    public static final int TIME_OUT = 100;
    
    // Running flag
    public static volatile boolean RUNNING;
    
    // To stop duplicates
    protected final List<AccessAttempt> requests;
    
    // Location of log file
    protected final Path logFile;
    
    // WatchService
    protected WatchService watcher;
    
    // Destination for text output
    protected JTextPane terminal;
    
    // Map Panel
    protected MapPanel mapPanel;
    
    /**
     * Initialise a new processor with the input log file at the data source
     * 
     * @param logFile 
     */
    public AbstractLogProcessor(Path logFile) {
        this.logFile = logFile;
        this.requests = new ArrayList<>();
        
        this.setDaemon(false);
        this.setName("Log Reading Thread");
    }
    
    /**
     * 
     * @param terminal 
     */
    public void setTextDestination(JTextPane terminal) {
        this.terminal = terminal;
    }
    
    /**
     * 
     * @param mapPanel
     */
    public void addMapPanel(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
    }
    
    /** 
     * Returns a list of SSH access attempts
     * @return 
     */
    public List<AccessAttempt> getAttempts() {
        return this.requests;
    }
    
    /**
     * Start listening for changes in the log file
     */
    @Override
    public void start() {
        try {
            RUNNING = true;
            
            this.watcher = FileSystems.getDefault().newWatchService();
            logFile.getParent().register(watcher, ENTRY_MODIFY);
            super.start();
            
        } catch(Exception e) {
            stopRunning();
            
            JOptionPane.showMessageDialog(null, "Cannot start file reading process, please check file permissions!", 
                    "Read Error!", JOptionPane.ERROR_MESSAGE);
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
        
        if(Boolean.parseBoolean(Settings.getSetting("back_date"))) {
            backDate(executor);
            appendToPane("Information already present in SSH log file successfully added.", Color.BLACK);
        }
        
        appendToPane("Live SSH log monitoring successfully started.", Color.BLACK);
        
        while(RUNNING) {
            try {
                
                WatchKey wKey = watcher.take();
                
                for(WatchEvent<?> event : wKey.pollEvents()) {
                    Path changedFile = (Path) event.context();

                    if (changedFile.endsWith(logFile.getFileName())) {
                        parseLine(executor, getLastLine());
                    }
                }
                
                wKey.reset();
                
            } catch(Exception excep) {
                
            }
        }
        executor.shutdownNow();
        
        appendToPane("Live SSH log monitoring shut down successfully.", Color.BLACK);
        appendToPane("", Color.WHITE);
    }
    
    /**
     * @param executor
     */
    protected void backDate(ExecutorService executor) {
       BufferedReader reader = null;
       InputStreamReader stream = null;
       FileInputStream fileStream = null;
               
       try {
           fileStream = new FileInputStream(logFile.toString());
           stream = new InputStreamReader(fileStream, "UTF-8");
           reader = new BufferedReader(stream);
           
           String line = null;
           
           while((line = reader.readLine()) != null) {
               parseLine(executor, line);
           }
           
       } catch(Exception excep) {
           // Error reporting
           
       } finally {
           if(fileStream != null) IOUtils.closeQuietly(fileStream);
           if(stream != null) IOUtils.closeQuietly(stream);
           if(reader != null) IOUtils.closeQuietly(reader);
       }
    }
    
    /**
     * Test that the input source text fulfils the input Regex pattern
     *
     * @param ip 
     * @return
     */
    protected boolean isInternal(String ip) {
        Pattern ptrn = Pattern.compile("((10|127|(22[4-9]|23[0-9]))|(192\\.168|169\\.254)|(172\\.(1[6-9]|2[0-9]|3[0-1])))\\..*");
        Matcher mtch = ptrn.matcher(ip);
        
        boolean find = mtch.find();
        if(find) {
            return mtch.group().equals(ip);
        }
        return false;
    }

    /**
     * 
     * @param msg
     * @param c 
     */
    protected void appendToPane(String msg, Color c) {
        if(terminal == null) return;
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_LEFT);

        int len = terminal.getDocument().getLength();
        terminal.setCaretPosition(len);
        terminal.setCharacterAttributes(aset, false);
        terminal.replaceSelection(msg + "\n");
    }
    
    /**
     * Returns the last line of the log file
     * 
     * @return last line
     */
    protected String getLastLine() {
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
    
    /**
     * Attempts to parse the last line of the log file into an actual AccessAttempt object before pooling it. Include a timeout
     * on the parsing logic in case it takes ages for a IP location to be found.
     * 
     * @param executor executor service
     * @param line
     * 
     * @throws Exception
     */
    protected abstract void parseLine(ExecutorService executor, String line) throws Exception;
    
}
// End of class