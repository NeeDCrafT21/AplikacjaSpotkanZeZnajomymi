package org.example;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.List;

public class CreateMeetingSelectFriendsScrollPane extends JScrollPane {
    List<Friend> friends;
    CreateMeetingPanel createMeetingPanel;
    JPanel selectFriendsPanel;

    public CreateMeetingSelectFriendsScrollPane(List<Friend> friends, CreateMeetingPanel createMeetingPanel) {
        this.friends = friends;
        this.createMeetingPanel = createMeetingPanel;

        selectFriendsPanel = new JPanel();
        selectFriendsPanel.setLayout(new BoxLayout(selectFriendsPanel, BoxLayout.Y_AXIS));
        selectFriendsPanel.setBackground(Color.WHITE);

        this.setBounds(10, 50, 200, 595);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Friends"));
        this.setBackground(Color.WHITE);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVisible(true);
        this.setViewportView(selectFriendsPanel);

        showAddedFriends();
    }

    private void showAddedFriends() {
        for(Friend friend: friends) {
            SelectFriendButtonPanel friendButton = new SelectFriendButtonPanel(this, friend);
            selectFriendsPanel.add(friendButton);
            selectFriendsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    public void updateShowAddedFriends() {
        selectFriendsPanel.removeAll();
        showAddedFriends();
    }

    public void addFriendToList(Friend friend) {
        createMeetingPanel.getSelectedFriends().add(friend);
    }

    public void removeFriendFromList(Friend friend) {
        createMeetingPanel.getSelectedFriends().remove(friend);
    }
}
