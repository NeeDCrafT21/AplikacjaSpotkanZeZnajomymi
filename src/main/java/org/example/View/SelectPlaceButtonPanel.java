package org.example.View;

import org.example.Model.ExpMapMarker;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectPlaceButtonPanel extends JPanel implements MouseListener {
    CreateMeetingSelectPlaceScrollPane createMeetingSelectPlaceScrollPane;
    ExpMapMarker marker;
    Boolean isSelected = false;

    public SelectPlaceButtonPanel(CreateMeetingSelectPlaceScrollPane createMeetingSelectPlaceScrollPane, ExpMapMarker marker) {
        this.createMeetingSelectPlaceScrollPane = createMeetingSelectPlaceScrollPane;
        this.marker = marker;

        JTextArea nameLabel = new JTextArea(marker.getName());
        nameLabel.setBounds(65, 10, 105, 45);
        nameLabel.setFont(new Font(null, Font.BOLD, 12));
        nameLabel.setBackground(null);
        nameLabel.setLineWrap(true);
        nameLabel.setEditable(false);

//        ImageIcon profilePicture = new ImageIcon(friend.getProfilePicture().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
//        JLabel profilePictureLabel = new JLabel(profilePicture);
//        profilePictureLabel.setBounds(10, 10, 50, 50);

        this.setPreferredSize(new Dimension(180, 70));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.setLayout(null);

        this.add(nameLabel);
//        this.add(profilePictureLabel);

        this.addMouseListener(this);
    }

    public void deselect() {
        this.setBackground(UIManager.getColor ( "Panel.background" ));
        isSelected = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(isSelected) {
            deselect();
            createMeetingSelectPlaceScrollPane.setSelectedPlace(null);
        }
        else {
            createMeetingSelectPlaceScrollPane.deselectMarkerButtons();
            this.setBackground(Color.GREEN);
            isSelected = true;
            createMeetingSelectPlaceScrollPane.setSelectedPlace(marker);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}
