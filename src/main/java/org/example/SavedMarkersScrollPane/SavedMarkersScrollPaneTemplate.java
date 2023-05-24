package org.example.SavedMarkersScrollPane;

import java.awt.*;
import javax.swing.*;
import lombok.Getter;
import org.example.MarkerPanel.MarkerPanelView;
import org.example.MenuPanel.MenuPanelView;
import org.example.Model.ExpMapMarker;
import org.example.Model.OSMMap;
import org.example.SavedMarkerButtonPanel.SavedMarkerButtonPanelView;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

@Getter
public abstract class SavedMarkersScrollPaneTemplate extends JScrollPane {
    protected OSMMap map;
    protected MarkerPanelView markerPanelView;
    protected MenuPanelView menuPanel;
    protected JPanel savedMarkersPanel;
    protected JButton clickedButton;
    protected SavedMarkersScrollPaneController controller;

    protected void showCreatedMarkers() {
        for (MapMarker marker : map.getMapMarkerList()) {
            SavedMarkerButtonPanelView markerButton =
                    new SavedMarkerButtonPanelView(markerPanelView, menuPanel, (ExpMapMarker) marker);
            savedMarkersPanel.add(markerButton);
            savedMarkersPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }
}
