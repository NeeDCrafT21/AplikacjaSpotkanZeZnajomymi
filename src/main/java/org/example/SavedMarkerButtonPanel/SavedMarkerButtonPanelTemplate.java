package org.example.SavedMarkerButtonPanel;

import javax.swing.*;
import org.example.MarkerPanel.MarkerPanelView;
import org.example.MenuPanel.MenuPanelView;
import org.example.Model.ExpMapMarker;

public abstract class SavedMarkerButtonPanelTemplate extends JPanel {
    protected MarkerPanelView markerPanelView;
    protected MenuPanelView menuPanel;
    protected ExpMapMarker marker;
    protected SavedMarkerButtonPanelController controller;
}
