package org.example.Panels.Meetings.SelectFriendButtonPanel;

import javax.swing.*;
import lombok.Getter;
import org.example.Models.Friend;
import org.example.Panels.Meetings.CreateMeetingSelectFriendsScrollPane.CreateMeetingSelectFriendsScrollPaneView;

@Getter
public abstract class SelectFriendButtonPanelTemplate extends JPanel {
    protected SelectFriendButtonPanelController controller;
    protected CreateMeetingSelectFriendsScrollPaneView createMeetingSelectFriendsScrollPaneView;
    protected Friend friend;
    protected Boolean isSelected = false;
}
