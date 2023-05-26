package org.example.Panels.Friends.FriendsPanel;

import java.util.List;
import javax.swing.*;
import lombok.Getter;
import org.example.Models.Friend;
import org.example.Panels.Friends.AddFriendPanel.AddFriendPanelView;
import org.example.Panels.Friends.AddedFriendsScrollPane.AddedFriendsScrollPaneView;
import org.example.Panels.Friends.FriendPanel.FriendPanelView;

@Getter
public abstract class FriendsPanelTemplate extends JPanel {
    protected FriendsPanelController controller;
    protected FriendPanelView friendPanelView;
    protected AddFriendPanelView addFriendPanelView;
    protected List<Friend> friends;
    protected AddedFriendsScrollPaneView addedFriendsScrollPaneView;
    protected JButton closeButton;
    protected JButton addFriendButton;
}
