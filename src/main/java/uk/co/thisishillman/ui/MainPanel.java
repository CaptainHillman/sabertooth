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

import uk.co.thisishillman.vis.PieChart;
import uk.co.thisishillman.vis.Map;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.BingAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.MapQuestOpenAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.MapQuestOsmTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;
import uk.co.thisishillman.model.OpenSSHProcessor;

/**
 *
 * @author M Hillman
 */
public class MainPanel extends javax.swing.JPanel {

    // SSH log processor
    private OpenSSHProcessor processor;
    
    //
    private Map mapPanel;
    
    //
    private final JComboBox<TileSource> tileBox;
    
    /**
     * 
     */
    public MainPanel() {
        initComponents();
        
        tileBox = new JComboBox<>(new TileSource[] {
                new OsmTileSource.Mapnik(),
                new OsmTileSource.CycleMap(),
                new BingAerialTileSource(),
                new MapQuestOsmTileSource(),
                new MapQuestOpenAerialTileSource() 
        });
        boxContainer.add(tileBox, BorderLayout.CENTER);
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
    public void startMonitoring(OpenSSHProcessor processor) {
//        this.mapPanel = new Map(scaleLabel, tileBox);
//        
//        this.processor = processor;
//        this.processor.setTextDestination(terminal);
//        this.processor.addMapPanel(mapPanel);
//        
//        this.centerPanel.removeAll();
//        this.centerPanel.add(mapPanel, BorderLayout.CENTER);
//        this.centerPanel.revalidate();
//        this.centerPanel.repaint();
//        
//        this.terminal.setText("");
//        appendToPane("Beginning live SSH log monitoring...", Color.BLACK);
//        
//        this.processor.start();
    }
    
    /**
     * 
     * @param showTerminal
     * @param showSettings
     * @param showMap 
     * @param showPie
     */
    public void updateUI(boolean showTerminal, boolean showSettings, boolean showMap, boolean showPie) {
//        removeAll();
//        
//        if(showPie) {
//            add(new PieChart(processor.getAttempts()), BorderLayout.CENTER);
//            
//            if(showTerminal) add(scrollPane, BorderLayout.SOUTH);
//            
//            revalidate();
//            repaint();
//            return;
//        } 
//        
//        if(showMap) {
//            add(centerPanel, BorderLayout.CENTER);
//            if(showTerminal) {
//                add(scrollPane, BorderLayout.SOUTH);
//            }
//            
//        } else if(showTerminal && !showMap) {
//            add(scrollPane, BorderLayout.CENTER);
//            
//        } else if(!showTerminal && !showMap) {
//            add(noMapLabel, BorderLayout.CENTER);
//        }
//        
//        if(showSettings) {
//            add(settingsPanel, BorderLayout.WEST);
//        }
//        
//        if(!showTerminal && ! showSettings && !showMap) {
//            add(emptyLabel, BorderLayout.CENTER);
//        }
//        
//        revalidate();
//        repaint();
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
        terminal.replaceSelection(msg + "\n");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emptyLabel = new javax.swing.JLabel();
        noMapLabel = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        loadingLabel = new javax.swing.JLabel();
        settingsPanel = new javax.swing.JPanel();
        scaleLabel = new javax.swing.JLabel();
        boxContainer = new javax.swing.JPanel();
        tileTitle = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        approvedCheck = new javax.swing.JCheckBox();
        deniedCheck = new javax.swing.JCheckBox();
        scaleTitle = new javax.swing.JLabel();
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
        centerPanel.setLayout(new java.awt.BorderLayout());

        loadingLabel.setBackground(new java.awt.Color(204, 204, 204));
        loadingLabel.setFont(LaFHandler.GULIM);
        loadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingLabel.setText("Loading...");
        loadingLabel.setOpaque(true);
        centerPanel.add(loadingLabel, java.awt.BorderLayout.CENTER);

        add(centerPanel, java.awt.BorderLayout.CENTER);

        settingsPanel.setBackground(new java.awt.Color(255, 255, 255));
        settingsPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(153, 153, 153)));
        settingsPanel.setMaximumSize(new java.awt.Dimension(150, 999));
        settingsPanel.setMinimumSize(new java.awt.Dimension(150, 100));
        settingsPanel.setPreferredSize(new java.awt.Dimension(150, 504));

        scaleLabel.setFont(LaFHandler.GULIM);
        scaleLabel.setForeground(new java.awt.Color(102, 102, 102));
        scaleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scaleLabel.setText("0.0");
        scaleLabel.setToolTipText(null);
        scaleLabel.setMaximumSize(new java.awt.Dimension(140, 25));
        scaleLabel.setMinimumSize(new java.awt.Dimension(140, 25));
        scaleLabel.setPreferredSize(new java.awt.Dimension(140, 25));

