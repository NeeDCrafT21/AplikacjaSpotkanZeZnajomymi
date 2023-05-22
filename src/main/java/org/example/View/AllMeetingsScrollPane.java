package org.example.View;

import org.example.Model.Meeting;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AllMeetingsScrollPane extends JScrollPane {
    List<Meeting> meetings;
    JPanel meetingsPanel;
    public AllMeetingsScrollPane(List<Meeting> meetings) {
        this.meetings = meetings;

        meetingsPanel = new JPanel();
        meetingsPanel.setLayout(new BoxLayout(meetingsPanel, BoxLayout.Y_AXIS));
        meetingsPanel.setBackground(Color.WHITE);

        this.setBounds(10, 90, 280, 555);
        this.setBorder(null);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVisible(false);
        this.setViewportView(meetingsPanel);

        showAllMeetings();
    }

    private void showAllMeetings() {
        for(Meeting meeting: meetings) {
            MeetingButtonPanel meetingButton = new MeetingButtonPanel(meeting);
            meetingsPanel.add(meetingButton);
            meetingsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    public void UpdateShowAllMeetings() {
        meetingsPanel.removeAll();
        showAllMeetings();
    }
}
