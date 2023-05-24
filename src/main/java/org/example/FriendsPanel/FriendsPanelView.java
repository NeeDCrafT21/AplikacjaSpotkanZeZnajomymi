package org.example.FriendsPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
import org.example.AddFriendPanel.AddFriendPanelView;
import org.example.AddedFriendsScrollPane.AddedFriendsScrollPaneView;
import org.example.FriendPanel.FriendPanelView;
import org.example.Model.Friend;

public class FriendsPanelView extends FriendsPanelTemplate implements ActionListener {
    public FriendsPanelView(
            FriendPanelView friendPanelView, AddFriendPanelView addFriendPanelView, List<Friend> friends) {
        this.friendPanelView = friendPanelView;
        this.addFriendPanelView = addFriendPanelView;
        this.friends = friends;
        controller = new FriendsPanelController(this);

        ImageIcon closeIcon = new ImageIcon("close_icon.png");
        closeButton = new JButton();
        closeButton.setBounds(10, 10, 30, 30);
        closeButton.setIcon(closeIcon);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        ImageIcon addFriendIcon = new ImageIcon("add_friend_icon.png");
        addFriendButton = new JButton("Add friend");
        addFriendButton.setBounds(45, 10, 145, 30);
        addFriendButton.setIcon(addFriendIcon);
        addFriendButton.setFocusable(false);
        addFriendButton.addActionListener(this);

        addedFriendsScrollPaneView = new AddedFriendsScrollPaneView(this, friendPanelView, friends);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(1050, 10, 200, 600);
        this.setLayout(null);

        this.add(closeButton);
        this.add(addFriendButton);
        this.add(addedFriendsScrollPaneView);

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
        controller.buttonClicked(e);
    }
}
