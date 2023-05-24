package org.example.CreateMeetingPanel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import lombok.Getter;
import lombok.Setter;
import org.example.CreateMeetingSelectFriendsScrollPane.CreateMeetingSelectFriendsScrollPaneView;
import org.example.CreateMeetingSelectPlaceScrollPane.CreateMeetingSelectPlaceScrollPaneView;
import org.example.Model.ExpMapMarker;
import org.example.Model.Friend;
import org.example.Model.Meeting;
import org.example.Model.OSMMap;
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
