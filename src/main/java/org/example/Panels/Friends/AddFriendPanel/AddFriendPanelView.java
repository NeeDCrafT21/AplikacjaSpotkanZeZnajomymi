package org.example.Panels.Friends.AddFriendPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import org.example.Models.Friend;
import org.example.Panels.Friends.FriendPanel.FriendPanelView;

public class AddFriendPanelView extends AddFriendPanelTemplate implements ActionListener {
    public AddFriendPanelView(FriendPanelView friendPanelView, List<Friend> friends) {
        this.friendPanelView = friendPanelView;
        this.friends = friends;
        controller = new AddFriendPanelController(this);

        ImageIcon closeIcon = new ImageIcon("close_icon.png");
        closeButton = new JButton();
        closeButton.setBounds(10, 10, 30, 30);
        closeButton.setIcon(closeIcon);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Add new friend");
        titleLabel.setBounds(60, 10, 320, 50);
        titleLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
        titleLabel.setFont(new Font(null, Font.BOLD, 20));

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name");
        nameLabel.setBounds(20, 65, 320, 30);
        nameLabel.setFont(new Font(null, Font.PLAIN, 15));

        nameTextField = new JTextField();
        nameTextField.setBounds(20, 95, 200, 25);
        nameTextField.setFont(new Font(null, Font.PLAIN, 15));

        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setText("Description");
        descriptionLabel.setBounds(20, 120, 320, 30);
        descriptionLabel.setFont(new Font(null, Font.PLAIN, 15));

        descriptionTextArea = new JTextArea(5, 5);
        descriptionTextArea.setFont(new Font(null, Font.PLAIN, 15));
        descriptionTextArea.setLineWrap(true);

        JScrollPane descriptionPane = new JScrollPane(descriptionTextArea);
        descriptionPane.setBounds(20, 150, 200, 70);

        addFriendButton = new JButton("Add friend");
        addFriendButton.setBounds(150, 240, 100, 50);
        addFriendButton.setFocusable(false);
        addFriendButton.addActionListener(this);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(850, 10, 400, 300);
        this.setLayout(null);
        this.setVisible(false);

        this.add(closeButton);
        this.add(titleLabel);
        this.add(nameLabel);
        this.add(nameTextField);
        this.add(descriptionLabel);
        this.add(descriptionPane);
        this.add(addFriendButton);

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
