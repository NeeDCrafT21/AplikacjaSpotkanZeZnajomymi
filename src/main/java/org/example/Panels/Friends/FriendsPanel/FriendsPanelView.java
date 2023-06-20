package org.example.Panels.Friends.FriendsPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import org.example.Models.Views;
import org.example.Panels.Friends.AddedFriendsScrollPane.AddedFriendsScrollPaneView;

public class FriendsPanelView extends FriendsPanelTemplate implements ActionListener {
    public FriendsPanelView() {
        this.friendPanelView = Views.friendPanelView;
        this.addFriendPanelView = Views.addFriendPanelView;
        this.friends = Views.mainFrameView.getFriends();
        controller = new FriendsPanelController(this);
        Views.friendsPanelView = this;

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
