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
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import uk.co.thisishillman.model.LogProcessor;

/**
 *
 * @author Michael
 */
public class MainFrame extends JFrame {

    //
    private MainPanel mainPanel;
    
    /**
     * Initialise a new MainFrame, setting Look and Feel stuff.
     */
    public MainFrame() {
        initComponents();
        
        this.mainPanel = new MainPanel();
        
        LaFHandler.setNimbusTheme(this);
        LaFHandler.setIconImages(this);
    }

    // GUI builder shizzle
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainContainer = new javax.swing.JPanel();
        startPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        buttonLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        startItem = new javax.swing.JMenuItem();
        stopItem = new javax.swing.JMenuItem();
        fileItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        showTerminal = new javax.swing.JCheckBoxMenuItem();
        showSettings = new javax.swing.JCheckBoxMenuItem();
        showMap = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutItem = new javax.swing.JMenuItem();
        websiteItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Things 'n' Stuff (v0.1)");
        setMaximumSize(new java.awt.Dimension(9999, 9999));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainContainer.setBackground(new java.awt.Color(255, 255, 255));
        mainContainer.setLayout(new java.awt.BorderLayout());

        startPanel.setBackground(new java.awt.Color(255, 255, 255));
        startPanel.setLayout(new java.awt.GridBagLayout());

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/padlock.png"))); // NOI18N
        logoLabel.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.75;
        startPanel.add(logoLabel, gridBagConstraints);

        buttonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button.png"))); // NOI18N
        buttonLabel.setToolTipText(null);
        buttonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonLabelMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 0.25;
        startPanel.add(buttonLabel, gridBagConstraints);

        mainContainer.add(startPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainContainer, java.awt.BorderLayout.CENTER);

        menuBar.setFont(LaFHandler.GULIM);

        fileMenu.setText("File");
        fileMenu.setFont(LaFHandler.GULIM);

        startItem.setFont(LaFHandler.GULIM);
        startItem.setText("Start Monitoring");
        startItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startItemActionPerformed(evt);
            }
        });
        fileMenu.add(startItem);

        stopItem.setFont(LaFHandler.GULIM);
        stopItem.setText("Stop Monitoring");
        stopItem.setEnabled(false);
        stopItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopItemActionPerformed(evt);
            }
        });
        fileMenu.add(stopItem);

        fileItem.setFont(LaFHandler.GULIM);
        fileItem.setText("Change Log File");
        fileItem.setEnabled(false);
        fileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileItemActionPerformed(evt);
            }
        });
        fileMenu.add(fileItem);

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

        showSettings.setFont(LaFHandler.GULIM);
        showSettings.setSelected(true);
        showSettings.setText("Show Settings");
        showSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSettingsActionPerformed(evt);
            }
        });
        viewMenu.add(showSettings);

        showMap.setFont(LaFHandler.GULIM);
        showMap.setSelected(true);
        showMap.setText("Show Visualisation");
        showMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMapActionPerformed(evt);
            }
        });
        viewMenu.add(showMap);

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

    private void buttonLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLabelMouseEntered
        buttonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button_hover.png"))); 
    }//GEN-LAST:event_buttonLabelMouseEntered

    private void buttonLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLabelMouseExited
        buttonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button.png")));
    }//GEN-LAST:event_buttonLabelMouseExited

    private void buttonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLabelMouseClicked
//        JFileChooser chooser = new JFileChooser();
//        chooser.setApproveButtonText("Monitor");
//        
//        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            if(chooser.getSelectedFile() == null || chooser.getSelectedFile().isDirectory()) return;
            
            //LogProcessor processor = new LogProcessor(Paths.get(chooser.getSelectedFile().getAbsolutePath()));
            
            mainContainer.removeAll();
            mainContainer.add(mainPanel, BorderLayout.CENTER);
            
            //mainPanel.startMonitoring(processor);
            mainContainer.revalidate();
            mainContainer.repaint();
            
            startItem.setEnabled(false);
            stopItem.setEnabled(true);       
//        }
    }//GEN-LAST:event_buttonLabelMouseClicked

    private void stopItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopItemActionPerformed
        LogProcessor.RUNNING = false;
        
        startItem.setEnabled(true);
        stopItem.setEnabled(false);    
    }//GEN-LAST:event_stopItemActionPerformed

    private void fileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileItemActionPerformed
        if(LogProcessor.RUNNING) {
            int answer = JOptionPane.showConfirmDialog(this, 
                    "Change the source log file?", "Change Log?", JOptionPane.YES_NO_OPTION);
            
            if(answer != JOptionPane.YES_OPTION) return;
            
            mainPanel.stopMonitoring();
            buttonLabelMouseClicked(null);
        }
    }//GEN-LAST:event_fileItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        if(LogProcessor.RUNNING) {
            int answer = JOptionPane.showConfirmDialog(this, 
                    "Stop monitoring & close the application?", "Close?", JOptionPane.YES_NO_OPTION);
            
            if(answer != JOptionPane.YES_OPTION) return;
            
            mainPanel.stopMonitoring();
        }
        
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void startItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startItemActionPerformed
        buttonLabelMouseClicked(null);
    }//GEN-LAST:event_startItemActionPerformed

    private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemActionPerformed
        AboutDialog dialog = new AboutDialog(this);
        dialog.setLocationRelativeTo(null);
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
        mainPanel.updateUI(showTerminal.isSelected(), showSettings.isSelected(), showMap.isSelected());
    }//GEN-LAST:event_showTerminalActionPerformed

    private void showSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSettingsActionPerformed
        mainPanel.updateUI(showTerminal.isSelected(), showSettings.isSelected(), showMap.isSelected());
    }//GEN-LAST:event_showSettingsActionPerformed

    private void showMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMapActionPerformed
        mainPanel.updateUI(showTerminal.isSelected(), showSettings.isSelected(), showMap.isSelected());
    }//GEN-LAST:event_showMapActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JLabel buttonLabel;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenuItem fileItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JCheckBoxMenuItem showMap;
    private javax.swing.JCheckBoxMenuItem showSettings;
    private javax.swing.JCheckBoxMenuItem showTerminal;
    private javax.swing.JMenuItem startItem;
    private javax.swing.JPanel startPanel;
    private javax.swing.JMenuItem stopItem;
    private javax.swing.JMenu viewMenu;
    private javax.swing.JMenuItem websiteItem;
    // End of variables declaration//GEN-END:variables

}
// End of class