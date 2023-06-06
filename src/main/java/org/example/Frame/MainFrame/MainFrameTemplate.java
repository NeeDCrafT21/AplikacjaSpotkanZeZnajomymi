package org.example.Frame.MainFrame;

import javax.swing.*;
import lombok.Getter;
import org.example.Models.Friend;
import org.example.Models.Meeting;
import org.example.Models.OSMMap;
import org.example.Panels.Friends.AddFriendPanel.AddFriendPanelView;
import org.example.Panels.Friends.FriendPanel.FriendPanelView;
import org.example.Panels.Friends.FriendsPanel.FriendsPanelView;
import org.example.Panels.MapPanel.MapPanelView;
import org.example.Panels.Markers.CreateMarkerPanel.CreateMarkerPanelView;
import org.example.Panels.Markers.MarkerPanel.MarkerPanelView;
import org.example.Panels.Meetings.CreateMeetingPanel.CreateMeetingPanelView;
import org.example.Panels.Menu.MenuPanel.MenuPanelView;
import org.example.Panels.SearchBar.LocationSearchBarPanel.LocationSearchBarPanelView;
import org.example.Service.DBConnection;

import java.util.List;

@Getter
public abstract class MainFrameTemplate extends JFrame {
    protected MainFrameController controller;

    protected JButton menuButton;
    protected JButton friendsButton;
    protected OSMMap map;
    protected MarkerPanelView markerPanelView;
    protected MenuPanelView menuPanelView;
    protected MapPanelView mapPanelView;
    protected FriendPanelView friendPanelView;
    protected AddFriendPanelView addFriendPanelView;
    protected FriendsPanelView friendsPanelView;
    protected CreateMeetingPanelView createMeetingPanelView;
    protected CreateMarkerPanelView createMarkerPanelView;
    protected LocationSearchBarPanelView locationSearchBarPanelView;
    protected List<Friend> friends;
    protected List<Meeting> meetings;
}
