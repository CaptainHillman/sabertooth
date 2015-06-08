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
package uk.co.thisishillman.ui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;

/**
 * This class handles applying the Nimbus look and feel and window icons.
 */
public final class LaFHandler {
    
    // Custom font
    public static Font GULIM = new Font("Tahoma", Font.PLAIN, 11);
    
    static {
        try {
            InputStream fontStream = LaFHandler.class.getClass().getResource("/gulim.ttc").openStream();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            GULIM = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GULIM = GULIM.deriveFont(11.0f);
            ge.registerFont(GULIM);
            
       } catch (IOException | FontFormatException e) {
            //Handle exception
       }
    }
    
    
    /** 
     * Sets the icons for a given JFrame.
     * 
     * @param window AWT Window to set icons for. 
     */
    public static void setIconImages(Window window) {
        List<Image> imageList = new ArrayList<>();
        imageList.add(new ImageIcon(LaFHandler.class.getClass().getResource("/logo_16.png")).getImage());
        imageList.add(new ImageIcon(LaFHandler.class.getClass().getResource("/logo_32.png")).getImage());
        imageList.add(new ImageIcon(LaFHandler.class.getClass().getResource("/logo_64.png")).getImage());
        window.setIconImages(imageList);  
    }
    
    /** 
     * Sets the Nimbis Theme for the provided JFrame.
     * 
     * @param window AWT Window to apply Nimbus theme to.
     */
    public static void setNimbusTheme(Window window) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.updateComponentTreeUI(window);
                    window.pack();
                    break;
                }
            }
            Object fontDefinition = new UIDefaults.ProxyLazyValue("javax.swing.plaf.FontUIResource", null, new Object[] {"dialog", new Integer(Font.PLAIN), new Integer(11)});
            Enumeration keys = UIManager.getDefaults().keys();
            while(keys.hasMoreElements()) {
                Object key = keys.nextElement();
                Object value = UIManager.get(key);
                if(value instanceof FontUIResource) {
                    UIManager.put(key, fontDefinition);
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exp) {
            JOptionPane.showMessageDialog(window, "Cannot apply GUI Theme, reverting to default theme.", "Error in GUI theme...", JOptionPane.WARNING_MESSAGE);
            setDefaultTheme(window);
        }      
        
        window.repaint();
    }
    
    /** 
     * Reverts to Java's default look and feel (Metal), only to be used when loading the Nimbus
     * theme throws and exception.
     * 
     * @param frame JFrame to apply Metal theme to.
     */
    private static void setDefaultTheme(Window window) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if("Metal".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.updateComponentTreeUI(window);
                    window.pack();
                    break;
                }
            }
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exp) {
            exp.printStackTrace(System.out);
        }
    }
    
}
// End of class