package org.example.Panels.Meetings.CreateMeetingSelectPlaceScrollPane;

import java.awt.*;
import javax.swing.*;
import lombok.AllArgsConstructor;
import org.example.Models.ExpMapMarker;
import org.example.Panels.Meetings.SelectPlaceButtonPanel.SelectPlaceButtonPanelView;

@AllArgsConstructor
public class CreateMeetingSelectPlaceScrollPaneController {
    CreateMeetingSelectPlaceScrollPaneView view;

    public void updateShowCreatedMarkers() {
        view.selectPlacePanel.removeAll();
        view.showCreatedMarkers();
    }

    public void deselectMarkerButtons() {
        for (Component button : view.selectPlacePanel.getComponents()) {
            if (button.getClass() != Box.Filler.class) {
                ((SelectPlaceButtonPanelView) button).getController().deselect();
            }
        }
    }

    public void setSelectedPlace(ExpMapMarker selectedPlace) {
        view.createMeetingPanelView.setSelectedPlace(selectedPlace);
    }
}
