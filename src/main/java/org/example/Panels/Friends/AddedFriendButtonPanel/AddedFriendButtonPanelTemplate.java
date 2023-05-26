package org.example.Panels.Friends.AddedFriendButtonPanel;

import javax.swing.*;
import lombok.Getter;
import org.example.Models.Friend;
import org.example.Panels.Friends.FriendPanel.FriendPanelView;
import org.example.Panels.Friends.FriendsPanel.FriendsPanelView;

@Getter
public abstract class AddedFriendButtonPanelTemplate extends JPanel {
    protected AddedFriendButtonPanelController controller;
    protected FriendsPanelView friendsPanelView;
    protected FriendPanelView friendPanelView;
    protected Friend friend;
}
