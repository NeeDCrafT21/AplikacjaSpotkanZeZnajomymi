package org.example.Panels.Friends.AddedFriendButtonPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import org.example.Models.Friend;
import org.example.Panels.Friends.FriendPanel.FriendPanelView;
import org.example.Panels.Friends.FriendsPanel.FriendsPanelView;

public class AddedFriendButtonPanelView extends AddedFriendButtonPanelTemplate implements MouseListener {
    public AddedFriendButtonPanelView(
            FriendsPanelView friendsPanelView, FriendPanelView friendPanelView, Friend friend) {
        this.friendPanelView = friendPanelView;
        this.friendsPanelView = friendsPanelView;
        this.friend = friend;
        controller = new AddedFriendButtonPanelController(this);

        JTextArea nameLabel = new JTextArea(friend.getName());
        nameLabel.setBounds(65, 10, 105, 45);
        nameLabel.setFont(new Font(null, Font.BOLD, 12));
        nameLabel.setBackground(null);
        nameLabel.setLineWrap(true);
        nameLabel.setEditable(false);
        nameLabel.setFocusable(false);

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