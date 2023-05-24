package org.example.FriendsPanel;

import java.util.List;
import javax.swing.*;
import lombok.Getter;
import org.example.AddFriendPanel.AddFriendPanelView;
import org.example.AddedFriendsScrollPane.AddedFriendsScrollPaneView;
import org.example.FriendPanel.FriendPanelView;
import org.example.Model.Friend;

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
