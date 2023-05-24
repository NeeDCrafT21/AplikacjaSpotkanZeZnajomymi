package org.example.MainFrame;

import javax.swing.*;
import lombok.Getter;
import org.example.AddFriendPanel.AddFriendPanelView;
import org.example.CreateMarkerPanel.CreateMarkerPanelView;
import org.example.CreateMeetingPanel.CreateMeetingPanelView;
import org.example.FriendPanel.FriendPanelView;
import org.example.FriendsPanel.FriendsPanelView;
import org.example.LocationSearchBarPanel.LocationSearchBarPanelView;
import org.example.MapPanel.MapPanelView;
import org.example.MarkerPanel.MarkerPanelView;
import org.example.MenuPanel.MenuPanelView;
import org.example.Model.OSMMap;

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
