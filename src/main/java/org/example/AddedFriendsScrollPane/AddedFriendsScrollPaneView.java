package org.example.AddedFriendsScrollPane;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import org.example.FriendPanel.FriendPanelView;
import org.example.FriendsPanel.FriendsPanelView;
import org.example.Model.Friend;

public class AddedFriendsScrollPaneView extends AddedFriendsScrollPaneTemplate {
    public AddedFriendsScrollPaneView(
            FriendsPanelView friendsPanelView, FriendPanelView friendPanelView, List<Friend> friends) {
        this.friendsPanelView = friendsPanelView;
        this.friendPanelView = friendPanelView;
        this.friends = friends;
        controller = new AddedFriendsScrollPaneController(this);

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
}
