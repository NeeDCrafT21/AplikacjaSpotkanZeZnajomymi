package org.example.Panels.Meetings.MeetingPanel;

import lombok.AllArgsConstructor;
import org.example.Models.Controllers;
import org.example.Models.Meeting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;

public class MeetingPanelController {
    MeetingPanelView view;

    public MeetingPanelController(MeetingPanelView view) {
        this.view = view;
        Controllers.meetingPanelController = this;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.closeMenuButton) {
            view.setVisible(false);
        }
    }

    public void updatePanelInfo(Meeting meeting) {
        view.titleLabel.setText("<html>Meeting in: " + meeting.getMeetingLocation().getName() + "</html>");
        view.locationDescriptionTextArea.setText(meeting.getMeetingLocation().getDescription());
        view.locationAddressTextArea.setText(meeting.getMeetingLocation().getLocation().getDisplayName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        view.meetingDateInfoLabel.setText(meeting.getMeetingDate().format(formatter));
        view.meetingTimeInfoLabel.setText(meeting.getMeetingTime().toString());
    }
}
