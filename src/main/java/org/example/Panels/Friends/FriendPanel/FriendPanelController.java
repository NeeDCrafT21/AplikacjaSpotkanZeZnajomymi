package org.example.Panels.Friends.FriendPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import lombok.AllArgsConstructor;
import org.example.Models.Friend;

@AllArgsConstructor
public class FriendPanelController {
    FriendPanelView view;

    public void setupFriendInfo(Friend friend) {
        view.titleLabel.setText(friend.getName());
        view.descriptionTextArea.setText(friend.getDescription());
        view.profilePicture =
                new ImageIcon(friend.getProfilePicture().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
        view.profilePictureLabel.setIcon(view.profilePicture);
        view.setVisible(true);
    }

    public void buttonClicked(ActionEvent e) {
        if (e.getSource() == view.closeButton) {
            view.setVisible(false);
        }
    }
}
