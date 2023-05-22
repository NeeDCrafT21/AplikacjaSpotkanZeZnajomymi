package org.example.View;

import org.example.Model.ExpMapMarker;
import org.example.Model.OSMMap;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavedMarkersScrollPane extends JScrollPane implements ActionListener {

    OSMMap map;
    MarkerPanel markerPanel;
    MenuPanel menuPanel;
    JPanel savedMarkersPanel;
    JButton clickedButton;

    public SavedMarkersScrollPane(OSMMap map, MarkerPanel markerPanel, MenuPanel menuPanel) {
        this.map = map;
        this.markerPanel = markerPanel;
        this.menuPanel = menuPanel;

        savedMarkersPanel = new JPanel();
        savedMarkersPanel.setLayout(new BoxLayout(savedMarkersPanel,BoxLayout.Y_AXIS));
        savedMarkersPanel.setBackground(Color.WHITE);

        this.setBounds(10, 90, 280, 555);
        this.setBorder(null);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVisible(false);
        this.setViewportView(savedMarkersPanel);

        showCreatedMarkers();
    }

    private void showCreatedMarkers() {
        for(MapMarker marker: map.getMapMarkerList()) {
            SavedMarkerButtonPanel markerButton = new SavedMarkerButtonPanel(markerPanel, menuPanel, (ExpMapMarker) marker);
            savedMarkersPanel.add(markerButton);
            savedMarkersPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    public void UpdateShowCreatedMarkers() {
        savedMarkersPanel.removeAll();
        showCreatedMarkers();
    }

    public JButton getClickedButton() {
        return clickedButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Component button: savedMarkersPanel.getComponents()) {
            if(e.getSource() == button) {
                clickedButton = (JButton) button;
            }
        }
    }
}
