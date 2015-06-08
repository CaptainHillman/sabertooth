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
package uk.co.thisishillman;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.apache.commons.io.IOUtils;

/**
 * Holds user settings in properties object
 * 
 * @author M Hillman
 */
public class Settings {
    
    // Properties object
    private static final Properties properties;
    
    // Location of properties file
    private static final Path propertiesPath;
    
    // Initialise static variables
    static {
        properties = new Properties();
        propertiesPath = Paths.get(Main.EXEC_DIR, "settings.ini");
        readProperties();
    }
    
    /**
     * Return user setting (or null if not present);
     * 
     * @param key
     * @return 
     */
    public static String getSetting(String key) {
        return properties.getProperty(key, null);
    }
    
    /**
     * Store user setting & write file
     * 
     * @param key
     * @param value 
     */
    public static void putSetting(String key, String value) {
        properties.put(key, value);
        writeProperties();
    }
    
    /**
     * Attempt to read any pre-existing settings file
     */
    private static void readProperties() {
        if(!Files.exists(propertiesPath, LinkOption.NOFOLLOW_LINKS)) return;
        
        FileReader reader = null;
        
        try {
            reader = new FileReader(propertiesPath.toString());
            properties.load(reader);
        } catch(IOException ioExcep) {
            // Cannot read file, go with blank properties
        } finally {
            if(reader != null) IOUtils.closeQuietly(reader);
        }
    }
    
    /** 
     * Attempt to write properties to disk
     */
    private static void writeProperties() {
        FileOutputStream stream = null;
        
        try {
            stream = new FileOutputStream(propertiesPath.toString());
            properties.store(stream, "--- User Settings ---");
            
        } catch (IOException ex) {
            // Just don't write stuff
        } finally {
            if(stream != null) IOUtils.closeQuietly(stream);
        }
    }
    
}
// End of class.