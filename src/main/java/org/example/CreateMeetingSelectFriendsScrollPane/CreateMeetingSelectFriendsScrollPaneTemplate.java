package org.example.CreateMeetingSelectFriendsScrollPane;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import lombok.Getter;
import org.example.CreateMeetingPanel.CreateMeetingPanelView;
import org.example.Model.Friend;
import org.example.SelectFriendButtonPanel.SelectFriendButtonPanelView;

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
