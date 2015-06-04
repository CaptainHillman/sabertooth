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
import uk.co.thisishillman.Main;

/**
 * Represents a location in the world from which an IP originates
 * 
 * @author M Hillman
 */
public class IPLocation {
    
    // Geo IP database
    public static File GEO_DB;
    
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
    
    // Static initialiser 
    static {
        GEO_DB = new File(Main.EXEC_DIR + File.separator + "GeoLiteCity.dat");
    }
    
    /**
     * Use the GeoIP API to determine a location for the access request
     * 
     * @param ip
     * @throws IOException 
     */
    public void locate(String ip) throws IOException {
        this.setIp(ip);
        
        LookupService lookup = new LookupService(GEO_DB, LookupService.GEOIP_MEMORY_CACHE);
        Location location = lookup.getLocation(ip);

        if(location != null) {
            this.setCountry(location.countryName);
            this.setRegion(location.region);
            this.setCity(location.city);
            this.setLatitude(location.latitude);
            this.setLongitude(location.longitude);
        }
    }
    
    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
        
        if( this.getLatitude() != location.getLatitude() ) return false;
        if( this.getLongitude() != location.getLongitude() ) return false;
        
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
        hash = 37 * hash + Objects.hashCode(this.getIp());
        hash = 37 * hash + Objects.hashCode(this.getCountry());
        hash = 37 * hash + Objects.hashCode(this.getRegion());
        hash = 37 * hash + Objects.hashCode(this.getCity());
        
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.getLatitude()) ^ 
                (Double.doubleToLongBits(this.getLatitude()) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.getLongitude()) ^ 
                (Double.doubleToLongBits(this.getLongitude()) >>> 32));
        
        return hash;
    }
    
    /**
     * Return as formatted string
     * 
     * @return 
     */
    @Override
    public String toString() {
        String latStr = String.format("%.3f", getLatitude());
        String longStr = String.format("%.3f", getLongitude());
        return (getIp() + " (" + getCountry() + ", " + getRegion() + ", " + getCity() + " - " + latStr + " by " + longStr + ")");
    }
    
}
// End of class