package org.example.MapPanel;

import java.awt.event.*;
import javax.swing.*;
import org.example.CreateMarkerPanel.CreateMarkerPanelView;
import org.example.MarkerPanel.MarkerPanelView;
import org.example.MenuPanel.MenuPanelView;
import org.example.Model.OSMMap;

public class MapPanelView extends MapPanelTemplate implements ActionListener {
    public MapPanelView(
            OSMMap map,
            MarkerPanelView markerPanelView,
            MenuPanelView menuPanel,
            CreateMarkerPanelView createMarkerPanelView) {
        this.map = map;
        this.markerPanelView = markerPanelView;
        this.menuPanel = menuPanel;
        this.createMarkerPanelView = createMarkerPanelView;
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

        mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.mouseClicked(e);
            }
        };

        map.addMouseListener(mouseAdapter);

        this.setLayout(null);
        this.setBounds(0, 0, 1280, 720);
        this.setFocusable(false);
        this.add(map);
        this.add(addMarkerPopupMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.buttonClicked(e);
    }
}
