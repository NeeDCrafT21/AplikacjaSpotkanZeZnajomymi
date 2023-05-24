package org.example.SavedMarkersScrollPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SavedMarkersScrollPaneController {
    SavedMarkersScrollPaneView view;

    public void UpdateShowCreatedMarkers() {
        view.savedMarkersPanel.removeAll();
        view.showCreatedMarkers();
    }

    public void actionPerformed(ActionEvent e) {
        for (Component button : view.savedMarkersPanel.getComponents()) {
            if (e.getSource() == button) {
                view.clickedButton = (JButton) button;
            }
        }
    }
}
