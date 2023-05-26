package org.example.Panels.Meetings.SelectPlaceButtonPanel;

import javax.swing.*;
import lombok.Getter;
import org.example.Models.ExpMapMarker;
import org.example.Panels.Meetings.CreateMeetingSelectPlaceScrollPane.CreateMeetingSelectPlaceScrollPaneView;

@Getter
public abstract class SelectPlaceButtonPanelTemplate extends JPanel {
    protected SelectPlaceButtonPanelController controller;
    protected CreateMeetingSelectPlaceScrollPaneView createMeetingSelectPlaceScrollPaneView;
    protected ExpMapMarker marker;
    protected Boolean isSelected = false;
}
