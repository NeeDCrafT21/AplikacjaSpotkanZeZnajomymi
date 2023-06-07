package org.example.Panels.Friends.AddFriendPanel;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import org.example.Models.Friend;
import org.example.Models.Views;
import org.example.Panels.Friends.FriendPanel.FriendPanelView;
import org.example.Service.DBConnection;

public class AddFriendPanelView extends AddFriendPanelTemplate implements ActionListener {
    public AddFriendPanelView(FriendPanelView friendPanelView) {
        this.friendPanelView = friendPanelView;
        this.friends = Views.mainFrameView.getFriends();
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
        nameLabel.setBounds(20, 65, 195, 30);
        nameLabel.setFont(new Font(null, Font.BOLD, 15));

        nameTextField = new JTextField();
        nameTextField.setBounds(20, 95, 195, 25);
        nameTextField.setFont(new Font(null, Font.PLAIN, 15));
        nameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                controller.focusLost(e);
            }
        });

        JLabel nicknameLabel = new JLabel();
        nicknameLabel.setText("Nickname");
        nicknameLabel.setBounds(230, 65, 150, 30);
        nicknameLabel.setFont(new Font(null, Font.BOLD, 15));

        nicknameTextField = new JTextField();
        nicknameTextField.setBounds(230, 95, 150, 25);
        nicknameTextField.setFont(new Font(null, Font.PLAIN, 15));

        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setText("Description");
        descriptionLabel.setBounds(20, 120, 200, 30);
        descriptionLabel.setFont(new Font(null, Font.BOLD, 15));

        descriptionTextArea = new JTextArea(5, 5);
        descriptionTextArea.setFont(new Font(null, Font.PLAIN, 15));
        descriptionTextArea.setLineWrap(true);

        JScrollPane descriptionPane = new JScrollPane(descriptionTextArea);
        descriptionPane.setBounds(20, 150, 200, 70);

        addFriendButton = new JButton("Add friend");
        addFriendButton.setBounds(150, 255, 100, 35);
        addFriendButton.setFocusable(false);
        addFriendButton.addActionListener(this);

        errorLabel = new JLabel("error", SwingConstants.CENTER);
        errorLabel.setBounds(20, 225, 360, 30);
        errorLabel.setFont(new Font(null, Font.PLAIN, 12));
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(850, 10, 400, 300);
        this.setLayout(null);
        this.setVisible(false);

        this.add(closeButton);
        this.add(titleLabel);
        this.add(nameLabel);
        this.add(nameTextField);
        this.add(nicknameLabel);
        this.add(nicknameTextField);
        this.add(descriptionLabel);
        this.add(descriptionPane);
        this.add(addFriendButton);
        this.add(errorLabel);

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
