package org.example.Panels.Meetings.MeetingFriendButtonPanel;

import lombok.AllArgsConstructor;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseEvent;

@AllArgsConstructor
public class MeetingFriendButtonPanelController {
    MeetingFriendButtonPanelView view;

    public void mouseEntered(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    public void mouseExited(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

}