        boxContainer.setForeground(new java.awt.Color(102, 102, 102));
        boxContainer.setToolTipText(null);
        boxContainer.setMaximumSize(new java.awt.Dimension(140, 25));
        boxContainer.setMinimumSize(new java.awt.Dimension(140, 25));
        boxContainer.setOpaque(false);
        boxContainer.setPreferredSize(new java.awt.Dimension(140, 25));
        boxContainer.setLayout(new java.awt.BorderLayout());

        tileTitle.setFont(LaFHandler.GULIM);
        tileTitle.setForeground(new java.awt.Color(102, 102, 102));
        tileTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tileTitle.setText("Map Source");
        tileTitle.setToolTipText(null);
        tileTitle.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        tileTitle.setMaximumSize(new java.awt.Dimension(140, 25));
        tileTitle.setMinimumSize(new java.awt.Dimension(140, 25));
        tileTitle.setPreferredSize(new java.awt.Dimension(140, 25));

        descLabel.setFont(LaFHandler.GULIM);
        descLabel.setForeground(new java.awt.Color(102, 102, 102));
        descLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descLabel.setText("<html><p align=\"center\">Use the right mouse button to move, left double click or mouse wheel to zoom.</p></html>");
        descLabel.setToolTipText(null);
        descLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5));
        descLabel.setMaximumSize(new java.awt.Dimension(140, 150));
        descLabel.setMinimumSize(new java.awt.Dimension(140, 150));
        descLabel.setPreferredSize(new java.awt.Dimension(140, 150));

        approvedCheck.setFont(LaFHandler.GULIM);
        approvedCheck.setForeground(new java.awt.Color(102, 102, 102));
        approvedCheck.setSelected(true);
        approvedCheck.setText("Approved Attempts");
        approvedCheck.setToolTipText(null);
        approvedCheck.setMaximumSize(new java.awt.Dimension(140, 25));
        approvedCheck.setMinimumSize(new java.awt.Dimension(140, 25));
        approvedCheck.setOpaque(false);
        approvedCheck.setPreferredSize(new java.awt.Dimension(140, 25));
        approvedCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approvedCheckActionPerformed(evt);
            }
        });

        deniedCheck.setFont(LaFHandler.GULIM);
        deniedCheck.setForeground(new java.awt.Color(102, 102, 102));
        deniedCheck.setSelected(true);
        deniedCheck.setText("Denied Attempts");
        deniedCheck.setToolTipText(null);
        deniedCheck.setMaximumSize(new java.awt.Dimension(140, 25));
        deniedCheck.setMinimumSize(new java.awt.Dimension(140, 25));
        deniedCheck.setOpaque(false);
        deniedCheck.setPreferredSize(new java.awt.Dimension(140, 25));

        scaleTitle.setFont(LaFHandler.GULIM);
        scaleTitle.setForeground(new java.awt.Color(102, 102, 102));
        scaleTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scaleTitle.setText("Metres per Pixel");
        scaleTitle.setToolTipText(null);
        scaleTitle.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        scaleTitle.setMaximumSize(new java.awt.Dimension(140, 25));
        scaleTitle.setMinimumSize(new java.awt.Dimension(140, 25));
        scaleTitle.setPreferredSize(new java.awt.Dimension(140, 25));

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(boxContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tileTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scaleTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scaleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(approvedCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(deniedCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(tileTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scaleTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scaleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(approvedCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(deniedCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );

        add(settingsPanel, java.awt.BorderLayout.WEST);

        scrollPane.setMaximumSize(new java.awt.Dimension(32767, 100));
        scrollPane.setMinimumSize(new java.awt.Dimension(23, 100));
        scrollPane.setPreferredSize(new java.awt.Dimension(8, 100));

        terminal.setFont(LaFHandler.GULIM);
        scrollPane.setViewportView(terminal);

        add(scrollPane, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void approvedCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvedCheckActionPerformed
        if(mapPanel != null) mapPanel.showLayers(approvedCheck.isSelected(), deniedCheck.isSelected());
    }//GEN-LAST:event_approvedCheckActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox approvedCheck;
    private javax.swing.JPanel boxContainer;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JCheckBox deniedCheck;
    private javax.swing.JLabel descLabel;
    private javax.swing.JLabel emptyLabel;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JLabel noMapLabel;
    private javax.swing.JLabel scaleLabel;
    private javax.swing.JLabel scaleTitle;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JTextPane terminal;
    private javax.swing.JLabel tileTitle;
    // End of variables declaration//GEN-END:variables

}
// End of class.