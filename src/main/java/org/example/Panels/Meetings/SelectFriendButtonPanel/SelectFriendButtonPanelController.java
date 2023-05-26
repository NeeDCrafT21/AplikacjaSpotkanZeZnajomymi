package org.example.Panels.Meetings.SelectFriendButtonPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SelectFriendButtonPanelController {
    SelectFriendButtonPanelView view;

    public void mouseClicked(MouseEvent e) {
        if (view.isSelected) {
            view.setBackground(UIManager.getColor("Panel.background"));
            view.createMeetingSelectFriendsScrollPaneView.getController().removeFriendFromList(view.friend);
            view.isSelected = false;
        } else {
            view.setBackground(Color.GREEN);
            view.createMeetingSelectFriendsScrollPaneView.getController().addFriendToList(view.friend);
            view.isSelected = true;
        }
    }

    public void mouseEntered(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    public void mouseExited(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
}
