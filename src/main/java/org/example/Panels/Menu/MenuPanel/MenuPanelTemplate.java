package org.example.Panels.Menu.MenuPanel;

import javax.swing.*;
import lombok.Getter;
import org.example.Panels.Menu.AllMeetingsPanel.AllMeetingsPanelView;
import org.example.Panels.Menu.MenuButtonPanel.MenuButtonPanelView;
import org.example.Panels.Menu.SavedMarkersScrollPane.SavedMarkersScrollPaneView;

@Getter
public abstract class MenuPanelTemplate extends JPanel {
    protected SavedMarkersScrollPaneView savedMarkersScrollPaneView;
    protected AllMeetingsPanelView allMeetingsPanelView;
    protected MenuButtonPanelView menuButtonPanelView;
    protected JButton closeButton;
    protected JButton backButton;
    protected MenuPanelController controller;
}
