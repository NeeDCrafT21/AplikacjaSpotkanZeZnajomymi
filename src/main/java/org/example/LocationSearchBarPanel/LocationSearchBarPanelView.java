package org.example.LocationSearchBarPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocationSearchBarPanelView extends LocationSearchBarPanelTemplate implements ActionListener {
    public LocationSearchBarPanelView() {
        controller = new LocationSearchBarPanelController(this);

        searchBarTextField = new JTextField("Search for location");
        searchBarTextField.setPreferredSize(new Dimension(400, 35));
        searchBarTextField.setBackground(new Color(255, 255, 255, 200));
        //searchBarTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        //searchBarTextField.addMouseListener();


        this.setBounds(440, 20, 400, 300);
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setOpaque(false);
        this.setVisible(true);

        this.add(searchBarTextField, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.actionPerformed(e);
    }
}
