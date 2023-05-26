package org.example.Panels.Meetings.CreateMeetingSelectPlaceScrollPane;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import lombok.Getter;
import org.example.Models.ExpMapMarker;
import org.example.Panels.Meetings.CreateMeetingPanel.CreateMeetingPanelView;
import org.example.Panels.Meetings.SelectPlaceButtonPanel.SelectPlaceButtonPanelView;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

@Getter
public abstract class CreateMeetingSelectPlaceScrollPaneTemplate extends JScrollPane {
    protected CreateMeetingSelectPlaceScrollPaneController controller;
    protected List<MapMarker> markers;
    protected CreateMeetingPanelView createMeetingPanelView;
    protected JPanel selectPlacePanel;

    protected void showCreatedMarkers() {
        for (MapMarker marker : markers) {
            SelectPlaceButtonPanelView markerButton = new SelectPlaceButtonPanelView(
                    (CreateMeetingSelectPlaceScrollPaneView) this, (ExpMapMarker) marker);
            selectPlacePanel.add(markerButton);
            selectPlacePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }
}
