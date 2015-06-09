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
package uk.co.thisishillman.vis;

import java.awt.Color;
import java.awt.Font;
import java.util.ListIterator;
import javax.swing.JComponent;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.JMapViewerTree;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.LayerGroup;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.Style;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import uk.co.thisishillman.model.AccessAttempt;
import uk.co.thisishillman.ui.LaFHandler;

/**
 * @author M Hillman
 */
public final class Map {
    
    // Group of all map layers
    private LayerGroup layerGroup;
    
    // Map layer for denied attempts
    private Layer deniedLayer;
    
    // Map layer for approved attempts
    private Layer approvedLayer;
    
    // 
    private JMapViewerTree treeMap;
    
    // Map viewer
    private JMapViewer map;
    
    // Visual styles for each map layer
    private Style approvedStyle, deniedStyle;
    
    /**
     * Creates and initialises a new Map instance
     */
    public Map() {
        initialiseMap();
    }
    
    /**
     * Return the map as a JComponent
     * 
     * @return world map
     */
    public JComponent getMapComponent() {
        return map;
    }
    
    /**
     * Initialise the world map
     */
    private void initialiseMap() {
        
        // Initialise map layers
        layerGroup = new LayerGroup("All Attempts");
        deniedLayer = layerGroup.addLayer("Denied Attempts");
        approvedLayer = layerGroup.addLayer("Approved Attempts");
        
        // Layer styles
        Font small = LaFHandler.GULIM.deriveFont(10.0f).deriveFont(Font.PLAIN);
        approvedStyle = new Style(new Color(0, 255, 0, 150), new Color(0, 255, 0, 100), null, small);
        deniedStyle = new Style(new Color(255, 0, 0, 150), new Color(255, 0, 0, 100), null, small);
        
        // Initialise map objects
        treeMap = new JMapViewerTree("");
        map = treeMap.getViewer();
        
        map.setZoom(map.getZoom() - 1);
        
        // Add layers to map
        treeMap.addLayer(deniedLayer);
        treeMap.addLayer(approvedLayer);
    }
    
    /**
     * Hide/show different map layers
     * 
     * @param approved true to show approved layer
     * @param denied true to show denied layer
     */
    public void showLayers(boolean approved, boolean denied) {
       approvedLayer.setVisible(approved);
       deniedLayer.setVisible(denied);
       map.repaint();
    }
    
    /**
     * Add the input AcccesAttempt to the appropriate map layer
     * 
     * @param attempt attempt to add to map
     */
    public void addAttempt(AccessAttempt attempt) {
        MapMarkerDot dot;
        
        if(attempt.wasApproved()) {
            dot = new MapMarkerDot(approvedLayer, "1", attempt.getSource().getLatitude(), attempt.getSource().getLongitude());
            dot.setStyle(approvedStyle);
            
        } else {
            dot = new MapMarkerDot(deniedLayer, "1", attempt.getSource().getLatitude(), attempt.getSource().getLongitude());
            dot.setStyle(deniedStyle);
        }
        
        // Add the dot if it's not been combined with another marker
        if( !combineMarkers(dot) ) map.addMapMarker(dot);
        
        map.repaint();
    }
    
    /**
     * Groups markers on the map so that different IPs don't crowd the same location, instead the IPs are groups as one 
     * marker with the number of attempts from that location
     * 
     * @param newMarker marker to be potentially added to map
     * 
     * @return true if the input marker has been combined with an already present marker.
     */
    private boolean combineMarkers(MapMarker newMarker) {
        ListIterator iter = map.getMapMarkerList().listIterator();
        boolean combined = false;
        
        while(iter.hasNext()) {
            MapMarker mapMarker = (MapMarker) iter.next();
            
            if(mapMarker.getLat() == newMarker.getLat() && mapMarker.getLon() == newMarker.getLon()) {

                String name = mapMarker.getName();
                int attempts = Integer.parseInt(name.replaceAll("[^\\d.]", "")) + 1;

                MapMarkerDot multiDot = new MapMarkerDot(mapMarker.getLayer(), Integer.toString(attempts), mapMarker.getLat(), mapMarker.getLon());  
                multiDot.setStyle(newMarker.getStyle());

                iter.set(multiDot);
                combined = true;
            }
        }
        
        return combined;
    }
 
}
// End of class.