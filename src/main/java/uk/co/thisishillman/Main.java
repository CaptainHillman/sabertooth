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

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;
import uk.co.thisishillman.ui.MainFrame;

/**
 * Main entry class.
 * 
 * @author M Hillman
 */
public class Main {
    
    // Product name
    public static final String PRODUCT_NAME = "Sabertooth SSH Tracker";
   
    // Version number
    public static final String VERSION = "1.0";
    
    // Absolute location to execution directory
    public static String EXEC_DIR;
    
    /** 
      * Determines the execution directory. NetBeans runs it's jars from a 'target' sub-folder, 
     * this method detects that & adjusts the execution directory accordingly.
     */
    private static void determineExecutionDirectory() {
        try {
            URI location = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI();
            if(new File(location).getParentFile().getName().equals("target")) {
                Main.EXEC_DIR = new File(location).getParentFile().getParentFile().getAbsolutePath();
                
            } else {
                Main.EXEC_DIR = new File(location).getParentFile().getAbsolutePath();
            }
            
        } catch(URISyntaxException excep) {
            JOptionPane.showMessageDialog(null, "Cannot determine execution directory, fatal error!", 
                    "Fatal Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }
    
    /**
     * Main entry point to code, launches a new MainFrame
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        determineExecutionDirectory();
                
        MainFrame mainFrame = new MainFrame();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
    
}
// End of class.