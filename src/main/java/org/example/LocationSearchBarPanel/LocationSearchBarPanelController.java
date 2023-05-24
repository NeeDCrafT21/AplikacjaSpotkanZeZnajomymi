package org.example.LocationSearchBarPanel;

import lombok.AllArgsConstructor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.util.Objects;

@AllArgsConstructor
public class LocationSearchBarPanelController {
    LocationSearchBarPanelView view;

    public void searchBarClicked(MouseEvent e) {
        //view.searchBarTextField.setFocusable(true);
    }

    public void focusGained(FocusEvent e) {
        if(e.getSource() == view.searchBarTextField && Objects.equals(view.searchBarTextField.getText(), "Search for location")) {
            view.searchBarTextField.setText("");
        }
        view.locationsListScrollPane.setVisible(true);
        view.searchBarTextField.setBackground(new Color(255, 255, 255, 255));
        view.getParent().repaint();
        view.getParent().revalidate();
    }

    public void focusLost(FocusEvent e) {
        if(e.getSource() == view.searchBarTextField && view.searchBarTextField.getText().isEmpty()) {
            view.searchBarTextField.setText("Search for location");
        }

        //view.searchBarTextField.setFocusable(false);
        view.locationsListScrollPane.setVisible(false);
        view.searchBarTextField.setBackground(new Color(255, 255, 255, 200));
        view.getParent().repaint();
        view.getParent().revalidate();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.searchBarTextField) {
            System.out.println("search bar clicked");
        }
    }
}
