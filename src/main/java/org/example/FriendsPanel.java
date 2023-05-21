package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class FriendsPanel extends JPanel implements ActionListener {
    FriendPanel friendPanel;
    AddFriendPanel addFriendPanel;
    List<Friend> friends;
    AddedFriendsScrollPane addedFriendsScrollPane;
    private JButton closeButton;
    private JButton addFriendButton;

    FriendsPanel(FriendPanel friendPanel, AddFriendPanel addFriendPanel, List<Friend> friends) {
        this.friendPanel = friendPanel;
        this.addFriendPanel = addFriendPanel;
        this.friends = friends;

        ImageIcon closeIcon = new ImageIcon("close_icon.png");
        closeButton = new JButton();
        closeButton.setBounds(10, 10,30, 30);
        closeButton.setIcon(closeIcon);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        ImageIcon addFriendIcon = new ImageIcon("add_friend_icon.png");
        addFriendButton = new JButton("Add friend");
        addFriendButton.setBounds(45, 10,145, 30);
        addFriendButton.setIcon(addFriendIcon);
        addFriendButton.setFocusable(false);
        addFriendButton.addActionListener(this);

        addedFriendsScrollPane = new AddedFriendsScrollPane(this, friendPanel, friends);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(1050, 10, 200, 600);
        this.setLayout(null);

        this.add(closeButton);
        this.add(addFriendButton);
        this.add(addedFriendsScrollPane);

        this.setVisible(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeButton) {
            this.setVisible(false);
        }
        if(e.getSource() == addFriendButton) {
            this.setVisible(false);
            addFriendPanel.setVisible(true);
        }
    }
}
