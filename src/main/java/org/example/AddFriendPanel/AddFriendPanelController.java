package org.example.AddFriendPanel;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.example.Model.Friend;

@AllArgsConstructor
public class AddFriendPanelController {
    AddFriendPanelView view;

    public void buttonClicked(ActionEvent e) {
        if (e.getSource() == view.closeButton) {
            view.setVisible(false);
        } else if (e.getSource() == view.addFriendButton && !Objects.equals(view.nameTextField.getText(), "")) {
            try {
                Friend newFriend = new Friend(view.nameTextField.getText());
                newFriend.setDescription(view.descriptionTextArea.getText());
                view.friends.add(newFriend);
                view.setVisible(false);
                view.nameTextField.setText("");
                view.descriptionTextArea.setText("");
                view.friendPanelView.getController().setupFriendInfo(newFriend);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
