package org.example.Panels.Menu.SavedMarkerButtonPanel;

import javax.swing.*;
import org.example.Models.ExpMapMarker;
import org.example.Panels.Markers.MarkerPanel.MarkerPanelView;
import org.example.Panels.Menu.MenuPanel.MenuPanelView;

public abstract class SavedMarkerButtonPanelTemplate extends JPanel {
    protected MarkerPanelView markerPanelView;
    protected MenuPanelView menuPanel;
    protected ExpMapMarker marker;
    protected SavedMarkerButtonPanelController controller;
}
