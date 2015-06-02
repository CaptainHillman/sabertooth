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

import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import uk.co.thisishillman.model.LogProcessor;

/**
 *
 * @author Michael
 */
public class MainFrame extends JFrame {

    /**
     * Initialise a new MainFrame, setting Look and Feel stuff.
     */
    public MainFrame() {
        initComponents();
        LaFHandler.setNimbusTheme(this);
        LaFHandler.setIconImages(this);
    }

    // GUI builder shizzle
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        container = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        buttonLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Things 'n' Stuff (v0.1)");
        setMaximumSize(new java.awt.Dimension(9999, 9999));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(800, 600));

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new java.awt.GridBagLayout());

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/padlock.png"))); // NOI18N
        logoLabel.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.75;
        container.add(logoLabel, gridBagConstraints);

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
        container.add(buttonLabel, gridBagConstraints);

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");
        menuBar.add(fileMenu);

        helpMenu.setText("Help");
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
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Monitor");
        
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile() == null || chooser.getSelectedFile().isDirectory()) return;
            
            LogProcessor processor = new LogProcessor(Paths.get(chooser.getSelectedFile().getAbsolutePath()));
            
            
        }
    }//GEN-LAST:event_buttonLabelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buttonLabel;
    private javax.swing.JPanel container;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
// End of class