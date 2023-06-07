package org.example.Panels.Friends.AddFriendPanel;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.example.Models.Controllers;
import org.example.Models.Friend;

public class AddFriendPanelController {
    AddFriendPanelView view;

    public AddFriendPanelController(AddFriendPanelView view) {
        this.view = view;
        Controllers.addFriendPanelController = this;
    }

    public void focusLost(FocusEvent e) {
        if(!view.nameTextField.getText().equals("") && view.nicknameTextField.getText().equals("")) {
            view.nicknameTextField.setText(view.nameTextField.getText().toLowerCase().replace("\s", ""));
        }
    }

    public void clearInfo() {
        view.nameTextField.setText("");
        view.nicknameTextField.setText("");
        view.descriptionTextArea.setText("");
        view.errorLabel.setVisible(false);
    }

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
                    view.errorLabel.setText("Nickname already in use, use a different one");
                    view.errorLabel.setVisible(true);
                    return;
                }
            }

            view.friends.add(newFriend);
            Controllers.mainFrameController.getDbConnection().addFriend(newFriend);
            view.setVisible(false);
            clearInfo();
            view.friendPanelView.getController().setupFriendInfo(newFriend);
        } else {
            view.errorLabel.setText("Missing friend's name and/or nickname");
            view.errorLabel.setVisible(true);
        }
    }
}
