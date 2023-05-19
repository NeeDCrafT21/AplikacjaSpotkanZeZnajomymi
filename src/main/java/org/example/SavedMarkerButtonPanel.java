package org.example;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;

public class SavedMarkerButtonPanel extends JPanel implements MouseListener {
    MarkerPanel markerPanel;
    MenuPanel menuPanel;
    ExpMapMarker marker;
    public SavedMarkerButtonPanel(MarkerPanel markerPanel, MenuPanel menu, ExpMapMarker marker) {
        this.markerPanel = markerPanel;
        this.menuPanel = menu;
        this.marker = marker;

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
        System.out.printf(marker.getName());
        menuPanel.closePanel();
        markerPanel.setupMarkerNewInfo(marker);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}
