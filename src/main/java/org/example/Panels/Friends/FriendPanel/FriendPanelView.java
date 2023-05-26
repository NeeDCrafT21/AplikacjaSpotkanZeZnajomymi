package org.example.Panels.Friends.FriendPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class FriendPanelView extends FriendPanelTemplate implements ActionListener {
    public FriendPanelView() {
        ImageIcon closeIcon = new ImageIcon("close_icon.png");
        closeButton = new JButton();
        closeButton.setBounds(10, 10, 30, 30);
        closeButton.setIcon(closeIcon);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);
        controller = new FriendPanelController(this);

        titleLabel = new JLabel();
        titleLabel.setBounds(60, 10, 320, 50);
        titleLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
        titleLabel.setFont(new Font(null, Font.BOLD, 20));

        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setText("Description");
        descriptionLabel.setBounds(20, 65, 320, 30);
        descriptionLabel.setFont(new Font(null, Font.PLAIN, 15));

        descriptionTextArea = new JTextArea(5, 5);
        descriptionTextArea.setFont(new Font(null, Font.PLAIN, 15));
        descriptionTextArea.setLineWrap(true);
        //        descriptionTextArea.setEditable(false);

        JScrollPane descriptionPane = new JScrollPane(descriptionTextArea);
        descriptionPane.setBounds(20, 95, 200, 180);

        profilePictureLabel = new JLabel();
        profilePictureLabel.setBounds(235, 95, 140, 140);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(850, 10, 400, 300);
        this.setLayout(null);
        this.setVisible(false);

        this.add(closeButton);
        this.add(titleLabel);
        this.add(descriptionLabel);
        this.add(descriptionPane);
        this.add(profilePictureLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.buttonClicked(e);
    }
}
