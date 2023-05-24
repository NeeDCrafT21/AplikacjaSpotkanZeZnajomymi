package org.example.CreateMeetingSelectPlaceScrollPane;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import org.example.CreateMeetingPanel.CreateMeetingPanelView;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

public class CreateMeetingSelectPlaceScrollPaneView extends CreateMeetingSelectPlaceScrollPaneTemplate {
    public CreateMeetingSelectPlaceScrollPaneView(
            List<MapMarker> markers, CreateMeetingPanelView createMeetingPanelView) {
        this.markers = markers;
        this.createMeetingPanelView = createMeetingPanelView;
        controller = new CreateMeetingSelectPlaceScrollPaneController(this);

        selectPlacePanel = new JPanel();
        selectPlacePanel.setLayout(new BoxLayout(selectPlacePanel, BoxLayout.Y_AXIS));
        selectPlacePanel.setBackground(Color.WHITE);

        this.setBounds(220, 50, 200, 595);
        this.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Places"));
        this.setBackground(Color.WHITE);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVisible(true);
        this.setViewportView(selectPlacePanel);

        showCreatedMarkers();
    }
}
