package org.example.SelectFriendButtonPanel;

import javax.swing.*;
import lombok.Getter;
import org.example.CreateMeetingSelectFriendsScrollPane.CreateMeetingSelectFriendsScrollPaneView;
import org.example.Model.Friend;

@Getter
public abstract class SelectFriendButtonPanelTemplate extends JPanel {
    protected SelectFriendButtonPanelController controller;
    protected CreateMeetingSelectFriendsScrollPaneView createMeetingSelectFriendsScrollPaneView;
    protected Friend friend;
    protected Boolean isSelected = false;
}
