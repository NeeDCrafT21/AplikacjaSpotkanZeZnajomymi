package org.example.Panels.Markers.MarkerPanel;

import java.awt.event.ActionEvent;
import lombok.AllArgsConstructor;
import org.example.Models.ExpMapMarker;

@AllArgsConstructor
public class MarkerPanelController {
    MarkerPanelView view;

    public void setupMarkerNewInfo(ExpMapMarker marker) {
        view.nameLabel.setText(marker.getName());
        view.descriptionTextArea.setText(marker.getDescription());
        view.setVisible(true);
    }

    public void closePanel() {
        view.setVisible(false);
        // this.getParent().remove(this);
    }

    public void buttonClicked(ActionEvent e) {
        if (e.getSource() == view.closeMenuButton) {
            closePanel();
        }
    }
}
