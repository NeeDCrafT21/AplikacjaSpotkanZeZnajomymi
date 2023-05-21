package org.example;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class CreateMeetingPanel extends JPanel implements ActionListener {
    OSMMap map;
    List<Friend> friends;
    List<Meeting> meetings;
    private JButton closeButton;
    private JButton createButton;
    private JDatePickerImpl datePicker;
    String[] hourList = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    String[] minutesList = {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    private JComboBox<String> hourComboBox;
    private JComboBox<String> minutesComboBox;
    public CreateMeetingSelectFriendsScrollPane createMeetingSelectFriendsScrollPane;
    public CreateMeetingSelectPlaceScrollPane createMeetingSelectPlaceScrollPane;
    private List<Friend> selectedFriends = new ArrayList<>();
    private ExpMapMarker selectedPlace = null;
    public CreateMeetingPanel(OSMMap map, List<Friend> friends, List<Meeting> meetings) {
        this.map = map;
        this.friends = friends;
        this.meetings = meetings;

        ImageIcon closeIcon = new ImageIcon("close_icon.png");
        closeButton = new JButton();
        closeButton.setBounds(660, 10,30, 30);
        closeButton.setIcon(closeIcon);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        createMeetingSelectFriendsScrollPane = new CreateMeetingSelectFriendsScrollPane(friends, this);
        createMeetingSelectPlaceScrollPane = new CreateMeetingSelectPlaceScrollPane(map.getMapMarkerList(), this);

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
        this.add(createMeetingSelectFriendsScrollPane);
        this.add(createMeetingSelectPlaceScrollPane);
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

    public void clearPanelInfo() {
        createMeetingSelectFriendsScrollPane.updateShowAddedFriends();
        createMeetingSelectPlaceScrollPane.updateShowCreatedMarkers();
        datePicker.getModel().setValue(null);
        hourComboBox.setSelectedIndex(0);
        minutesComboBox.setSelectedIndex(0);
        selectedFriends.clear();
        selectedPlace = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeButton) {
            this.setVisible(false);
        }
        else if(e.getSource() == createButton) {
            Date newMeetingDate = (Date) datePicker.getModel().getValue();
            LocalTime newMeetingTime = LocalTime.parse(hourComboBox.getSelectedItem() +":"+minutesComboBox.getSelectedItem());
            Meeting newMeeting = new Meeting(selectedFriends, selectedPlace, newMeetingDate, newMeetingTime);
            meetings.add(newMeeting);
            newMeeting.printMeetingInfo();
            clearPanelInfo();
            this.setVisible(false);
        }
    }

    public List<Friend> getSelectedFriends() {
        return selectedFriends;
    }


    public ExpMapMarker getSelectedPlace() {
        return selectedPlace;
    }

    public void setSelectedPlace(ExpMapMarker selectedPlace) {
        this.selectedPlace = selectedPlace;
    }
}
