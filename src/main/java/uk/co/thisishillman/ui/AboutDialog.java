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

import uk.co.thisishillman.ui.utils.LinkListener;
import javax.swing.JFrame;
import uk.co.thisishillman.Main;

/**
 * About dialog UI class
 * 
 * @author M Hillman
 */
public class AboutDialog extends javax.swing.JDialog {

    /**
     * Creates new form AboutDialog
     * 
     * @param parent Parent JFRame
     */
    public AboutDialog(JFrame parent) {
        super(parent, ModalityType.APPLICATION_MODAL);
        
        LaFHandler.setIconImages(this);
        LaFHandler.setNimbusTheme(this);
        initComponents();
        
        editorPane.addHyperlinkListener(new LinkListener());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        detailsPanel = new javax.swing.JPanel();
        versionTitle = new javax.swing.JLabel();
        authorTitle = new javax.swing.JLabel();
        websiteTitle = new javax.swing.JLabel();
        websiteTitle1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        editorPane = new javax.swing.JEditorPane();
        versionLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        websiteLabel = new javax.swing.JLabel();
        copyrightLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About...");
        setMinimumSize(new java.awt.Dimension(300, 200));
        setModal(true);

        container.setBackground(new java.awt.Color(255, 255, 255));

        detailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        detailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        detailsPanel.setMaximumSize(new java.awt.Dimension(390, 999));
        detailsPanel.setMinimumSize(new java.awt.Dimension(390, 100));
        detailsPanel.setPreferredSize(new java.awt.Dimension(390, 100));

        versionTitle.setFont(LaFHandler.GULIM);
        versionTitle.setText("Application Version");
        versionTitle.setToolTipText(null);
        versionTitle.setMaximumSize(new java.awt.Dimension(150, 30));
        versionTitle.setMinimumSize(new java.awt.Dimension(150, 30));
        versionTitle.setPreferredSize(new java.awt.Dimension(150, 30));

        authorTitle.setFont(LaFHandler.GULIM);
        authorTitle.setText("Principal Author");
        authorTitle.setToolTipText(null);
        authorTitle.setMaximumSize(new java.awt.Dimension(150, 30));
        authorTitle.setMinimumSize(new java.awt.Dimension(150, 30));
        authorTitle.setPreferredSize(new java.awt.Dimension(150, 30));

        websiteTitle.setFont(LaFHandler.GULIM);
        websiteTitle.setText("Author's Website");
        websiteTitle.setToolTipText(null);
        websiteTitle.setMaximumSize(new java.awt.Dimension(150, 30));
        websiteTitle.setMinimumSize(new java.awt.Dimension(150, 30));
        websiteTitle.setPreferredSize(new java.awt.Dimension(150, 30));

        websiteTitle1.setFont(LaFHandler.GULIM);
        websiteTitle1.setForeground(new java.awt.Color(153, 153, 153));
        websiteTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        websiteTitle1.setText("3rd Party Resources");
        websiteTitle1.setToolTipText(null);
        websiteTitle1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        websiteTitle1.setMaximumSize(new java.awt.Dimension(150, 30));
        websiteTitle1.setMinimumSize(new java.awt.Dimension(150, 30));
        websiteTitle1.setPreferredSize(new java.awt.Dimension(150, 30));

        editorPane.setEditable(false);
        editorPane.setBorder(null);
        editorPane.setContentType("text/html"); // NOI18N
        editorPane.setFont(LaFHandler.GULIM);
        editorPane.setText("<html>\r\n<p align=\"center\">\n\n<a href=\"https://www.vectoropenstock.com/vectors/preview/71307/dinosaur-prehistoric-animal-silhouettes\">Stego icon provided by VectorOpenStock</a><br>\n<a href=\"http://dev.maxmind.com/geoip/\">IP Location provided by MaxMind</a><br>\n<a href=\"http://cooltext.com/Download-Font-%EA%B5%B4%EB%A6%BC+Gulim\">Gulim font provided by Cool Text</a><br>\n<a href=\"https://commons.apache.org/proper/commons-io/\">IO Commons provided by Apache</a><br>\n<a href=\"http://www.jfree.org/jfreechart/\">Charting provided by JFreeChart</a><br>\n<a href=\"http://wiki.openstreetmap.org/wiki/JMapViewer\">Mapping provided by JMapViewer</a>\n</p>\n</html>\r\n");
        editorPane.setToolTipText(null);
        jScrollPane1.setViewportView(editorPane);

        versionLabel.setFont(LaFHandler.GULIM);
        versionLabel.setForeground(new java.awt.Color(153, 153, 153));
        versionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        versionLabel.setText(Main.VERSION);
        versionLabel.setToolTipText(null);
        versionLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        versionLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        versionLabel.setPreferredSize(new java.awt.Dimension(150, 30));

        authorLabel.setFont(LaFHandler.GULIM);
        authorLabel.setForeground(new java.awt.Color(153, 153, 153));
        authorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorLabel.setText("Michael Hillman");
        authorLabel.setToolTipText(null);
        authorLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        authorLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        authorLabel.setPreferredSize(new java.awt.Dimension(150, 30));

        websiteLabel.setFont(LaFHandler.GULIM);
        websiteLabel.setForeground(new java.awt.Color(153, 153, 153));
        websiteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        websiteLabel.setText("thisishillman.co.uk");
        websiteLabel.setToolTipText(null);
        websiteLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        websiteLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        websiteLabel.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout detailsPanelLayout = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(detailsPanelLayout);
        detailsPanelLayout.setHorizontalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(websiteTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(websiteTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(websiteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(versionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(versionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(authorTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        detailsPanelLayout.setVerticalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(versionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(versionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(websiteTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(websiteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(websiteTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );

        copyrightLabel.setFont(LaFHandler.GULIM);
        copyrightLabel.setForeground(new java.awt.Color(153, 153, 153));
        copyrightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyrightLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stego_128.png"))); // NOI18N
        copyrightLabel.setText("<html><p align=\"center\"><br><br>Copyright 2015 M Hillman - thisishillman.co.uk\n<br><br>\nPermission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to deal\nin the Software without restriction, including without limitation the rights\nto use, copy, modify, merge, publish, distribute, sublicense, and/or sell\ncopies of the Software, and to permit persons to whom the Software is\nfurnished to do so, subject to the following conditions:\n<br><br>\nThe above copyright notice and this permission notice shall be included in\nall copies or substantial portions of the Software.\n<br><br>\nTHE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\nIMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\nFITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\nAUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\nLIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\nOUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN\nTHE SOFTWARE.</p></html>");
        copyrightLabel.setToolTipText(null);
        copyrightLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copyrightLabel.setMaximumSize(new java.awt.Dimension(999, 999));
        copyrightLabel.setMinimumSize(new java.awt.Dimension(100, 100));
        copyrightLabel.setPreferredSize(new java.awt.Dimension(200, 200));
        copyrightLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(copyrightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(copyrightLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JLabel authorTitle;
    private javax.swing.JPanel container;
    private javax.swing.JLabel copyrightLabel;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JEditorPane editorPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel versionLabel;
    private javax.swing.JLabel versionTitle;
    private javax.swing.JLabel websiteLabel;
    private javax.swing.JLabel websiteTitle;
    private javax.swing.JLabel websiteTitle1;
    // End of variables declaration//GEN-END:variables

}
// End of class.