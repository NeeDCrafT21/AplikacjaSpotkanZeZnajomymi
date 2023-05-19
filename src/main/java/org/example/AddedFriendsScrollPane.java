package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AddedFriendsScrollPane extends JScrollPane {
    FriendsPanel friendsPanel;
    AddedFriendPanel addedFriendPanel;
    List<AddedFriend> addedFriends;
    JPanel addedFriendsPanel;
    public AddedFriendsScrollPane(FriendsPanel friendsPanel, AddedFriendPanel addedFriendPanel, List<AddedFriend> addedFriends) {
        this.friendsPanel = friendsPanel;
        this.addedFriendPanel = addedFriendPanel;
        this.addedFriends = addedFriends;

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
        for(AddedFriend friend: addedFriends) {
            AddedFriendButtonPanel friendButton = new AddedFriendButtonPanel(friendsPanel, addedFriendPanel, friend);
            addedFriendsPanel.add(friendButton);
            addedFriendsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    public void updateShowAddedFriends() {
        addedFriendsPanel.removeAll();
        showAddedFriends();
    }
}
