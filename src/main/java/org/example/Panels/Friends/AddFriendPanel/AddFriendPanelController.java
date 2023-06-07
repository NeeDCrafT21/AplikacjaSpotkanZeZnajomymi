package org.example.Panels.Friends.AddFriendPanel;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.example.Models.Controllers;
import org.example.Models.Friend;

@AllArgsConstructor
public class AddFriendPanelController {
    AddFriendPanelView view;

    public void buttonClicked(ActionEvent e) {
        if (e.getSource() == view.closeButton) {
            view.setVisible(false);
        } else if (e.getSource() == view.addFriendButton
                && !Objects.equals(view.nameTextField.getText(), "")
                && !Objects.equals(view.nicknameTextField.getText(), "")) {
            Friend newFriend = new Friend(view.nicknameTextField.getText(), view.nameTextField.getText());
            newFriend.setDescription(view.descriptionTextArea.getText());

            for (Friend friend : view.friends) {
                if (Objects.equals(friend.getNickname(), newFriend.getNickname())) {
                    System.out.println("Nickname already in use, use a different one");
                    return;
                }
            }

            view.friends.add(newFriend);
            Controllers.mainFrameController.getDbConnection().addFriend(newFriend);
            view.setVisible(false);
            view.nameTextField.setText("");
            view.nicknameTextField.setText("");
            view.descriptionTextArea.setText("");
            view.friendPanelView.getController().setupFriendInfo(newFriend);
        }
    }
}
