package org.example.SelectPlaceButtonPanel;

import javax.swing.*;
import lombok.Getter;
import org.example.CreateMeetingSelectPlaceScrollPane.CreateMeetingSelectPlaceScrollPaneView;
import org.example.Model.ExpMapMarker;

@Getter
public abstract class SelectPlaceButtonPanelTemplate extends JPanel {
    protected SelectPlaceButtonPanelController controller;
    protected CreateMeetingSelectPlaceScrollPaneView createMeetingSelectPlaceScrollPaneView;
    protected ExpMapMarker marker;
    protected Boolean isSelected = false;
}
