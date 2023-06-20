package org.example.Panels.Meetings.MeetingPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import org.example.Models.Views;
import org.example.Panels.Meetings.MeetingFriendsScrollPane.MeetingFriendsScrollPaneView;

public class MeetingPanelView extends MeetingPanelTemplate implements ActionListener {
    public MeetingPanelView() {
        controller = new MeetingPanelController(this);
        Views.meetingPanelView = this;

        ImageIcon closeIcon = new ImageIcon("close_icon.png");
        closeMenuButton = new JButton();
        closeMenuButton.setBounds(360, 10, 30, 30);
        closeMenuButton.setIcon(closeIcon);
        closeMenuButton.setFocusable(false);
        closeMenuButton.addActionListener(this);

        titleLabel = new JLabel();
        titleLabel.setText("<html>Meeting in: </html>");
        titleLabel.setBounds(20, 20, 320, 50);
        titleLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
        titleLabel.setFont(new Font(null, Font.BOLD, 15));
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        JLabel locationInfoLabel = new JLabel("Location info:");
        locationInfoLabel.setBounds(20, 80, 320, 30);
        locationInfoLabel.setFont(new Font(null, Font.BOLD, 20));

        locationDescriptionLabel = new JLabel("Description");
        locationDescriptionLabel.setBounds(20, 110, 320, 30);
        locationDescriptionLabel.setFont(new Font(null, Font.BOLD, 17));

        locationDescriptionTextArea = new JTextArea(null, 5, 5);
        locationDescriptionTextArea.setFont(new Font(null, Font.PLAIN, 15));
        locationDescriptionTextArea.setLineWrap(true);
        locationDescriptionTextArea.setEditable(false);

        JScrollPane locationDescriptionScrollPane = new JScrollPane(locationDescriptionTextArea);
        locationDescriptionScrollPane.setBounds(20, 140, 320, 150);

        JLabel locationAddressLabel = new JLabel("Address");
        locationAddressLabel.setBounds(20, 295, 320, 30);
        locationAddressLabel.setFont(new Font(null, Font.BOLD, 17));

        locationAddressTextArea = new JTextArea(null, 5, 5);
        locationAddressTextArea.setBounds(20, 325, 320, 100);
        locationAddressTextArea.setFont(new Font(null, Font.PLAIN, 15));
        locationAddressTextArea.setLineWrap(true);
        locationAddressTextArea.setEditable(false);
        locationAddressTextArea.setBorder(null);

        JLabel meetingInfoLabel = new JLabel("Meeting info:");
        meetingInfoLabel.setBounds(20, 430, 320, 30);
        meetingInfoLabel.setFont(new Font(null, Font.BOLD, 20));

        JLabel meetingDateLabel = new JLabel("Date");
        meetingDateLabel.setBounds(20, 460, 320, 30);
        meetingDateLabel.setFont(new Font(null, Font.BOLD, 17));

        meetingDateInfoLabel = new JLabel();
        meetingDateInfoLabel.setBounds(20, 485, 320, 30);
        meetingDateInfoLabel.setFont(new Font(null, Font.PLAIN, 15));

        JLabel meetingTimeLabel = new JLabel("Time");
        meetingTimeLabel.setBounds(250, 460, 320, 30);
        meetingTimeLabel.setFont(new Font(null, Font.BOLD, 17));

        meetingTimeInfoLabel = new JLabel();
        meetingTimeInfoLabel.setBounds(250, 485, 320, 30);
        meetingTimeInfoLabel.setFont(new Font(null, Font.PLAIN, 15));

        JLabel friendsLabel = new JLabel("Friends:");
        friendsLabel.setBounds(20, 520, 320, 30);
        friendsLabel.setFont(new Font(null, Font.BOLD, 20));

        meetingFriendsScrollPaneView = new MeetingFriendsScrollPaneView();

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(10, 10, 400, 655);
        this.setLayout(null);
        this.setVisible(false);

        this.add(closeMenuButton);
        this.add(titleLabel);
        this.add(locationInfoLabel);
        this.add(locationDescriptionLabel);
        this.add(locationDescriptionScrollPane);
        this.add(locationAddressLabel);
        this.add(locationAddressTextArea);
        this.add(meetingInfoLabel);
        this.add(meetingDateLabel);
        this.add(meetingDateInfoLabel);
        this.add(meetingTimeLabel);
        this.add(meetingTimeInfoLabel);
        this.add(friendsLabel);
        this.add(meetingFriendsScrollPaneView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.actionPerformed(e);
    }
}
