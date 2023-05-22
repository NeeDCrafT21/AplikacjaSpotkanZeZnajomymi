package org.example.View;

import org.example.Model.Friend;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AddedFriendsScrollPane extends JScrollPane {
    FriendsPanel friendsPanel;
    FriendPanel friendPanel;
    List<Friend> friends;
    JPanel addedFriendsPanel;
    public AddedFriendsScrollPane(FriendsPanel friendsPanel, FriendPanel friendPanel, List<Friend> friends) {
        this.friendsPanel = friendsPanel;
        this.friendPanel = friendPanel;
        this.friends = friends;

        addedFriendsPanel = new JPanel();
        addedFriendsPanel.setLayout(new BoxLayout(addedFriendsPanel, BoxLayout.Y_AXIS));
        addedFriendsPanel.setBackground(Color.WHITE);

        this.setBounds(10, 50, 180, 530);
        this.setBorder(null);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVisible(true);
        this.setViewportView(addedFriendsPanel);

        showAddedFriends();
    }

    private void showAddedFriends() {
        for(Friend friend: friends) {
            AddedFriendButtonPanel friendButton = new AddedFriendButtonPanel(friendsPanel, friendPanel, friend);
            addedFriendsPanel.add(friendButton);
            addedFriendsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    public void updateShowAddedFriends() {
        addedFriendsPanel.removeAll();
        showAddedFriends();
    }
}
