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
import java.awt.Color;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import uk.co.thisishillman.model.LogProcessor;

/**
 *
 * @author M Hillman
 */
public class MainPanel extends javax.swing.JPanel {

    // SSH log processor
    private LogProcessor processor;
    
    /**
     * 
     */
    public MainPanel() {
        initComponents();
    }
    
    /**
     * 
     */
    public void stopMonitoring() {
        if(processor != null) {
            processor.stopRunning();
            appendToPane("", Color.GRAY);
            appendToPane("SSH log monitoring successfully terminated!", Color.GRAY);
        }
    }
    
    /**
     * 
     * @param processor 
     */
    public void startMonitoring(LogProcessor processor) {
        this.processor = processor;
        this.processor.setTextDestination(terminal);
        
        this.terminal.setText("");
        appendToPane("SSH log monitoring starting up...", Color.GRAY);
    }
    
    /**
     * 
     * @param showTerminal
     * @param showSettings
     * @param showMap 
     */
    public void updateUI(boolean showTerminal, boolean showSettings, boolean showMap) {
        removeAll();
        
        if(showMap) {
            add(centerPanel, BorderLayout.CENTER);
            if(showTerminal) {
                add(scrollPane, BorderLayout.SOUTH);
            }
            
        } else if(showTerminal && !showMap) {
            add(scrollPane, BorderLayout.CENTER);
            
        } else if(!showTerminal && !showMap) {
            add(noMapLabel, BorderLayout.CENTER);
        }
        
        if(showSettings) {
            add(settingsPanel, BorderLayout.WEST);
        }
        
        if(!showTerminal && ! showSettings && !showMap) {
            add(emptyLabel, BorderLayout.CENTER);
        }
        
        revalidate();
        repaint();
    }
    
    /**
     * 
     * @param msg
     * @param c 
     */
    private void appendToPane(String msg, Color c) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_LEFT);

        int len = terminal.getDocument().getLength();
        terminal.setCaretPosition(len);
        terminal.setCharacterAttributes(aset, false);
        terminal.replaceSelection(msg);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emptyLabel = new javax.swing.JLabel();
        noMapLabel = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        settingsPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        terminal = new javax.swing.JTextPane();

        emptyLabel.setBackground(new java.awt.Color(204, 204, 204));
        emptyLabel.setFont(LaFHandler.GULIM);
        emptyLabel.setForeground(new java.awt.Color(102, 102, 102));
        emptyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emptyLabel.setText("Use the 'View' menu in the toolbar to see details on SSH tracking.");
        emptyLabel.setOpaque(true);

        noMapLabel.setBackground(new java.awt.Color(204, 204, 204));
        noMapLabel.setFont(LaFHandler.GULIM);
        noMapLabel.setForeground(new java.awt.Color(102, 102, 102));
        noMapLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noMapLabel.setText("Use the 'View' menu in the toolbar to see SSH tracking visualisations.");
        noMapLabel.setOpaque(true);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        centerPanel.setBackground(new java.awt.Color(204, 255, 255));
        centerPanel.setMaximumSize(new java.awt.Dimension(999, 999));
        centerPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        centerPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        add(centerPanel, java.awt.BorderLayout.CENTER);

        settingsPanel.setBackground(new java.awt.Color(204, 204, 255));
        settingsPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(153, 153, 153)));
        settingsPanel.setMaximumSize(new java.awt.Dimension(200, 999));
        settingsPanel.setMinimumSize(new java.awt.Dimension(200, 100));
        settingsPanel.setPreferredSize(new java.awt.Dimension(200, 504));

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        add(settingsPanel, java.awt.BorderLayout.WEST);

        scrollPane.setMaximumSize(new java.awt.Dimension(32767, 100));
        scrollPane.setMinimumSize(new java.awt.Dimension(23, 100));
        scrollPane.setPreferredSize(new java.awt.Dimension(8, 100));
        scrollPane.setViewportView(terminal);

        add(scrollPane, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel emptyLabel;
    private javax.swing.JLabel noMapLabel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JTextPane terminal;
    // End of variables declaration//GEN-END:variables

}
// End of class.