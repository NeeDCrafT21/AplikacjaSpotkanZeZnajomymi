package org.example.Panels.Meetings.CreateMeetingPanel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import lombok.Getter;
import lombok.Setter;
import org.example.Models.ExpMapMarker;
import org.example.Models.Friend;
import org.example.Models.Meeting;
import org.example.Models.OSMMap;
import org.example.Panels.Meetings.CreateMeetingSelectFriendsScrollPane.CreateMeetingSelectFriendsScrollPaneView;
import org.example.Panels.Meetings.CreateMeetingSelectPlaceScrollPane.CreateMeetingSelectPlaceScrollPaneView;
import org.example.Service.DBConnection;
import org.jdatepicker.impl.JDatePickerImpl;

@Getter
@Setter
public abstract class CreateMeetingPanelTemplate extends JPanel {
    protected CreateMeetingPanelController controller;
    protected OSMMap map;
    protected List<Friend> friends;
    protected List<Meeting> meetings;
    protected JButton closeButton;
    protected JButton createButton;
    protected JDatePickerImpl datePicker;
    protected String[] hourList = {
        "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17",
        "18", "19", "20", "21", "22", "23"
    };
    protected String[] minutesList = {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    protected JComboBox<String> hourComboBox;
    protected JComboBox<String> minutesComboBox;
    protected CreateMeetingSelectFriendsScrollPaneView createMeetingSelectFriendsScrollPaneView;
    protected CreateMeetingSelectPlaceScrollPaneView createMeetingSelectPlaceScrollPaneView;
    protected List<Friend> selectedFriends = new ArrayList<>();
    protected ExpMapMarker selectedPlace = null;
}
