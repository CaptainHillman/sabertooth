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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JComponent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import uk.co.thisishillman.model.AccessAttempt;

/**
 * Pie chart visualisation of country breakdown
 * 
 * @author M Hillman
 */
public class PieChart {

    // Data set for chart
    private DefaultPieDataset data;
    
    // Chart
    private JFreeChart chart;
    
    /**
     * Creates and initialises a new pie chart
     */
    public PieChart() {
        initialiseChart();
    }
    
    /**
     * Sets the source for the pie chart's data
     * 
     * @param attempts set of all SSH attempts 
     */
    public void setData(Set<AccessAttempt> attempts) {
        data.clear();
        
        Map<String, Integer> categories = new HashMap<>();
        
        attempts.stream().forEach((attempt) -> {
            if(!categories.containsKey(attempt.getSource().getCountry())) {
                categories.put(attempt.getSource().getCountry(), 1);
            } else {
                categories.put(attempt.getSource().getCountry(), categories.get(attempt.getSource().getCountry()) + 1);
            }
        });
        
        categories.entrySet().stream().forEach((entry) -> {
            data.setValue(entry.getKey(), entry.getValue());
        });
        
        ((PiePlot) chart.getPlot()).setDataset(data);
        chart.fireChartChanged();
    }
    
    /**
     * Return the pie chart as a JComponent
     * 
     * @return pie chart
     */
    public JComponent getChartComponent() {
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setOpaque(false);
        return chartPanel;
    }
    
    /**
     * Initialise pie chart components without data
     */
    private void initialiseChart() {
        chart = ChartFactory.createPieChart("", null, false, false, false);
        chart.setBorderVisible(false);
        chart.setBackgroundPaint(Color.WHITE);
    }

}
// End of class