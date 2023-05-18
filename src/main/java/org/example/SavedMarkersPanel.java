package org.example;

import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SavedMarkersPanel extends JPanel implements ActionListener {

    OSMMap map;
    MarkerPanel markerPanel;
    MenuPanel menuPanel;
    JButton clickedButton;

    public SavedMarkersPanel(OSMMap map,  MarkerPanel markerPanel, MenuPanel menuPanel) {
        this.map = map;
        this.markerPanel = markerPanel;
        this.menuPanel = menuPanel;

        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
            }
        });

        showCreatedMarkers();
    }

    private void showCreatedMarkers() {
        for(MapMarker marker: map.getMapMarkerList()) {
            SavedMarkerButtonPanel markerButton = new SavedMarkerButtonPanel(markerPanel, menuPanel, (ExpMapMarker) marker);
            this.add(markerButton);
            this.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    public void UpdateShowCreatedMarkers() {
        this.removeAll();
        showCreatedMarkers();
    }

    public void closePanel() {
        this.getParent().setVisible(false);
        menuPanel.backButton.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Component button: this.getComponents()) {
            if(e.getSource() == button) {
                String[] parts = ((JButton) button).getText().split(":");
                System.out.println(Integer.parseInt(parts[0]));
                System.out.println(map.getMapMarkerList().get(Integer.parseInt(parts[0])));
                clickedButton = (JButton) button;
            }
        }
    }
}
