package org.example.Panels.Menu.AllMeetingsScrollPane;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import org.example.Models.Meeting;

public class AllMeetingsScrollPaneView extends AllMeetingsScrollPaneTemplate {
    public AllMeetingsScrollPaneView(List<Meeting> meetings) {
        this.meetings = meetings;
        controller = new AllMeetingsScrollPaneController(this);

        meetingsPanel = new JPanel();
        meetingsPanel.setLayout(new BoxLayout(meetingsPanel, BoxLayout.Y_AXIS));
        meetingsPanel.setBackground(Color.WHITE);

        this.setBounds(10, 90, 280, 555);
        this.setBorder(null);
        this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        this.setVisible(false);
        this.setViewportView(meetingsPanel);

        showAllMeetings();
    }
}
