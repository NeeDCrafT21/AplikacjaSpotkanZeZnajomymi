package org.example.LocationSearchBarPanel;

import org.example.MapPanel.MapPanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class LocationSearchBarPanelView extends LocationSearchBarPanelTemplate implements ActionListener, FocusListener {
    public LocationSearchBarPanelView(MapPanelView mapPanelView) {
        this.mapPanelView = mapPanelView;
        controller = new LocationSearchBarPanelController(this);

        searchBarTextField = new JTextField("Search for location");
        searchBarTextField.setPreferredSize(new Dimension(400, 35));
        searchBarTextField.setBackground(new Color(255, 255, 255, 200));
        searchBarTextField.addFocusListener(this);
        //searchBarTextField.setFocusable(false);
        //searchBarTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        //searchBarTextField.addMouseListener();
        searchBarTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.searchBarClicked(e);
            }
        });

        String[] locations = {"location 1", "location 2", "location 3", "location 4", "location 5"};

        locationsList = new JList<>(locations);
        locationsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        locationsList.addFocusListener(this);
        locationsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    searchBarTextField.setText(locationsList.getSelectedValue());
                    mapPanelView.requestFocus();
                }
            }
        });

        locationsListScrollPane = new JScrollPane(locationsList);
        locationsListScrollPane.setPreferredSize(new Dimension(400, 150));
        locationsListScrollPane.setBorder(null);
        locationsListScrollPane.setOpaque(false);
        locationsListScrollPane.setVisible(false);
        locationsListScrollPane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
            }
        });

        this.setBounds(440, 20, 400, 300);
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
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
