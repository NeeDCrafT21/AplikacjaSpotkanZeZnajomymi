package org.example.SelectPlaceButtonPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SelectPlaceButtonPanelController {
    SelectPlaceButtonPanelView view;

    public void deselect() {
        view.setBackground(UIManager.getColor("Panel.background"));
        view.isSelected = false;
    }

    public void mouseClicked(MouseEvent e) {
        if (view.isSelected) {
            deselect();
            view.createMeetingSelectPlaceScrollPaneView.getController().setSelectedPlace(null);
        } else {
            view.createMeetingSelectPlaceScrollPaneView.getController().deselectMarkerButtons();
            view.setBackground(Color.GREEN);
            view.isSelected = true;
            view.createMeetingSelectPlaceScrollPaneView.getController().setSelectedPlace(view.marker);
        }
    }

    public void mouseEntered(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    public void mouseExited(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
}
