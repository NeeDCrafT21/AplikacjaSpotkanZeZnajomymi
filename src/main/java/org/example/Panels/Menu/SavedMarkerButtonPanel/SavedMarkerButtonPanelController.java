package org.example.Panels.Menu.SavedMarkerButtonPanel;

import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SavedMarkerButtonPanelController {
    SavedMarkerButtonPanelView view;

    public void mouseClicked(MouseEvent e) {
        System.out.printf(view.marker.getName());
        view.menuPanel.getController().closePanel();
        view.markerPanelView.getController().setupMarkerNewInfo(view.marker);
    }

    public void mouseEntered(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    public void mouseExited(MouseEvent e) {
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
}
