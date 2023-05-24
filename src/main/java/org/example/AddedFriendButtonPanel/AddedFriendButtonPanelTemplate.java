package org.example.AddedFriendButtonPanel;

import javax.swing.*;
import lombok.Getter;
import org.example.FriendPanel.FriendPanelView;
import org.example.FriendsPanel.FriendsPanelView;
import org.example.Model.Friend;

@Getter
public abstract class AddedFriendButtonPanelTemplate extends JPanel {
    protected AddedFriendButtonPanelController controller;
    protected FriendsPanelView friendsPanelView;
    protected FriendPanelView friendPanelView;
    protected Friend friend;
}
