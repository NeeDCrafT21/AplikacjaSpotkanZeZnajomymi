package org.example.Panels.MapPanel;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.*;
import lombok.AllArgsConstructor;
import org.example.Models.ExpMapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

@AllArgsConstructor
public class MapPanelController {
    MapPanelView view;

    public void showMarker(ExpMapMarker clickedMarker) {
        if (view.createMarkerPanelView != null && view.createMarkerPanelView.isValid()) {
            view.createMarkerPanelView.setVisible(false);
        }
        view.menuPanel.getController().closePanel();
        System.out.println(clickedMarker);

        if (view.markerPanelView != null && view.markerPanelView.isValid()) {
            view.markerPanelView.getController().closePanel();
        }
        assert view.markerPanelView != null;
        view.markerPanelView.getController().setupMarkerNewInfo(clickedMarker);
        // this.getParent().add(markerPanel, JLayeredPane.POPUP_LAYER);
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private boolean isMarkerClicked(ICoordinate mousePosition) {
        int decimalPlaces = zoomDecimalPlaces(); // 2 - zoom = 11, 3 - zoom = 12, 4 - zoom = 16, 5 - zoom => 17
        for (MapMarker marker : view.map.getMapMarkerList()) {
            if (round(marker.getLat(), decimalPlaces) == round(mousePosition.getLat(), decimalPlaces)
                    && round(marker.getLon(), decimalPlaces) == round(mousePosition.getLon(), decimalPlaces)) {
                view.clickedMarker = (ExpMapMarker) marker;
                return true;
            }
        }
        return false;
    }

    private int zoomDecimalPlaces() {
        int zoom = view.map.getZoom();
        if (zoom <= 11) return 2;
        else if (zoom >= 12 && zoom < 15) return 3;
        else if (zoom >= 15 && zoom <= 18) return 4;
        else return 5;
    }

    public void mouseClicked(MouseEvent e) {
        view.requestFocus();
        view.markerPosition = view.map.getPosition(e.getX(), e.getY());
        System.out.println(view.markerPosition);
        if (SwingUtilities.isRightMouseButton(e)) {
            view.addMarkerPopupMenu.show(view.map, e.getX(), e.getY());
        } else if (SwingUtilities.isLeftMouseButton(e) && isMarkerClicked(view.markerPosition)) {
            if (view.clickedMarker.isCreated()) {
                view.editMarkerPopupMenu.show(view.map, e.getX(), e.getY());
            }
        }
    }

    public void buttonClicked(ActionEvent e) {
        if (e.getSource() == view.placeMarkerPMItem) {
            view.createMarkerPanelView.getController().clearPanelInfo();
            view.createMarkerPanelView.getController().getNewMarkerPosition(view.markerPosition);
            view.createMarkerPanelView.setVisible(true);

        } else if (e.getSource() == view.showMarkerPMItem) {
            showMarker(view.clickedMarker);
        } else if (e.getSource() == view.deleteMarkerPMItem) {
            view.map.removeMapMarker(view.clickedMarker);
        }
    }
}
