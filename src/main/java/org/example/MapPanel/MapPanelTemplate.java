package org.example.MapPanel;

import java.awt.event.MouseAdapter;
import javax.swing.*;
import lombok.Getter;
import org.example.CreateMarkerPanel.CreateMarkerPanelView;
import org.example.MarkerPanel.MarkerPanelView;
import org.example.MenuPanel.MenuPanelView;
import org.example.Model.ExpMapMarker;
import org.example.Model.OSMMap;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

@Getter
public abstract class MapPanelTemplate extends JPanel {
    OSMMap map;
    MenuPanelView menuPanel;
    MarkerPanelView markerPanelView;
    CreateMarkerPanelView createMarkerPanelView;

    ExpMapMarker clickedMarker;
    ICoordinate markerPosition;

    JMenuItem placeMarkerPMItem;
    JMenuItem showMarkerPMItem;
    JMenuItem deleteMarkerPMItem;
    JPopupMenu addMarkerPopupMenu;
    JPopupMenu editMarkerPopupMenu;
    MouseAdapter mouseAdapter;
    MapPanelController controller;
}
