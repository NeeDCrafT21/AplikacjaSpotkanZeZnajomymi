package org.example.Panels.Menu.MenuPanel;

import java.util.List;
import javax.swing.*;
import lombok.Getter;
import org.example.Models.Meeting;
import org.example.Panels.Markers.MarkerPanel.MarkerPanelView;
import org.example.Panels.Meetings.CreateMeetingPanel.CreateMeetingPanelView;
import org.example.Panels.Menu.AllMeetingsPanel.AllMeetingsPanelView;
import org.example.Panels.Menu.AllMeetingsScrollPane.AllMeetingsScrollPaneView;
import org.example.Panels.Menu.MenuButtonPanel.MenuButtonPanelView;
import org.example.Panels.Menu.SavedMarkersScrollPane.SavedMarkersScrollPaneView;

@Getter
public abstract class MenuPanelTemplate extends JPanel {

    protected MarkerPanelView markerPanelView;
    protected List<Meeting> meetings;

    protected SavedMarkersScrollPaneView savedMarkersScrollPaneView;
    protected AllMeetingsPanelView allMeetingsPanelView;
    //protected AllMeetingsScrollPaneView allMeetingsScrollPaneView;
    protected MenuButtonPanelView menuButtonPanelView;
    protected CreateMeetingPanelView createMeetingPanelView;

    protected JButton closeButton;
    protected JButton backButton;

    protected MenuPanelController controller;
}
