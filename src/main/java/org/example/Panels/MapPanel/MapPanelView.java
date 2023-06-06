package org.example.Panels.MapPanel;

import java.awt.event.*;
import javax.swing.*;
import org.example.Models.OSMMap;
import org.example.Models.Views;
import org.example.Panels.Markers.CreateMarkerPanel.CreateMarkerPanelView;
import org.example.Panels.Markers.MarkerPanel.MarkerPanelView;
import org.example.Panels.Menu.MenuPanel.MenuPanelView;

public class MapPanelView extends MapPanelTemplate implements ActionListener {
    public MapPanelView() {
        this.map = Views.mainFrameView.getMap();
        this.markerPanelView = Views.mainFrameView.getMarkerPanelView();
        this.menuPanelView = Views.mainFrameView.getMenuPanelView();
        this.createMarkerPanelView = Views.mainFrameView.getCreateMarkerPanelView();
        controller = new MapPanelController(this);

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

        map.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.mouseClicked(e);
            }
        });

        this.setLayout(null);
        this.setBounds(0, 0, 1280, 720);
        // this.setFocusable(false);
        this.add(map);
        this.add(addMarkerPopupMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.buttonClicked(e);
    }
}
