package org.example.Frame.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
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

public class MainFrameView extends MainFrameTemplate implements ActionListener {
    public MainFrameView() throws IOException {
        controller = new MainFrameController(this);
        map = new OSMMap();

        List<Friend> friends = new ArrayList<>();
        List<Meeting> meetings = new ArrayList<>();

        // tymczasowe
        friends.add(new Friend("Grzegorz Brzeczyszczykiewicz"));

        createMarkerPanelView = new CreateMarkerPanelView(map);
        createMeetingPanelView = new CreateMeetingPanelView(map, friends, meetings);
        markerPanelView = new MarkerPanelView();
        menuPanelView = new MenuPanelView(map, markerPanelView, createMeetingPanelView, meetings);
        mapPanelView = new MapPanelView(map, markerPanelView, menuPanelView, createMarkerPanelView);
        friendPanelView = new FriendPanelView();
        addFriendPanelView = new AddFriendPanelView(friendPanelView, friends);
        friendsPanelView = new FriendsPanelView(friendPanelView, addFriendPanelView, friends);
        locationSearchBarPanelView = new LocationSearchBarPanelView(mapPanelView, map);

        ImageIcon MFLogoImage = new ImageIcon("munefrakt_logo.png");
        JLabel MFLogo = new JLabel();
        MFLogo.setIcon(MFLogoImage);
        MFLogo.setVerticalAlignment(JLabel.CENTER);
        MFLogo.setHorizontalAlignment(JLabel.CENTER);
        MFLogo.setBounds(1120, 630, 127, 40);

        JLayeredPane layeredMainPane = new JLayeredPane();
        layeredMainPane.setBounds(0, 0, 1280, 720);

        ImageIcon menuIcon = new ImageIcon("menu_icon.png");
        ImageIcon friendsIcon = new ImageIcon("friends_icon.png");

        menuButton = new JButton();
        menuButton.setBounds(20, 20, 50, 50);
        menuButton.setIcon(menuIcon);
        // menuButton.setFocusable(false);
        menuButton.addActionListener(this);

        friendsButton = new JButton();
        friendsButton.setBounds(1195, 20, 50, 50);
        friendsButton.setIcon(friendsIcon);
        // friendsButton.setFocusable(false);
        friendsButton.addActionListener(this);

        ImageIcon appIcon = new ImageIcon("grupa_badawcza.png");
        this.setIconImage(appIcon.getImage());

        this.add(layeredMainPane);
        this.setTitle("EDP: Ekstremalnie Debilny Planer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1280, 720);
        this.setResizable(false);

        layeredMainPane.add(mapPanelView);
        layeredMainPane.add(markerPanelView, JLayeredPane.PALETTE_LAYER);
        layeredMainPane.add(menuButton, JLayeredPane.PALETTE_LAYER);
        layeredMainPane.add(friendsButton, JLayeredPane.PALETTE_LAYER);
        layeredMainPane.add(locationSearchBarPanelView, JLayeredPane.PALETTE_LAYER);
        layeredMainPane.add(MFLogo, JLayeredPane.PALETTE_LAYER);
        layeredMainPane.add(menuPanelView, JLayeredPane.POPUP_LAYER);
        layeredMainPane.add(friendPanelView, JLayeredPane.POPUP_LAYER);
        layeredMainPane.add(friendsPanelView, JLayeredPane.POPUP_LAYER);
        layeredMainPane.add(addFriendPanelView, JLayeredPane.POPUP_LAYER);
        layeredMainPane.add(createMeetingPanelView, JLayeredPane.POPUP_LAYER);
        layeredMainPane.add(createMarkerPanelView, JLayeredPane.POPUP_LAYER);

        this.setVisible(true);
        this.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.buttonClicked(e);
    }
}
