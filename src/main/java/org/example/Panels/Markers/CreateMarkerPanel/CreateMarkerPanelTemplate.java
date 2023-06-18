package org.example.Panels.Markers.CreateMarkerPanel;

import javax.swing.*;
import lombok.Getter;
import org.example.Models.ExpMapMarker;
import org.example.Models.OSMMap;
import org.example.Service.DBConnection;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

@Getter
public abstract class CreateMarkerPanelTemplate extends JPanel {
    protected JButton closeButton;
    protected JButton addMarkerButton;
    protected JTextField nameTextField;
    protected JTextArea descriptionTextArea;
    protected OSMMap map;
    protected ICoordinate markerPosition;
    protected ExpMapMarker marker;
    protected CreateMarkerController controller;
    protected JLabel errorLabel;
}
