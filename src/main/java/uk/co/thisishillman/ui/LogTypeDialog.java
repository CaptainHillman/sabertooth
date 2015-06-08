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

import java.awt.Dialog.ModalityType;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import uk.co.thisishillman.Settings;

/**
 *
 * @author Michael
 */
public class LogTypeDialog extends JDialog {

    /**
     * Tick box selection state
     */
    private boolean ticked = true;
    
    /**
     * 
     * @param parent 
     */
    public LogTypeDialog(Frame parent) {
        super(parent, ModalityType.APPLICATION_MODAL);
        
        LaFHandler.setIconImages(this);
        LaFHandler.setNimbusTheme(this);
        initComponents();
        
        if(Settings.getSetting("back_date") == null) Settings.putSetting("back_date", "true");
        
        ticked = Boolean.parseBoolean(Settings.getSetting("back_date"));
        if(ticked) {
            tickLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick_on.png")));
        } else {
            tickLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick_off.png")));
        }
    }
    
    public static void main(String[] args) {
        LogTypeDialog dialog = new LogTypeDialog(null);
        
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        descLabel = new javax.swing.JLabel();
        toolkitLabel = new javax.swing.JLabel();
        toolkitBox = new javax.swing.JComboBox();
        backdateLabel = new javax.swing.JLabel();
        logLabel = new javax.swing.JLabel();
        logField = new javax.swing.JTextField();
        browseButton = new javax.swing.JLabel();
        cancelLabel = new javax.swing.JLabel();
        monitorLabel = new javax.swing.JLabel();
        tickLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Monitor new log file...");
        setMaximumSize(new java.awt.Dimension(999, 999));
        setMinimumSize(new java.awt.Dimension(500, 350));
        setPreferredSize(new java.awt.Dimension(525, 390));
        setResizable(false);

        container.setBackground(new java.awt.Color(255, 255, 255));

        descLabel.setFont(LaFHandler.GULIM);
        descLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descLabel.setText("<html><p align=\"center\">To start monitoring your SSH log file please select your SSH toolkit<br>from the box below, the location of the log file and whether<br>you want to load previous data from the file.<br><br>Hit the Monitor button to start.</p></html>");
        descLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        descLabel.setMaximumSize(new java.awt.Dimension(6000, 90));
        descLabel.setMinimumSize(new java.awt.Dimension(90, 90));
        descLabel.setName(""); // NOI18N
        descLabel.setPreferredSize(new java.awt.Dimension(90, 90));

        toolkitLabel.setFont(LaFHandler.GULIM);
        toolkitLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        toolkitLabel.setText("Current SSH Toolkit");
        toolkitLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        toolkitLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        toolkitLabel.setPreferredSize(new java.awt.Dimension(200, 40));

        toolkitBox.setFont(LaFHandler.GULIM);
        toolkitBox.setForeground(new java.awt.Color(153, 0, 153));
        toolkitBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Open SSH" }));
        toolkitBox.setToolTipText(null);
        toolkitBox.setMaximumSize(new java.awt.Dimension(240, 40));
        toolkitBox.setMinimumSize(new java.awt.Dimension(240, 40));
        toolkitBox.setPreferredSize(new java.awt.Dimension(240, 40));

        backdateLabel.setFont(LaFHandler.GULIM);
        backdateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        backdateLabel.setText("Process Back-Dated Log Data?");
        backdateLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        backdateLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        backdateLabel.setPreferredSize(new java.awt.Dimension(200, 40));

        logLabel.setFont(LaFHandler.GULIM);
        logLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logLabel.setText("Location of SSH Log File");
        logLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        logLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        logLabel.setPreferredSize(new java.awt.Dimension(200, 40));

        logField.setEditable(false);
        logField.setFont(LaFHandler.GULIM);
        logField.setForeground(new java.awt.Color(153, 0, 153));
        logField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        logField.setToolTipText(null);
        logField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 153), 1, true));
        logField.setMaximumSize(new java.awt.Dimension(300, 40));
        logField.setMinimumSize(new java.awt.Dimension(40, 40));
        logField.setPreferredSize(new java.awt.Dimension(40, 40));

        browseButton.setFont(LaFHandler.GULIM);
        browseButton.setForeground(new java.awt.Color(153, 153, 153));
        browseButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        browseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder.png"))); // NOI18N
        browseButton.setMaximumSize(new java.awt.Dimension(40, 40));
        browseButton.setMinimumSize(new java.awt.Dimension(40, 40));
        browseButton.setPreferredSize(new java.awt.Dimension(40, 40));
        browseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                browseButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                browseButtonMouseExited(evt);
            }
        });

        cancelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel.png"))); // NOI18N
        cancelLabel.setToolTipText(null);
        cancelLabel.setMaximumSize(new java.awt.Dimension(200, 50));
        cancelLabel.setMinimumSize(new java.awt.Dimension(200, 50));
        cancelLabel.setPreferredSize(new java.awt.Dimension(200, 50));
        cancelLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelLabelMouseExited(evt);
            }
        });

        monitorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        monitorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitor.png"))); // NOI18N
        monitorLabel.setToolTipText(null);
        monitorLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monitorLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                monitorLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                monitorLabelMouseExited(evt);
            }
        });

        tickLabel.setFont(LaFHandler.GULIM);
        tickLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tickLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick_on.png"))); // NOI18N
        tickLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(153, 0, 153)));
        tickLabel.setMaximumSize(new java.awt.Dimension(240, 40));
        tickLabel.setMinimumSize(new java.awt.Dimension(240, 40));
        tickLabel.setPreferredSize(new java.awt.Dimension(240, 40));
        tickLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tickLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tickLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tickLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(cancelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(monitorLabel))
                    .addComponent(descLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toolkitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(logField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tickLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toolkitBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(containerLayout.createSequentialGroup()
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(toolkitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(toolkitBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(logField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(logLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tickLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monitorLabel))
                .addContainerGap())
        );

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseButtonMouseEntered
        browseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder_hover.png")));
    }//GEN-LAST:event_browseButtonMouseEntered

    private void browseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseButtonMouseClicked
        JFileChooser chooser = new JFileChooser(Settings.getSetting("recent_path"));
        chooser.setApproveButtonText("Monitor");
        
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile() == null || chooser.getSelectedFile().isDirectory()) return;
            
            logField.setText(chooser.getSelectedFile().getName());
            Settings.putSetting("recent_path", chooser.getSelectedFile().getParent());
        }
    }//GEN-LAST:event_browseButtonMouseClicked

    private void browseButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseButtonMouseExited
        browseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder.png")));
    }//GEN-LAST:event_browseButtonMouseExited

    private void tickLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tickLabelMouseClicked
        if(!ticked) {
            tickLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick_on_hover.png")));
        } else {
            tickLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick_off_hover.png")));
        }
        
        ticked = !ticked;
        Settings.putSetting("back_date", Boolean.toString(ticked));
    }//GEN-LAST:event_tickLabelMouseClicked

    private void tickLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tickLabelMouseEntered
        if(ticked) {
            tickLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick_on_hover.png")));
        } else {
            tickLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick_off_hover.png")));
        }
    }//GEN-LAST:event_tickLabelMouseEntered

    private void tickLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tickLabelMouseExited
        if(ticked) {
            tickLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick_on.png")));
        } else {
            tickLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick_off.png")));
        }
    }//GEN-LAST:event_tickLabelMouseExited

    private void cancelLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelLabelMouseEntered
        cancelLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel_hover.png")));
    }//GEN-LAST:event_cancelLabelMouseEntered

    private void cancelLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelLabelMouseExited
        cancelLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel.png")));
    }//GEN-LAST:event_cancelLabelMouseExited

    private void cancelLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelLabelMouseClicked

    private void monitorLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monitorLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_monitorLabelMouseClicked

    private void monitorLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monitorLabelMouseEntered
        monitorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitor_hover.png")));
    }//GEN-LAST:event_monitorLabelMouseEntered

    private void monitorLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monitorLabelMouseExited
        monitorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitor.png")));
    }//GEN-LAST:event_monitorLabelMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backdateLabel;
    private javax.swing.JLabel browseButton;
    private javax.swing.JLabel cancelLabel;
    private javax.swing.JPanel container;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextField logField;
    private javax.swing.JLabel logLabel;
    private javax.swing.JLabel monitorLabel;
    private javax.swing.JLabel tickLabel;
    private javax.swing.JComboBox toolkitBox;
    private javax.swing.JLabel toolkitLabel;
    // End of variables declaration//GEN-END:variables

}
// End of class.