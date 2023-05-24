package org.example.LocationSearchBarPanel;

import lombok.Getter;
import org.example.MapPanel.MapPanelView;

import javax.swing.*;

@Getter
public class LocationSearchBarPanelTemplate extends JPanel {
    protected LocationSearchBarPanelController controller;
    protected MapPanelView mapPanelView;
    protected JTextField searchBarTextField;
    protected JList<String> locationsList;
    protected JScrollPane locationsListScrollPane;

}
