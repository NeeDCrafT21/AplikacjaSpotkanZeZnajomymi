package org.example;

import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import javax.swing.*;
import java.awt.event.*;

public class MapPanel extends JPanel implements ActionListener {

    OSMMap map;
    MenuPanel menuPanel;
    MarkerPanel markerPanel;
    CreateMarkerPanel createMarkerPanel;

    ExpMapMarker clickedMarker;
    ICoordinate mousePosition;

    JMenuItem placeMarkerPMItem;
    JMenuItem showMarkerPMItem;
    JMenuItem deleteMarkerPMItem;
    JPopupMenu addMarkerPopupMenu;
    JPopupMenu editMarkerPopupMenu;

    MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            mousePosition = map.getPosition(e.getX(), e.getY());
            System.out.println(mousePosition);
            if (SwingUtilities.isRightMouseButton(e)) {
                addMarkerPopupMenu.show(map, e.getX(), e.getY());
            } else if (SwingUtilities.isLeftMouseButton(e) && isMarkerClicked(mousePosition)) {
                if (clickedMarker.isCreated) {
                    editMarkerPopupMenu.show(map, e.getX(), e.getY());
                }
            }
        }
    };

    MapPanel(OSMMap map, MarkerPanel markerPanel, MenuPanel menuPanel) {
        this.map = map;
        this.markerPanel = markerPanel;
        this.menuPanel = menuPanel;

        addMarkerPopupMenu = new JPopupMenu();
        placeMarkerPMItem = new JMenuItem("Place marker");
        placeMarkerPMItem.addActionListener(this);
        addMarkerPopupMenu.add(placeMarkerPMItem);

        editMarkerPopupMenu = new JPopupMenu();
        showMarkerPMItem = new JMenuItem("Show marker");
        deleteMarkerPMItem = new JMenuItem("Delete marker");
        showMarkerPMItem.addActionListener(this);
        deleteMarkerPMItem.addActionListener(this);
        editMarkerPopupMenu.add(showMarkerPMItem);
        editMarkerPopupMenu.add(deleteMarkerPMItem);

        map.addMouseListener(mouseAdapter);

        this.setLayout(null);
        this.setBounds(0, 0, 1280, 720);
        this.setFocusable(false);
        this.add(map);
        this.add(addMarkerPopupMenu);

    }

    private boolean isMarkerClicked(ICoordinate mousePosition) {
        int decimalPlaces = zoomDecimalPlaces(); // 2 - zoom = 11, 3 - zoom = 12, 4 - zoom = 16, 5 - zoom => 17
        for (MapMarker marker : map.getMapMarkerList()) {
            if (round(marker.getLat(), decimalPlaces) == round(mousePosition.getLat(), decimalPlaces) && round(marker.getLon(), decimalPlaces) == round(mousePosition.getLon(), decimalPlaces)) {
                clickedMarker = (ExpMapMarker) marker;
                return true;
            }
        }
        return false;
    }

    private int zoomDecimalPlaces() {
        int zoom = map.getZoom();
        if (zoom <= 11) return 2;
        else if (zoom >= 12 && zoom < 15) return 3;
        else if (zoom >= 15 && zoom <= 18) return 4;
        else return 5;
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

    public void showMarker(ExpMapMarker clickedMarker) {
        if (createMarkerPanel != null && createMarkerPanel.isValid()) createMarkerPanel.closePanel();
        menuPanel.closePanel();
        System.out.println(clickedMarker);

        if (markerPanel != null && markerPanel.isValid()) {
            markerPanel.closePanel();
        }
        assert markerPanel != null;
        markerPanel.setupMarkerNewInfo(clickedMarker);
        //this.getParent().add(markerPanel, JLayeredPane.POPUP_LAYER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == placeMarkerPMItem) {
            if (markerPanel != null && markerPanel.isValid()) markerPanel.closePanel();
            menuPanel.closePanel();

            if (createMarkerPanel != null && createMarkerPanel.isValid()) {
                createMarkerPanel.closePanel();
            }
            createMarkerPanel = new CreateMarkerPanel(map, mousePosition);
            this.getParent().add(createMarkerPanel, JLayeredPane.POPUP_LAYER);

        } else if (e.getSource() == showMarkerPMItem) {
            showMarker(clickedMarker);
        } else if (e.getSource() == deleteMarkerPMItem) {
            map.removeMapMarker(clickedMarker);
        }
    }
}
