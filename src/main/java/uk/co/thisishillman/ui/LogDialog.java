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

import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import uk.co.thisishillman.Settings;
import uk.co.thisishillman.model.BaseLogProcessor;
import uk.co.thisishillman.model.OpenSSHProcessor;

/**
 * Dialog to help user determine log file type and location
 * 
 * @author M Hillman
 */
public class LogDialog extends javax.swing.JDialog {

    // Path to chosend log file
    private Path logFile;
    
    /**
     * Creates new form AboutDialog
     * 
     * @param parent Parent JFRame
     */
    public LogDialog(JFrame parent) {
        super(parent, ModalityType.APPLICATION_MODAL);
        
        LaFHandler.setIconImages(this);
        LaFHandler.setNimbusTheme(this);
        initComponents();
    }
    
    /**
     * Return an instance of the chosen log processor, null if none selected or log file is not specified
     * 
     * @return chosen log processor 
     */
    public BaseLogProcessor getChosenProcessor() {
        if(logFile == null) return null;
        
        switch(serverTypeBox.getSelectedIndex()) {
            
            // OpenSSH
            case 0 :
                return new OpenSSHProcessor(logFile);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        subContainer = new javax.swing.JPanel();
        serverTypeLabel = new javax.swing.JLabel();
        logFileLabel = new javax.swing.JLabel();
        checkBoxLabel = new javax.swing.JLabel();
        serverTypeBox = new javax.swing.JComboBox();
        logFileField = new javax.swing.JTextField();
        browseLabel = new javax.swing.JLabel();
        checkBoxContainer = new javax.swing.JPanel();
        checkBox = new javax.swing.JCheckBox();
        descLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Start SSH Monitoring...");
        setMinimumSize(new java.awt.Dimension(300, 200));
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        container.setBackground(new java.awt.Color(255, 255, 255));

        subContainer.setBackground(new java.awt.Color(255, 255, 255));
        subContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        subContainer.setMaximumSize(new java.awt.Dimension(999, 999));
        subContainer.setMinimumSize(new java.awt.Dimension(450, 350));
        subContainer.setPreferredSize(new java.awt.Dimension(450, 350));

        serverTypeLabel.setFont(LaFHandler.GULIM);
        serverTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        serverTypeLabel.setText("SSH Server Type");
        serverTypeLabel.setToolTipText(null);
        serverTypeLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        serverTypeLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        serverTypeLabel.setPreferredSize(new java.awt.Dimension(150, 30));

        logFileLabel.setFont(LaFHandler.GULIM);
        logFileLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logFileLabel.setText("SSH Log File");
        logFileLabel.setToolTipText(null);
        logFileLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        logFileLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        logFileLabel.setPreferredSize(new java.awt.Dimension(150, 30));

        checkBoxLabel.setFont(LaFHandler.GULIM);
        checkBoxLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        checkBoxLabel.setText("Process Past Attempts?");
        checkBoxLabel.setToolTipText(null);
        checkBoxLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        checkBoxLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        checkBoxLabel.setPreferredSize(new java.awt.Dimension(150, 30));

        serverTypeBox.setFont(LaFHandler.GULIM);
        serverTypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OpenSSH" }));
        serverTypeBox.setToolTipText(null);
        serverTypeBox.setMaximumSize(new java.awt.Dimension(185, 30));
        serverTypeBox.setMinimumSize(new java.awt.Dimension(185, 30));
        serverTypeBox.setPreferredSize(new java.awt.Dimension(185, 30));

        logFileField.setEditable(false);
        logFileField.setBackground(new java.awt.Color(204, 204, 204));
        logFileField.setFont(LaFHandler.GULIM);
        logFileField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        logFileField.setText("...");
        logFileField.setToolTipText(null);
        logFileField.setMaximumSize(new java.awt.Dimension(150, 30));
        logFileField.setMinimumSize(new java.awt.Dimension(150, 30));
        logFileField.setPreferredSize(new java.awt.Dimension(150, 30));
        logFileField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logFileFieldActionPerformed(evt);
            }
        });

        browseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        browseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        browseLabel.setToolTipText("Browse to your SSH log file");
        browseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                browseLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                browseLabelMouseExited(evt);
            }
        });

        checkBoxContainer.setBackground(new java.awt.Color(255, 255, 255));
        checkBoxContainer.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        checkBoxContainer.setMaximumSize(new java.awt.Dimension(185, 30));
        checkBoxContainer.setPreferredSize(new java.awt.Dimension(185, 30));
        checkBoxContainer.setLayout(new java.awt.BorderLayout());

        checkBox.setBackground(new java.awt.Color(255, 255, 255));
        checkBox.setSelected(true);
        checkBox.setToolTipText(null);
        checkBox.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        checkBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        checkBox.setMaximumSize(new java.awt.Dimension(185, 30));
        checkBox.setMinimumSize(new java.awt.Dimension(185, 30));
        checkBox.setPreferredSize(new java.awt.Dimension(185, 30));
        checkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });
        checkBoxContainer.add(checkBox, java.awt.BorderLayout.CENTER);

        descLabel.setFont(LaFHandler.GULIM);
        descLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descLabel.setText("<html><p align=\"center\">To start monitoring your SSH log file please select your SSH<br>server from the box below, the location of the log file and<br>whether you want to load previous data from it.<br><br>Hit the button below when you're ready to start.</p></html>");
        descLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        descLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        descLabel.setMaximumSize(new java.awt.Dimension(80, 80));
        descLabel.setMinimumSize(new java.awt.Dimension(80, 80));
        descLabel.setPreferredSize(new java.awt.Dimension(80, 80));

        jButton1.setFont(LaFHandler.GULIM);
        jButton1.setText("Start Monitoring");
        jButton1.setToolTipText(null);
        jButton1.setMaximumSize(new java.awt.Dimension(185, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(185, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(185, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subContainerLayout = new javax.swing.GroupLayout(subContainer);
        subContainer.setLayout(subContainerLayout);
        subContainerLayout.setHorizontalGroup(
            subContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(subContainerLayout.createSequentialGroup()
                        .addComponent(logFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(logFileField, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(browseLabel))
                    .addGroup(subContainerLayout.createSequentialGroup()
                        .addComponent(serverTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(serverTypeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(subContainerLayout.createSequentialGroup()
                        .addComponent(checkBoxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(checkBoxContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subContainerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        subContainerLayout.setVerticalGroup(
            subContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(subContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(subContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(browseLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(logFileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(subContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(subContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(subContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logFileFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logFileFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logFileFieldActionPerformed

    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed
        Settings.putSetting("back_date", Boolean.toString(checkBox.isSelected()));
    }//GEN-LAST:event_checkBoxActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        logFile = null;
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void browseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseLabelMouseClicked
        JFileChooser chooser = new JFileChooser(Settings.getSetting("recent_path"));
        chooser.setApproveButtonText("Monitor");
        
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile() == null || chooser.getSelectedFile().isDirectory()) return;
            
            logFile = Paths.get(chooser.getSelectedFile().getAbsolutePath());
            logFileField.setText(chooser.getSelectedFile().getName());
            
            Settings.putSetting("recent_path", chooser.getSelectedFile().getParent());
        }
    }//GEN-LAST:event_browseLabelMouseClicked

    private void browseLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseLabelMouseEntered
        browseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search_hover.png")));
    }//GEN-LAST:event_browseLabelMouseEntered

    private void browseLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseLabelMouseExited
        browseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); 
    }//GEN-LAST:event_browseLabelMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel browseLabel;
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JPanel checkBoxContainer;
    private javax.swing.JLabel checkBoxLabel;
    private javax.swing.JPanel container;
    private javax.swing.JLabel descLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField logFileField;
    private javax.swing.JLabel logFileLabel;
    private javax.swing.JComboBox serverTypeBox;
    private javax.swing.JLabel serverTypeLabel;
    private javax.swing.JPanel subContainer;
    // End of variables declaration//GEN-END:variables

}
// End of class.