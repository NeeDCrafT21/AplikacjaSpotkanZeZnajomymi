package org.example.Panels.Meetings.MeetingFriendsScrollPane;

import org.example.Models.Friend;
import org.example.Panels.Meetings.CreateMeetingSelectFriendsScrollPane.CreateMeetingSelectFriendsScrollPaneView;
import org.example.Panels.Meetings.MeetingFriendButtonPanel.MeetingFriendButtonPanelView;
import org.example.Panels.Meetings.SelectFriendButtonPanel.SelectFriendButtonPanelView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MeetingFriendsScrollPaneTemplate extends JScrollPane {
    protected MeetingFriendsScrollPaneController controller;
    protected JPanel friendsPanel;

    protected void showFriends(List<Friend> friends) {
        System.out.println(friends);
        for (Friend friend : friends) {
            MeetingFriendButtonPanelView friendButton =
                    new MeetingFriendButtonPanelView(friend);
            friendsPanel.add(friendButton);
            friendsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        }
    }
}
