package org.example.Panels.Meetings.CreateMeetingSelectFriendsScrollPane;

import lombok.AllArgsConstructor;
import org.example.Models.Friend;

@AllArgsConstructor
public class CreateMeetingSelectFriendsScrollPaneController {
    CreateMeetingSelectFriendsScrollPaneView view;

    public void updateShowAddedFriends() {
        view.selectFriendsPanel.removeAll();
        view.showAddedFriends();
    }

    public void addFriendToList(Friend friend) {
        view.createMeetingPanelView.getSelectedFriends().add(friend);
    }

    public void removeFriendFromList(Friend friend) {
        view.createMeetingPanelView.getSelectedFriends().remove(friend);
    }
}
