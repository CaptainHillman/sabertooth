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

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Represents a location in the world from which an IP originates
 * 
 * @author M Hillman
 */
public class IPLocation {
    
    // Geo IP database
    public static final File GEO_DB = new File("D:\\Repositories\\china\\tracker\\GeoLiteCity.dat");
    
    // IP address
    private String ip = "0.0.0.0";
    
    // Country
    private String country = "Unknown Country";
    
    // Region
    private String region = "Unknown Region";
    
    // City
    private String city = "Unknown City";
    
    // Latitude
    private double latitude;
    
    // Longitude
    private double longitude;
    
    /**
     * Use the GeoIP API to determine a location for the access request
     * 
     * @param ip
     * @throws IOException 
     */
    public void locate(String ip) throws IOException {
        this.ip = ip;
        
        LookupService lookup = new LookupService(GEO_DB, LookupService.GEOIP_MEMORY_CACHE);
        Location location = lookup.getLocation(ip);
        
        this.country   = location.countryName;
        this.region    = location.region;
        this.city      = location.city;
        this.latitude  = location.latitude;
        this.longitude = location.longitude;
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
        if( !(obj instanceof IPLocation) ) return false;
        
        IPLocation location = (IPLocation) obj;
        
        if( !this.ip.equals(location.ip) ) return false;
        if( !this.country.equals(location.country) ) return false;
        if( !this.region.equals(location.region) ) return false;
        if( !this.city.equals(location.city) ) return false;
        
        if( this.latitude != location.latitude ) return false;
        if( this.longitude != location.longitude ) return false;
        
        return true;
    }

    /**
     * Generate hash code
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.ip);
        hash = 37 * hash + Objects.hashCode(this.country);
        hash = 37 * hash + Objects.hashCode(this.region);
        hash = 37 * hash + Objects.hashCode(this.city);
        
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ 
                (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ 
                (Double.doubleToLongBits(this.longitude) >>> 32));
        
        return hash;
    }
    
    /**
     * Return as formatted string
     * 
     * @return 
     */
    @Override
    public String toString() {
        String latStr = String.format("%.3f", latitude);
        String longStr = String.format("%.3f", longitude);
        return (ip + " (" + country + ", " + region + ", " + city + " - " + latStr + " by " + longStr + ")");
    }
    
}
// End of class