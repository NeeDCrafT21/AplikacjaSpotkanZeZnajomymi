package org.example.Panels.Menu.AllMeetingsPanel;

import javax.swing.*;
import org.example.Panels.Menu.AllMeetingsScrollPane.AllMeetingsScrollPaneView;

public abstract class AllMeetingsPanelTemplate extends JPanel {
    protected AllMeetingsPanelController controller;
    protected AllMeetingsScrollPaneView allMeetingsScrollPaneView;
    protected JButton sortByEarliestButton;
    protected JButton sortByLatestButton;
}
