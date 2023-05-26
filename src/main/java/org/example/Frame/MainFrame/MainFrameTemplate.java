package org.example.Frame.MainFrame;

import javax.swing.*;
import lombok.Getter;
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
import org.example.Service.LocationsReverseService;
import org.example.Service.LocationsSearchService;

@Getter
public abstract class MainFrameTemplate extends JFrame {
    MainFrameController controller;

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
}
