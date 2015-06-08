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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import uk.co.thisishillman.model.AccessAttempt;

/**
 * Pie chart visualisation of country breakdown
 * 
 * @author M Hillman
 */
public class PieChartPanel extends javax.swing.JPanel {

    /**
     * Initialise a new pie chart
     * 
     * @param requests ssh requests
     */
    public PieChartPanel(List<AccessAttempt> requests) {
        initComponents();
        
        PieDataset data = initialiseData(requests);
        buildChart(data);
    }
    
    /**
     * Initialise the data sets to add to the chart
     * 
     * @param requests
     * @return 
     */
    private PieDataset initialiseData(List<AccessAttempt> requests) {
        Map<String, Integer> categories = new HashMap<>();
        
        for(AccessAttempt req : requests) {
            if(!categories.containsKey(req.getSource().getCountry())) {
                categories.put(req.getSource().getCountry(), 1);
            } else {
                categories.put(req.getSource().getCountry(), categories.get(req.getSource().getCountry()) + 1);
            }
        }
        
        DefaultPieDataset dataset = new DefaultPieDataset( );
        
        for(Map.Entry<String, Integer> entry : categories.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        
        return dataset;
    }
    
    /**
     * Build and add the actual chart object
     * 
     * @param data 
     */
    private void buildChart(PieDataset data) {
        JFreeChart chart = ChartFactory.createPieChart("", data, false, false, false);
        chart.setBorderVisible(false);
        chart.setBackgroundPaint(Color.WHITE);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.WHITE);
        
        this.add(chartPanel, BorderLayout.CENTER);
        
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
// End of class