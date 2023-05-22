package org.example.View;

import org.example.Model.ExpMapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.List;

public class CreateMeetingSelectPlaceScrollPane extends JScrollPane{
    List<MapMarker> markers;
    CreateMeetingPanel createMeetingPanel;
    JPanel selectPlacePanel;

    public CreateMeetingSelectPlaceScrollPane(List<MapMarker> markers, CreateMeetingPanel createMeetingPanel) {
        this.markers = markers;
        this.createMeetingPanel = createMeetingPanel;

        selectPlacePanel = new JPanel();
        selectPlacePanel.setLayout(new BoxLayout(selectPlacePanel, BoxLayout.Y_AXIS));
        selectPlacePanel.setBackground(Color.WHITE);

        this.setBounds(220, 50, 200, 595);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Places"));
        this.setBackground(Color.WHITE);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVisible(true);
        this.setViewportView(selectPlacePanel);

        showCreatedMarkers();
    }

    private void showCreatedMarkers() {
        for(MapMarker marker: markers) {
            SelectPlaceButtonPanel markerButton = new SelectPlaceButtonPanel(this, (ExpMapMarker) marker);
            selectPlacePanel.add(markerButton);
            selectPlacePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    public void updateShowCreatedMarkers() {
        selectPlacePanel.removeAll();
        showCreatedMarkers();
    }

    public void deselectMarkerButtons() {
        for(Component button: selectPlacePanel.getComponents()) {
            if(button.getClass() != Box.Filler.class){
                ((SelectPlaceButtonPanel) button).deselect();
            }
        }
    }

    public void setSelectedPlace(ExpMapMarker selectedPlace) {
        createMeetingPanel.setSelectedPlace(selectedPlace);
    }
}
