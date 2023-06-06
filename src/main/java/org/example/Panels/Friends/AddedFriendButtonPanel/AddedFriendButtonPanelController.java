package org.example.Panels.Friends.AddedFriendButtonPanel;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddedFriendButtonPanelController {
    AddedFriendButtonPanelView view;

    public void panelElementMouseEntered(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        view.closeButton.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        view.friendsPanelView.setVisible(false);
        view.friendPanelView.getController().setupFriendInfo(view.friend);
        view.friendPanelView.setVisible(true);
    }

    public void mouseEntered(MouseEvent e) {
        view.closeButton.setVisible(true);
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    public void mouseExited(MouseEvent e) {
        view.closeButton.setVisible(false);
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.closeButton) {
            view.setVisible(false);
        }
    }

}
