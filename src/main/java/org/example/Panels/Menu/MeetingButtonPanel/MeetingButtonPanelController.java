package org.example.Panels.Menu.MeetingButtonPanel;

import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MeetingButtonPanelController {
    MeetingButtonPanelView view;

    public void mouseEntered(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    public void mouseExited(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
}
