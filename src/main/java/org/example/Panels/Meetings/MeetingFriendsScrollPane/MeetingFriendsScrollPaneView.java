package org.example.Panels.Meetings.MeetingFriendsScrollPane;

import org.example.Models.Friend;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.List;

public class MeetingFriendsScrollPaneView extends MeetingFriendsScrollPaneTemplate {
    public MeetingFriendsScrollPaneView() {
        controller = new MeetingFriendsScrollPaneController(this);

        friendsPanel = new JPanel();
        friendsPanel.setLayout(new BoxLayout(friendsPanel, BoxLayout.X_AXIS));
        friendsPanel.setBackground(Color.WHITE);

        this.setBounds(20, 555, 360, 90);
        this.setBorder(null);
        this.setBackground(Color.WHITE);
        this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
        this.setVisible(true);
        this.setViewportView(friendsPanel);
    }
}
