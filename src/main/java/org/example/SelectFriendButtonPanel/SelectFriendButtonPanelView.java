package org.example.SelectFriendButtonPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import org.example.CreateMeetingSelectFriendsScrollPane.CreateMeetingSelectFriendsScrollPaneView;
import org.example.Model.Friend;

public class SelectFriendButtonPanelView extends SelectFriendButtonPanelTemplate implements MouseListener {
    public SelectFriendButtonPanelView(
            CreateMeetingSelectFriendsScrollPaneView createMeetingSelectFriendsScrollPaneView, Friend friend) {
        this.createMeetingSelectFriendsScrollPaneView = createMeetingSelectFriendsScrollPaneView;
        this.friend = friend;
        controller = new SelectFriendButtonPanelController(this);

        JTextArea nameLabel = new JTextArea(friend.getName());
        nameLabel.setBounds(65, 10, 105, 45);
        nameLabel.setFont(new Font(null, Font.BOLD, 12));
        nameLabel.setBackground(null);
        nameLabel.setLineWrap(true);
        nameLabel.setEditable(false);

        ImageIcon profilePicture =
                new ImageIcon(friend.getProfilePicture().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel profilePictureLabel = new JLabel(profilePicture);
        profilePictureLabel.setBounds(10, 10, 50, 50);

        this.setPreferredSize(new Dimension(180, 70));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.setLayout(null);

        this.add(nameLabel);
        this.add(profilePictureLabel);

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
