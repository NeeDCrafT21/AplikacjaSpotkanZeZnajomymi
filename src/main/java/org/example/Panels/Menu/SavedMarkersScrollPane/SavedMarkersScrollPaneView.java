package org.example.Panels.Menu.SavedMarkersScrollPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.View;

import org.example.Models.OSMMap;
import org.example.Models.Views;
import org.example.Panels.Markers.MarkerPanel.MarkerPanelView;
import org.example.Panels.Menu.MenuPanel.MenuPanelView;

public class SavedMarkersScrollPaneView extends SavedMarkersScrollPaneTemplate implements ActionListener {

    public SavedMarkersScrollPaneView(MarkerPanelView markerPanelView, MenuPanelView menuPanel) {
        this.map = Views.mainFrameView.getMap();
        this.markerPanelView = markerPanelView;
        this.menuPanel = menuPanel;

        controller = new SavedMarkersScrollPaneController(this);

        savedMarkersPanel = new JPanel();
        savedMarkersPanel.setLayout(new BoxLayout(savedMarkersPanel, BoxLayout.Y_AXIS));
        savedMarkersPanel.setBackground(Color.WHITE);

        this.setBounds(10, 90, 280, 555);
        this.setBorder(null);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVisible(false);
        this.setViewportView(savedMarkersPanel);

        showCreatedMarkers();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.actionPerformed(e);
    }
}
