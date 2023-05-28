package org.example.Panels.Menu.SavedMarkerButtonPanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import org.example.Models.ExpMapMarker;
import org.example.Panels.Markers.MarkerPanel.MarkerPanelView;
import org.example.Panels.Menu.MenuPanel.MenuPanelView;

public class SavedMarkerButtonPanelView extends SavedMarkerButtonPanelTemplate implements MouseListener {
    public SavedMarkerButtonPanelView(MarkerPanelView markerPanelView, MenuPanelView menu, ExpMapMarker marker) {
        this.markerPanelView = markerPanelView;
        this.menuPanel = menu;
        this.marker = marker;
        controller = new SavedMarkerButtonPanelController(this);

        JLabel nameLabel = new JLabel(marker.getName());
        nameLabel.setBounds(10, 10, 260, 30);
        nameLabel.setFont(new Font(null, Font.BOLD, 20));

        ImageIcon addressIcon = new ImageIcon("address_icon.png");
        JLabel addressLabel = new JLabel(marker.getLocation().getDisplayName());
        addressLabel.setBounds(10, 70, 150, 18);
        addressLabel.setIcon(addressIcon);
        addressLabel.setFont(new Font(null, Font.PLAIN, 12));

        this.setPreferredSize(new Dimension(280, 100));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.setLayout(null);

        this.add(nameLabel);
        this.add(addressLabel);

        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        controller.mouseClicked(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        controller.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        controller.mouseExited(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}
