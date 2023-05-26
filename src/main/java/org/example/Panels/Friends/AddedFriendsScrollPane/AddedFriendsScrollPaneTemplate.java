package org.example.Panels.Friends.AddedFriendsScrollPane;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import lombok.Getter;
import org.example.Models.Friend;
import org.example.Panels.Friends.AddedFriendButtonPanel.AddedFriendButtonPanelView;
import org.example.Panels.Friends.FriendPanel.FriendPanelView;
import org.example.Panels.Friends.FriendsPanel.FriendsPanelView;

@Getter
public abstract class AddedFriendsScrollPaneTemplate extends JScrollPane {
    protected AddedFriendsScrollPaneController controller;
    protected FriendsPanelView friendsPanelView;
    protected FriendPanelView friendPanelView;
    protected List<Friend> friends;
    protected JPanel addedFriendsPanel;

    protected void showAddedFriends() {
        for (Friend friend : friends) {
            AddedFriendButtonPanelView friendButton =
                    new AddedFriendButtonPanelView(friendsPanelView, friendPanelView, friend);
            addedFriendsPanel.add(friendButton);
            addedFriendsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }
}
