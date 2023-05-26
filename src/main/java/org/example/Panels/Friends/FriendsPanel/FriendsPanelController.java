package org.example.Panels.Friends.FriendsPanel;

import java.awt.event.ActionEvent;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FriendsPanelController {
    FriendsPanelView view;

    public void buttonClicked(ActionEvent e) {
        if (e.getSource() == view.closeButton) {
            view.setVisible(false);
        }
        if (e.getSource() == view.addFriendButton) {
            view.setVisible(false);
            view.addFriendPanelView.setVisible(true);
        }
    }
}
