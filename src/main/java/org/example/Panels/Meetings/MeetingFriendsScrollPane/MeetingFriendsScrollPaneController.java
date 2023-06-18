package org.example.Panels.Meetings.MeetingFriendsScrollPane;

import lombok.AllArgsConstructor;
import org.example.Models.Controllers;
import org.example.Models.Friend;

import java.util.List;

public class MeetingFriendsScrollPaneController {
    MeetingFriendsScrollPaneView view;

    public MeetingFriendsScrollPaneController(MeetingFriendsScrollPaneView view) {
        this.view = view;
        Controllers.meetingFriendsScrollPaneController = this;
    }

    public void updateFriendsList(List<Friend> friends) {
        view.friendsPanel.removeAll();
        view.showFriends(friends);
    }
}
