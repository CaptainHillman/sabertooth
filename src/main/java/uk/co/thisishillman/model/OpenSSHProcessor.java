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
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Reads SSH logs and build AccessAttempt objects
 * 
 * @author M Hillman
 */
public class OpenSSHProcessor extends AbstractLogProcessor {
    
    /**
     * Initialise a OpenSSH specific processor with the input log file at the data source
     * 
     * @param logFile 
     */
    public OpenSSHProcessor(Path logFile) {
        super(logFile);
    }
    
    /**
     * Attempts to parse the last line of the log file into an actual AccessAttempt object before pooling it. Include a timeout
     * on the parsing logic in case it takes ages for a IP location to be found.
     * 
     * @param executor executor service
     * @throws Exception 
     */
    @Override
    protected void parseLine(ExecutorService executor, String line) throws Exception {
        if(line == null || line.trim().isEmpty()) return;
        
        if(line.contains(": Invalid user")
                || line.contains(": Failed password for")
                || line.contains(": Accepted password for")) {
            
            String timeStr = line.split("localhost")[0].trim();
            String ipStr = line.split("from")[1].split("port")[0].trim();
            String userStr = line.split("for ")[1].split(" from")[0].trim();
            boolean approved = line.contains("Accepted");
            
            AccessAttempt attempt = new AccessAttempt();
            attempt.setIP(ipStr);
            attempt.setTime(timeStr);
            attempt.setApproved(approved);
            attempt.setUsername(userStr);
            
            if(!requests.contains(attempt)) {
            
                Future<Boolean> future = executor.submit(attempt);

                if(future.get(TIME_OUT, TimeUnit.SECONDS)) {
                    if(mapPanel != null && !isInternal(attempt.getSource().getIp())) {
                        mapPanel.addAttempt(attempt);
                    }

                    appendToPane(attempt.toString(), (attempt.wasApproved()) ? Color.GREEN : Color.GRAY);
                    requests.add(attempt);
                }
            }
        }
    }
    
}
// End of class