package org.example.AddedFriendsScrollPane;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import lombok.Getter;
import org.example.AddedFriendButtonPanel.AddedFriendButtonPanelView;
import org.example.FriendPanel.FriendPanelView;
import org.example.FriendsPanel.FriendsPanelView;
import org.example.Model.Friend;

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
