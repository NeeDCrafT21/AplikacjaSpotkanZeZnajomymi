package org.example.Panels.SearchBar.LocationSearchBarPanel;

import java.util.List;
import javax.swing.*;
import lombok.Getter;
import lombok.Setter;
import org.example.Models.ExpMapMarker;
import org.example.Models.LocationSearch;
import org.example.Models.OSMMap;
import org.example.Panels.MapPanel.MapPanelView;

@Getter
@Setter
public abstract class LocationSearchBarPanelTemplate extends JPanel {
    protected LocationSearchBarPanelController controller;
    protected MapPanelView mapPanelView;
    protected OSMMap map;
    protected JTextField searchBarTextField;
    protected JList<String> locationsList;
    protected JScrollPane locationsListScrollPane;
    protected List<LocationSearch> locationSearchList;
    protected DefaultListModel<String> locationNamesList;
    protected ExpMapMarker tempMarker;
}
