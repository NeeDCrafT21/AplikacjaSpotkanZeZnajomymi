package org.example.Panels.Menu.SavedMarkersScrollPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.example.Models.Views;

public class SavedMarkersScrollPaneView extends SavedMarkersScrollPaneTemplate implements ActionListener {

    public SavedMarkersScrollPaneView() {
        this.map = Views.mainFrameView.getMap();
        this.markerPanelView = Views.markerPanelView;
        this.menuPanel = Views.menuPanelView;
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
