package org.example.Panels.Meetings.CreateMeetingSelectFriendsScrollPane;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import lombok.Getter;
import org.example.Models.Friend;
import org.example.Panels.Meetings.CreateMeetingPanel.CreateMeetingPanelView;
import org.example.Panels.Meetings.SelectFriendButtonPanel.SelectFriendButtonPanelView;

@Getter
public abstract class CreateMeetingSelectFriendsScrollPaneTemplate extends JScrollPane {
    protected CreateMeetingSelectFriendsScrollPaneController controller;
    protected List<Friend> friends;
    protected CreateMeetingPanelView createMeetingPanelView;
    protected JPanel selectFriendsPanel;

    protected void showAddedFriends() {
        for (Friend friend : friends) {
            SelectFriendButtonPanelView friendButton =
                    new SelectFriendButtonPanelView((CreateMeetingSelectFriendsScrollPaneView) this, friend);
            selectFriendsPanel.add(friendButton);
            selectFriendsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }
}
