package org.example.Panels.Menu.SavedMarkersScrollPane;

import java.awt.*;
import javax.swing.*;
import lombok.Getter;
import org.example.Models.ExpMapMarker;
import org.example.Models.OSMMap;
import org.example.Panels.Markers.MarkerPanel.MarkerPanelView;
import org.example.Panels.Menu.MenuPanel.MenuPanelView;
import org.example.Panels.Menu.SavedMarkerButtonPanel.SavedMarkerButtonPanelView;
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
