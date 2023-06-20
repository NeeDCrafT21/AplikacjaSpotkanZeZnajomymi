package org.example.Panels.MapPanel;

import javax.swing.*;
import lombok.Getter;
import org.example.Models.ExpMapMarker;
import org.example.Models.OSMMap;
import org.example.Panels.Markers.CreateMarkerPanel.CreateMarkerPanelView;
import org.example.Panels.Markers.MarkerPanel.MarkerPanelView;
import org.example.Panels.Menu.MenuPanel.MenuPanelView;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

@Getter
public abstract class MapPanelTemplate extends JPanel {
    OSMMap map;
    MenuPanelView menuPanelView;
    MarkerPanelView markerPanelView;
    CreateMarkerPanelView createMarkerPanelView;

    ExpMapMarker clickedMarker;
    ICoordinate markerPosition;

    JMenuItem placeMarkerPMItem;
    JMenuItem showMarkerPMItem;
    JMenuItem deleteMarkerPMItem;
    JPopupMenu addMarkerPopupMenu;
    JPopupMenu editMarkerPopupMenu;
    MapPanelController controller;
}
