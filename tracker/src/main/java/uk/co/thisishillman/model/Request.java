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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * Represents a single SSH access attempt with functionality to parse input strings into time & location data.
 * 
 * @author M Hillman
 */
public class Request implements Callable<Boolean> {
    
    // Unprocessed source strings
    private final String stringIP, stringTime;
    
    // Time of attempt (GMT)
    private GregorianCalendar time;
    
    // Source of attempt
    private IPLocation source;
    
    // Was request approved
    private boolean approved;

    /**
     * Initialise a new (un-processed) request with the input details.
     * 
     * @param stringIP un-parsed IP string from log file
     * @param stringTime un-parsed time string from log file
     * @param approved true if the attempt was approved
     */
    public Request(String stringIP, String stringTime, boolean approved) {
        this.stringIP = stringIP;
        this.stringTime = stringTime;
        this.approved = approved;
    }
    
    /**
     * @return the time of the attempt
     */
    public GregorianCalendar getTime() {
        if(time == null) {
            time = new GregorianCalendar();
        }
        return time;
    }

    /**
     * @param time set the time of the attempt
     */
    public void setTime(GregorianCalendar time) {
        this.time = time;
    }

    /**
     * @return the source of the attempt
     */
    public IPLocation getSource() {
        if(source == null) {
            source = new IPLocation();
        }
        return source;
    }

    /**
     * @param source set the source of the attempt
     */
    public void setSource(IPLocation source) {
        this.source = source;
    }
    
    /**
     * @return the approved
     */
    public boolean wasApproved() {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * Attempt to parse the strings taken from the log file into time of request and location of request data objects
     * 
      * @return true if parsing successful 
     */
    @Override
    public Boolean call() {
        try {
            // Build and store request's time and location
            String reqIP   = stringIP;
            String reqTime = stringTime;

            SimpleDateFormat formatter = new SimpleDateFormat("MMM  dd hh:mm:ss");
            GregorianCalendar date = new GregorianCalendar();
            date.setTime(formatter.parse(reqTime));

            int year   = date.get(Calendar.YEAR);
            int month  = date.get(Calendar.MONTH);
            int day    = date.get(Calendar.DAY_OF_MONTH);
            int hour   = date.get(Calendar.HOUR_OF_DAY);
            int minute = date.get(Calendar.MINUTE);

            GregorianCalendar ipTime = new GregorianCalendar();
            ipTime.set(year, month, day, hour, minute, 0);
            setTime(ipTime);

            IPLocation ipSource = new IPLocation();
            ipSource.locate(reqIP);
            setSource(ipSource);
            
        } catch(ParseException | IOException excep) {
            excep.printStackTrace(System.out);
        }
        
        return true;
    }
    
    /**
     * Standard equals comparison
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if( !(obj instanceof Request) ) return false;
        
        Request req = (Request) obj;
        
        if( this.approved != req.wasApproved() ) return false;
        if( !this.getTime().equals(req.getTime()) ) return false;
        if( !this.getSource().equals(req.getSource()) ) return false;
        
        return true;
    }

    /**
     * Generate hash code
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.approved);
        hash = 37 * hash + Objects.hashCode(this.time);
        hash = 37 * hash + Objects.hashCode(this.source);
        return hash;
    }

    /**
     * Return string
     * 
     * @return 
     */
    @Override
    public String toString() {
        String timeString = new SimpleDateFormat("MMM dd hh:mm:ss").format(time.getTime());
        return ((approved) ? "Accepted: " : "Denied: ") + source.toString() + " on " + timeString;
    }

}
//End of class