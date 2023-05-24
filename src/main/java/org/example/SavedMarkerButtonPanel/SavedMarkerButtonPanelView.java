package org.example.SavedMarkerButtonPanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import org.example.MarkerPanel.MarkerPanelView;
import org.example.MenuPanel.MenuPanelView;
import org.example.Model.ExpMapMarker;

public class SavedMarkerButtonPanelView extends SavedMarkerButtonPanelTemplate implements MouseListener {
    public SavedMarkerButtonPanelView(MarkerPanelView markerPanelView, MenuPanelView menu, ExpMapMarker marker) {
        this.markerPanelView = markerPanelView;
        this.menuPanel = menu;
        this.marker = marker;
        controller = new SavedMarkerButtonPanelController(this);

        JLabel nameLabel = new JLabel(marker.getName());
        nameLabel.setBounds(10, 10, 260, 30);
        nameLabel.setFont(new Font(null, Font.BOLD, 20));

        this.setPreferredSize(new Dimension(280, 100));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.setLayout(null);

        this.add(nameLabel);

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
