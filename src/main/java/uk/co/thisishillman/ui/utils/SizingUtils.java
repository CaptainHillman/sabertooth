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
package uk.co.thisishillman.ui.utils;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Window;

/**
 * Misc frame/dialog sizing utils
 * 
 * @author M Hillman
 */
public final class SizingUtils {

    /**
     * Centre the input child window in the same screen as the parent window
     * 
     * @param parent parent window
     * @param child child window
     */
    public static void centerInSameScreen(Window parent, Window child) {
        int parentX = parent.getLocationOnScreen().x;
        int parentY = parent.getLocationOnScreen().y;

        int parentCenterX = parentX + (parent.getWidth() / 2);
        int parentCenterY = parentY + (parent.getHeight() / 2);
        
        child.setLocation(
                parentCenterX - (child.getWidth() / 2),
                parentCenterY - (child.getHeight() / 2)
        );
        
        child.revalidate();
        child.repaint();
    } 
    
    /**
     * Scale the input window so that it's the input percent of it's current screen. If the resulting
     * window size is less that it's minimum then that is used, likewise for it's maximum.
     * 
     * @param window window to resize
     * @param percent percent of screen to use up (0.0 to 100.0)
     */
    public static void sizeToScreen(Window window, double percent) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        int width  = (int) (screenSize.getWidth() * (percent / 100.0));
        int height = (int) (screenSize.getHeight() * (percent / 100.0));
        
        if(width < window.getMinimumSize().width || height < window.getMinimumSize().height) {
            window.setPreferredSize(window.getMinimumSize());
            window.setSize(window.getMinimumSize());
            
        } else if(width > window.getMaximumSize().width || height > window.getMaximumSize().height) {
            window.setPreferredSize(window.getMaximumSize());
            window.setSize(window.getMaximumSize());
            
        } else {
            window.setPreferredSize(new Dimension(width, height));
            window.setSize(new Dimension(width, height));
        }
        
        window.revalidate();
        window.repaint();
    } 
    
}
//End of class.