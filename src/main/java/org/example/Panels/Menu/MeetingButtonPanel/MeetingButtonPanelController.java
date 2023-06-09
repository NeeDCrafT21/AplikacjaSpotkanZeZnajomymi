package org.example.Panels.Menu.MeetingButtonPanel;

import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import lombok.AllArgsConstructor;
import org.example.Models.Controllers;
import org.example.Models.Views;

@AllArgsConstructor
public class MeetingButtonPanelController {
    MeetingButtonPanelView view;

    public void mouseClicked(MouseEvent e) {
        Views.menuPanelView.setVisible(false);
        Views.meetingPanelView.setVisible(true);
        Controllers.meetingPanelController.updatePanelInfo(view.meeting);
    }

    public void mouseEntered(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    public void mouseExited(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
}
