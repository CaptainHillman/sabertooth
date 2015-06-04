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
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.JMapViewerTree;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.LayerGroup;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.events.JMVCommandEvent;
import org.openstreetmap.gui.jmapviewer.interfaces.JMapViewerEventListener;
import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;
import uk.co.thisishillman.model.Request;

/**
 *
 * @author Michael
 */
public class MapPanel extends JPanel implements JMapViewerEventListener {

    //
    private final JLabel scaleLabel;
    
    //
    private final JComboBox tileBox;
    
    //
    private  LayerGroup layerGroup;
    
    //
    private Layer deniedLayer;
    
    //
    private Layer approvedLayer;
    
    // 
    private JMapViewerTree treeMap;
    
    //
    private JMapViewer map;
    
    /**
     * Creates new MapPanel
     * 
     * @param scaleLabel
     * @param tileBox
     */
    public MapPanel(JLabel scaleLabel, JComboBox tileBox) {
        initComponents();
        this.scaleLabel = scaleLabel;
        this.tileBox = tileBox;
        
        initialise();
    }
    
    /**
     * 
     */
    private void initialise() {
        layerGroup = new LayerGroup("All Attempts");
        deniedLayer = layerGroup.addLayer("Denied Attempts");
        approvedLayer = layerGroup.addLayer("Approved Attempts");
        
        treeMap = new JMapViewerTree("Zones");
        map = treeMap.getViewer();
        
        add(treeMap, BorderLayout.CENTER);
        
        this.tileBox.addItemListener((ItemEvent e) -> {
            map.setTileSource((TileSource) e.getItem());
        });
        
        treeMap.addLayer(deniedLayer);
        treeMap.addLayer(approvedLayer);
    }
    
    /**
     * 
     * @param approved
     * @param denied 
     */
    public void showLayers(boolean approved, boolean denied) {
       approvedLayer.setVisible(approved);
       deniedLayer.setVisible(denied);
       
       map.repaint();
    }
    
    /**
     * 
     * @param req 
     */
    public void addAttempt(Request req) {
        MapMarkerDot dot;
        
        if(req.wasApproved()) {
            dot = new MapMarkerDot(approvedLayer, req.getSource().getIp(),
                    req.getSource().getLatitude(), req.getSource().getLongitude());
            dot.setColor(Color.GREEN);
        } else {
            dot = new MapMarkerDot(deniedLayer, req.getSource().getIp(),
                    req.getSource().getLatitude(), req.getSource().getLongitude());
            dot.setColor(Color.RED);
        }
        
        if( !map.getMapMarkerList().contains(dot) ) {
            map.addMapMarker(dot);
        }
    }
    
    /**
     * 
     */
    private void updateZoomParameters() {
        if (scaleLabel != null) {
            scaleLabel.setText( String.format("%s", map.getMeterPerPixel()) );
        }
    }

    /**
     * 
     * @param command 
     */
    @Override
    public void processCommand(JMVCommandEvent command) {
        if (command.getCommand().equals(JMVCommandEvent.COMMAND.ZOOM) ||
                command.getCommand().equals(JMVCommandEvent.COMMAND.MOVE)) {
            
            updateZoomParameters();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 204));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
// End of class.