package org.example.Panels.SearchBar.LocationSearchBarPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.Models.ExpMapMarker;
import org.example.Models.LocationSearch;
import org.example.Service.LocationsSearchService;
import org.openstreetmap.gui.jmapviewer.Coordinate;

@AllArgsConstructor
public class LocationSearchBarPanelController {
    LocationSearchBarPanelView view;

    public void updateSearchList(String location) {
        view.locationNamesList.clear();
        LocationsSearchService locationsSearchService = new LocationsSearchService(new ObjectMapper());

        view.locationSearchList = locationsSearchService.getLocationsFromApi(location, 10);

        for (LocationSearch loc : view.locationSearchList) {
            view.locationNamesList.addElement(loc.getDisplayName());
        }
        System.out.println(view.getLocationNamesList());

        if(!view.locationNamesList.isEmpty()) {
            view.locationsListScrollPane.setVisible(true);
            view.getParent().repaint();
            view.getParent().revalidate();
        }
        else {
            view.locationsListScrollPane.setVisible(false);
            view.getParent().repaint();
            view.getParent().revalidate();
        }
    }

    public void setTempMarker(Coordinate coordinate) {
        view.tempMarker = new ExpMapMarker("Marker", coordinate);
        view.tempMarker.setColor(Color.RED);
        view.map.addMapMarker(view.tempMarker);
    }

    public void markChosenLocation(int index) {
        view.map.removeMapMarker(view.tempMarker);
        LocationSearch location = view.locationSearchList.get(index);
        double lat = Double.parseDouble(location.getLat());
        double lon = Double.parseDouble(location.getLon());
        Coordinate coordinate = new Coordinate(lat, lon);
        setTempMarker(coordinate);
        view.map.setDisplayPosition(coordinate, 16);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            view.searchBarTextField.setText(view.locationsList.getSelectedValue());
            markChosenLocation(view.locationsList.getSelectedIndex());
            view.mapPanelView.requestFocus();
        }
    }

    public void focusGained(FocusEvent e) {
        if (e.getSource() == view.searchBarTextField
                && Objects.equals(view.searchBarTextField.getText(), "Search for location")) {
            view.searchBarTextField.setText("");
            view.locationNamesList.clear();
        }
        if (view.locationsList.getModel().getSize() > 0) {
            view.locationsListScrollPane.setVisible(true);
        }
        view.searchBarTextField.setBackground(new Color(255, 255, 255, 255));
        view.getParent().repaint();
        view.getParent().revalidate();
    }

    public void focusLost(FocusEvent e) {
        if (e.getSource() == view.searchBarTextField
                && view.searchBarTextField.getText().isEmpty()) {
            view.searchBarTextField.setText("Search for location");
            view.map.removeMapMarker(view.tempMarker);
        }
        view.locationsListScrollPane.setVisible(false);
        view.searchBarTextField.setBackground(new Color(255, 255, 255, 200));
        view.getParent().repaint();
        view.getParent().revalidate();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.searchBarTextField) {
            updateSearchList(view.searchBarTextField.getText());
        }
    }
}
