package org.example.Panels.Markers.MarkerPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import lombok.AllArgsConstructor;
import org.example.Models.ExpMapMarker;

import javax.swing.*;

@AllArgsConstructor
public class MarkerPanelController {
    MarkerPanelView view;

    public void setupMarkerNewInfo(ExpMapMarker marker) {
        view.nameLabel.setText(marker.getName());
        view.descriptionTextArea.setText(marker.getDescription());
        view.locationPicture =
                new ImageIcon(marker.getLocationPicture().getScaledInstance(350, 155, Image.SCALE_DEFAULT));
        view.locationPictureLabel.setIcon(view.locationPicture);
        view.addressTextArea.setText(marker.getLocation().getDisplayName());
        view.lonLabel.setText("Lon.: " + marker.getLocation().getLon());
        view.latLabel.setText("Lat.: " + marker.getLocation().getLat());
        view.setVisible(true);
        System.out.println(marker.getLocation().getAddress());
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
