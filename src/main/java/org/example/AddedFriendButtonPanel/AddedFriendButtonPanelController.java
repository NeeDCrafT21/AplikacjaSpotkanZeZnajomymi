package org.example.AddedFriendButtonPanel;

import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddedFriendButtonPanelController {
    AddedFriendButtonPanelView view;

    public void mouseClicked(MouseEvent e) {
        view.friendsPanelView.setVisible(false);
        view.friendPanelView.getController().setupFriendInfo(view.friend);
        view.friendPanelView.setVisible(true);
    }

    public void mouseEntered(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    public void mouseExited(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
}
