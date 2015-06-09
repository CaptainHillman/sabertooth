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

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import uk.co.thisishillman.Main;
import uk.co.thisishillman.model.BaseLogProcessor;
import uk.co.thisishillman.ui.utils.SizingUtils;

/**
 * Main JFrame containing UI components
 * 
 * @author M Hillman
 */
public class MainFrame extends JFrame {

    // Current SSH log processor
    private BaseLogProcessor logProcessor;
    
    /**
     * Creates a new MainFrame instance, initialising Swing components
     */
    public MainFrame() {
        LaFHandler.setNimbusTheme(this);
        LaFHandler.setIconImages(this);
        
        initComponents();
        SizingUtils.sizeToScreen(this, 90.0);
    }
    
    /** 
     * Launches dialog with UI components to help user choose log file and processor type, then proceeds to start monitoring
     * and swap out UI components as needed.
     */
    private void startMonitoring() {
        LogDialog dialog = new LogDialog(this);
        SizingUtils.centerInSameScreen(this, dialog);
        dialog.setVisible(true);
        
        logProcessor = dialog.getChosenProcessor();
        
        if(logProcessor != null) {
            mainContainer.removeAll();
            mainContainer.add(tabbedPane, BorderLayout.CENTER);
            mainContainer.repaint();
        }
    }
    
    // Netbeams GUI builder shizzle, here be dragons
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        mapContainer = new javax.swing.JPanel();
        pieContainer = new javax.swing.JPanel();
        lineContainer = new javax.swing.JPanel();
        mainContainer = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        monitorItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        showTerminal = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutItem = new javax.swing.JMenuItem();
        websiteItem = new javax.swing.JMenuItem();

        tabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tabbedPane.setToolTipText(null);
        tabbedPane.setFont(LaFHandler.GULIM);

        mapContainer.setBackground(new java.awt.Color(255, 255, 255));
        mapContainer.setLayout(new java.awt.BorderLayout());
        tabbedPane.addTab("World Map", mapContainer);

        pieContainer.setBackground(new java.awt.Color(255, 255, 255));
        pieContainer.setLayout(new java.awt.BorderLayout());
        tabbedPane.addTab("Attempts by Country", pieContainer);

        lineContainer.setBackground(new java.awt.Color(255, 255, 255));
        lineContainer.setLayout(new java.awt.BorderLayout());
        tabbedPane.addTab("Attempts by Time", lineContainer);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(Main.PRODUCT_NAME);
        setMaximumSize(new java.awt.Dimension(9999, 9999));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainContainer.setBackground(new java.awt.Color(255, 255, 255));
        mainContainer.setLayout(new java.awt.BorderLayout());

        welcomeLabel.setText("welcome!");
        mainContainer.add(welcomeLabel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainContainer, java.awt.BorderLayout.CENTER);

        menuBar.setFont(LaFHandler.GULIM);

        fileMenu.setText("File");
        fileMenu.setFont(LaFHandler.GULIM);

        monitorItem.setFont(LaFHandler.GULIM);
        monitorItem.setText("Start Monitoring");
        monitorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitorItemActionPerformed(evt);
            }
        });
        fileMenu.add(monitorItem);

        exitItem.setFont(LaFHandler.GULIM);
        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        viewMenu.setText("View");
        viewMenu.setFont(LaFHandler.GULIM);

        showTerminal.setFont(LaFHandler.GULIM);
        showTerminal.setSelected(true);
        showTerminal.setText("Show Terminal");
        showTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTerminalActionPerformed(evt);
            }
        });
        viewMenu.add(showTerminal);

        menuBar.add(viewMenu);

        helpMenu.setText("Help");
        helpMenu.setFont(LaFHandler.GULIM);

        aboutItem.setFont(LaFHandler.GULIM);
        aboutItem.setText("About");
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutItem);

        websiteItem.setFont(LaFHandler.GULIM);
        websiteItem.setText("View Website");
        websiteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                websiteItemActionPerformed(evt);
            }
        });
        helpMenu.add(websiteItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        if(BaseLogProcessor.RUNNING) {
            int answer = JOptionPane.showConfirmDialog(this, 
                    "Stop monitoring & close the application?", "Close?", JOptionPane.YES_NO_OPTION);
            
            if(answer != JOptionPane.YES_OPTION) return;
            logProcessor.stopRunning();
        }
        
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void monitorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitorItemActionPerformed
        if(BaseLogProcessor.RUNNING) {
            monitorItem.setText("Start Monitoring");
            logProcessor.stopRunning();
        } else {
            startMonitoring();
            if(BaseLogProcessor.RUNNING) monitorItem.setText("Stop Monitoring");
        }
    }//GEN-LAST:event_monitorItemActionPerformed

    private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemActionPerformed
        AboutDialog dialog = new AboutDialog(this);
        SizingUtils.centerInSameScreen(this, dialog);
        dialog.setVisible(true);
    }//GEN-LAST:event_aboutItemActionPerformed

    private void websiteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_websiteItemActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("http://www.thisishillman.co.uk"));
            } catch (IOException | URISyntaxException e) {
                JOptionPane.showMessageDialog(this, "Cannot open website URL in default browser, please check your internet connection.", 
                        "Cannot Open URL!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_websiteItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        exitItemActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    private void showTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTerminalActionPerformed
        //
    }//GEN-LAST:event_showTerminalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel lineContainer;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JPanel mapContainer;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem monitorItem;
    private javax.swing.JPanel pieContainer;
    private javax.swing.JCheckBoxMenuItem showTerminal;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JMenu viewMenu;
    private javax.swing.JMenuItem websiteItem;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables

}
// End of class