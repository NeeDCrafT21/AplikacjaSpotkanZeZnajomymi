package org.example.Panels.Markers.CreateMarkerPanel;

import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.*;
import lombok.AllArgsConstructor;
import org.example.Models.Controllers;
import org.example.Models.ExpMapMarker;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

@AllArgsConstructor
public class CreateMarkerController {

    CreateMarkerPanelView view;

    public void clearPanelInfo() {
        view.nameTextField.setText("");
        view.descriptionTextArea.setText("");
        view.errorLabel.setVisible(false);
    }

    public void getNewMarkerPosition(ICoordinate newMarkerPosition) {
        view.markerPosition = newMarkerPosition;

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                view.marker = new ExpMapMarker("New marker", (Coordinate) view.markerPosition);
                return null;
            }

            @Override
            protected void done() {
                view.map.addMapMarker(view.marker);
            }
        };
        worker.execute();
    }

    public void buttonClicked(ActionEvent e) {
        if (e.getSource() == view.closeButton) {
            view.setVisible(false);
            clearPanelInfo();
            view.map.removeMapMarker(view.marker);
        } else if (e.getSource() == view.addMarkerButton && !Objects.equals(view.nameTextField.getText(), "")) {
            view.marker.setName(view.nameTextField.getText());
            view.marker.setDescription(view.descriptionTextArea.getText());
            view.marker.setCreated(true);
            Controllers.mainFrameController.getDbConnection().addMarker(view.marker);
            view.getParent().repaint();
            view.setVisible(false);
            clearPanelInfo();
        } else {
            view.errorLabel.setText("Missing marker name");
            view.errorLabel.setVisible(true);
        }
    }
}
