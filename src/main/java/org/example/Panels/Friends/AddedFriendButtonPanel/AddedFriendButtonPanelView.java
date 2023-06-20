package org.example.Panels.Friends.AddedFriendButtonPanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import org.example.Models.Friend;
import org.example.Panels.Friends.FriendPanel.FriendPanelView;
import org.example.Panels.Friends.FriendsPanel.FriendsPanelView;

public class AddedFriendButtonPanelView extends AddedFriendButtonPanelTemplate
        implements MouseListener, ActionListener {
    public AddedFriendButtonPanelView(
            FriendsPanelView friendsPanelView, FriendPanelView friendPanelView, Friend friend) {
        this.friendPanelView = friendPanelView;
        this.friendsPanelView = friendsPanelView;
        this.friend = friend;
        controller = new AddedFriendButtonPanelController(this);

        nameLabel = new JTextArea(friend.getName());
        nameLabel.setBounds(65, 10, 105, 45);
        nameLabel.setFont(new Font(null, Font.BOLD, 12));
        nameLabel.setBackground(null);
        nameLabel.setLineWrap(true);
        nameLabel.setEditable(false);
        nameLabel.setFocusable(false);
        nameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                controller.panelElementMouseEntered(e);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                controller.mouseClicked(e);
            }
        });

        ImageIcon profilePicture =
                new ImageIcon(friend.getProfilePicture().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel profilePictureLabel = new JLabel(profilePicture);
        profilePictureLabel.setBounds(10, 10, 50, 50);

        ImageIcon closeIcon = new ImageIcon("close_icon.png");
        closeButton = new JButton();
        closeButton.setBounds(5, 5, 20, 20);
        closeButton.setIcon(closeIcon);
        closeButton.setFocusable(false);
        closeButton.setVisible(false);
        closeButton.addActionListener(this);
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                controller.panelElementMouseEntered(e);
            }
        });

        JLayeredPane layeredMainPane = new JLayeredPane();
        layeredMainPane.setBounds(0, 0, 180, 70);

        this.setPreferredSize(new Dimension(180, 70));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.setLayout(null);

        this.add(layeredMainPane);

        layeredMainPane.add(nameLabel, JLayeredPane.PALETTE_LAYER);
        layeredMainPane.add(profilePictureLabel, JLayeredPane.PALETTE_LAYER);
        layeredMainPane.add(closeButton, JLayeredPane.POPUP_LAYER);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.actionPerformed(e);
    }
}
