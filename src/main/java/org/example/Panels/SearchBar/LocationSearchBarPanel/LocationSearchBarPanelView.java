package org.example.Panels.SearchBar.LocationSearchBarPanel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import org.example.Models.OSMMap;
import org.example.Panels.MapPanel.MapPanelView;

public class LocationSearchBarPanelView extends LocationSearchBarPanelTemplate
        implements ActionListener, FocusListener {
    public LocationSearchBarPanelView(MapPanelView mapPanelView, OSMMap map) {
        this.mapPanelView = mapPanelView;
        this.map = map;
        controller = new LocationSearchBarPanelController(this);

        locationSearchList = new ArrayList<>();

        searchBarTextField = new JTextField("Search for location");
        searchBarTextField.setPreferredSize(new Dimension(400, 35));
        searchBarTextField.setBackground(new Color(255, 255, 255, 200));
        searchBarTextField.addFocusListener(this);
        searchBarTextField.addActionListener(this);

        //        String[] locations = {
        //            "location 1", "location 2", "location 3", "location 4", "location 5", "location 6", "location 7"
        //        };

        locationNamesList = new DefaultListModel<>();

        locationsList = new JList<>(locationNamesList);
        locationsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        locationsList.addFocusListener(this);
        locationsList.setFixedCellHeight(29);
        locationsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                controller.mouseClicked(e);
            }
        });

        locationsListScrollPane = new JScrollPane(locationsList);
        locationsListScrollPane.setPreferredSize(new Dimension(400, 150));
        locationsListScrollPane.setOpaque(false);
        locationsListScrollPane.setVisible(false);
        locationsListScrollPane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
            }
        });

        this.setBounds(440, 20, 400, 300);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setOpaque(false);
        this.setVisible(true);

        this.add(searchBarTextField, BorderLayout.NORTH);
        this.add(locationsListScrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.actionPerformed(e);
    }

    @Override
    public void focusGained(FocusEvent e) {
        controller.focusGained(e);
    }

    @Override
    public void focusLost(FocusEvent e) {
        controller.focusLost(e);
    }
}
