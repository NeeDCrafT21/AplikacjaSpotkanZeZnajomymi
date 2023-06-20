package org.example.Panels.Meetings.SelectPlaceButtonPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import org.example.Models.ExpMapMarker;
import org.example.Panels.Meetings.CreateMeetingSelectPlaceScrollPane.CreateMeetingSelectPlaceScrollPaneView;

public class SelectPlaceButtonPanelView extends SelectPlaceButtonPanelTemplate implements MouseListener {
    public SelectPlaceButtonPanelView(
            CreateMeetingSelectPlaceScrollPaneView createMeetingSelectPlaceScrollPaneView, ExpMapMarker marker) {
        this.createMeetingSelectPlaceScrollPaneView = createMeetingSelectPlaceScrollPaneView;
        this.marker = marker;
        controller = new SelectPlaceButtonPanelController(this);

        JTextArea nameLabel = new JTextArea(marker.getName());
        nameLabel.setBounds(65, 10, 105, 45);
        nameLabel.setFont(new Font(null, Font.BOLD, 12));
        nameLabel.setBackground(null);
        nameLabel.setLineWrap(true);
        nameLabel.setEditable(false);
        nameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                controller.mouseEntered(e);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                controller.mouseClicked(e);
            }
        });

        //        ImageIcon profilePicture = new ImageIcon(friend.getProfilePicture().getScaledInstance(50, 50,
        // Image.SCALE_DEFAULT));
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
