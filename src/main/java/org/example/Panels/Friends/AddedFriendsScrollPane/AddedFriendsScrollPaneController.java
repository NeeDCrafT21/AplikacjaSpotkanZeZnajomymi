package org.example.Panels.Friends.AddedFriendsScrollPane;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddedFriendsScrollPaneController {
    AddedFriendsScrollPaneView view;

    public void updateShowAddedFriends() {
        view.addedFriendsPanel.removeAll();
        view.showAddedFriends();
    }
}
