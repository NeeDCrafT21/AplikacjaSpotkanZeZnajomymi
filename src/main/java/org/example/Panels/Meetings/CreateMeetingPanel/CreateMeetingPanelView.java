package org.example.Panels.Meetings.CreateMeetingPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Properties;
import javax.swing.*;
import org.example.Models.Friend;
import org.example.Models.Meeting;
import org.example.Models.OSMMap;
import org.example.Panels.Meetings.CreateMeetingSelectFriendsScrollPane.CreateMeetingSelectFriendsScrollPaneView;
import org.example.Panels.Meetings.CreateMeetingSelectPlaceScrollPane.CreateMeetingSelectPlaceScrollPaneView;
import org.example.Service.DBConnection;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class CreateMeetingPanelView extends CreateMeetingPanelTemplate implements ActionListener {
    public CreateMeetingPanelView(OSMMap map, List<Friend> friends, List<Meeting> meetings) {
        this.map = map;
        this.friends = friends;
        this.meetings = meetings;
        controller = new CreateMeetingPanelController(this);

        dbConnection = new DBConnection();

        ImageIcon closeIcon = new ImageIcon("close_icon.png");
        closeButton = new JButton();
        closeButton.setBounds(660, 10, 30, 30);
        closeButton.setIcon(closeIcon);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        createMeetingSelectFriendsScrollPaneView = new CreateMeetingSelectFriendsScrollPaneView(friends, this);
        createMeetingSelectPlaceScrollPaneView =
                new CreateMeetingSelectPlaceScrollPaneView(map.getMapMarkerList(), this);

        JLabel dateLabel = new JLabel();
        dateLabel.setText("Meeting date:");
        dateLabel.setBounds(440, 300, 140, 45);
        dateLabel.setFont(new Font(null, Font.PLAIN, 15));

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        datePicker.setBounds(440, 335, 160, 26);
        datePicker.setFont(new Font(null, Font.PLAIN, 20));
        datePicker.addActionListener(this);

        JLabel timeLabel = new JLabel();
        timeLabel.setText("Meeting time:");
        timeLabel.setBounds(440, 370, 140, 45);
        timeLabel.setFont(new Font(null, Font.PLAIN, 15));

        hourComboBox = new JComboBox<>(hourList);
        hourComboBox.setBounds(440, 410, 45, 30);

        JLabel timeColonLabel = new JLabel();
        timeColonLabel.setText(":");
        timeColonLabel.setBounds(495, 408, 45, 30);
        timeColonLabel.setFont(new Font(null, Font.BOLD, 18));

        minutesComboBox = new JComboBox<>(minutesList);
        minutesComboBox.setBounds(510, 410, 45, 30);

        createButton = new JButton("Create meeting");
        createButton.setBounds(485, 595, 140, 45);
        createButton.setFocusable(false);
        createButton.addActionListener(this);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(10, 10, 700, 655);
        this.setLayout(null);
        this.setVisible(false);

        this.add(closeButton);
        this.add(createMeetingSelectFriendsScrollPaneView);
        this.add(createMeetingSelectPlaceScrollPaneView);
        this.add(dateLabel);
        this.add(datePicker);
        this.add(timeLabel);
        this.add(hourComboBox);
        this.add(timeColonLabel);
        this.add(minutesComboBox);
        this.add(createButton);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
                System.out.printf(selectedFriends.toString());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.buttonClicked(e);
    }
}
