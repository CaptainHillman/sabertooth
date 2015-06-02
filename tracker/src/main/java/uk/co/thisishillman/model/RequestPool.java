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

import java.util.ArrayList;
import java.util.List;

/**
 * Pool for SSH access attempts
 * 
 * @author M Hillman
 */
public class RequestPool {
    
    // List of un-visualised requests, sorted by date/time
    private static final List<Request> REQUESTS_UNVISED = new ArrayList<>();
    
    // List of visualised requests, sorted by date/time
    private static final List<Request> REQUESTS_VISED   = new ArrayList<>();

    /**
     * Add a new request object (as long as it's not a duplicate) to the pool.
     * 
     * @param req
     */
    public static void addNewRequest(Request req) {
        if(REQUESTS_UNVISED.contains(req) || REQUESTS_VISED.contains(req)) return;
        REQUESTS_UNVISED.add(req);
    }

    /**
     * Returns the next un-processed request.
     * 
     * @return Next request, null if none remaining 
     */
    public static Request getNextRequest() {
        if(REQUESTS_UNVISED.isEmpty()) return null;
        
        Request request = REQUESTS_UNVISED.get(0);
        REQUESTS_UNVISED.remove(0);
        REQUESTS_VISED.add(request);
        
        return request;
    }
    
}
// End of class