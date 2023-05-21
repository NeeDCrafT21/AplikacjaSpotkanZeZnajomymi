package org.example;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddedFriendButtonPanel extends JPanel implements MouseListener {
    FriendsPanel friendsPanel;
    FriendPanel friendPanel;
    Friend friend;
    public AddedFriendButtonPanel(FriendsPanel friendsPanel, FriendPanel friendPanel, Friend friend) {
        this.friendPanel = friendPanel;
        this.friendsPanel = friendsPanel;
        this.friend = friend;

        JTextArea nameLabel = new JTextArea(friend.getName());
        nameLabel.setBounds(65, 10, 105, 45);
        nameLabel.setFont(new Font(null, Font.BOLD, 12));
        nameLabel.setBackground(null);
        nameLabel.setLineWrap(true);
        nameLabel.setEditable(false);

        ImageIcon profilePicture = new ImageIcon(friend.getProfilePicture().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
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
        friendsPanel.setVisible(false);
        friendPanel.setupFriendInfo(friend);
        friendPanel.setVisible(true);
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
