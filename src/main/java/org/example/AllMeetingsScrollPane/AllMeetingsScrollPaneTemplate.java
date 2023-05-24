package org.example.AllMeetingsScrollPane;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import lombok.Getter;
import org.example.MeetingButtonPanel.MeetingButtonPanelView;
import org.example.Model.Meeting;

@Getter
public abstract class AllMeetingsScrollPaneTemplate extends JScrollPane {
    protected AllMeetingsScrollPaneController controller;
    protected List<Meeting> meetings;
    protected JPanel meetingsPanel;

    protected void showAllMeetings() {
        for (Meeting meeting : meetings) {
            MeetingButtonPanelView meetingButton = new MeetingButtonPanelView(meeting);
            meetingsPanel.add(meetingButton);
            meetingsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }
}
