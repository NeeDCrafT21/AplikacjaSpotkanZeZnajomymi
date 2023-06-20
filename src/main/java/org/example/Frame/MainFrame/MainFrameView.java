package org.example.Frame.MainFrame;

import java.awt.event.*;
import javax.swing.*;
import org.example.Models.Views;
import org.example.Panels.Friends.AddFriendPanel.AddFriendPanelView;
import org.example.Panels.Friends.FriendPanel.FriendPanelView;
import org.example.Panels.Friends.FriendsPanel.FriendsPanelView;
import org.example.Panels.MapPanel.MapPanelView;
import org.example.Panels.Markers.CreateMarkerPanel.CreateMarkerPanelView;
import org.example.Panels.Markers.MarkerPanel.MarkerPanelView;
import org.example.Panels.Meetings.CreateMeetingPanel.CreateMeetingPanelView;
import org.example.Panels.Meetings.MeetingPanel.MeetingPanelView;
import org.example.Panels.Menu.MenuPanel.MenuPanelView;
import org.example.Panels.SearchBar.LocationSearchBarPanel.LocationSearchBarPanelView;

public class MainFrameView extends MainFrameTemplate implements ActionListener {
    public MainFrameView() {
        controller = new MainFrameController(this);
        Views.mainFrameView = this;

        createMarkerPanelView = new CreateMarkerPanelView();
        createMeetingPanelView = new CreateMeetingPanelView();
        markerPanelView = new MarkerPanelView();
        menuPanelView = new MenuPanelView();
        mapPanelView = new MapPanelView();
        friendPanelView = new FriendPanelView();
        addFriendPanelView = new AddFriendPanelView();
        friendsPanelView = new FriendsPanelView();
        locationSearchBarPanelView = new LocationSearchBarPanelView();
        meetingPanelView = new MeetingPanelView();

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
        menuButton.addActionListener(this);

        friendsButton = new JButton();
        friendsButton.setBounds(1195, 20, 50, 50);
        friendsButton.setIcon(friendsIcon);
        friendsButton.addActionListener(this);

        ImageIcon appIcon = new ImageIcon("grupa_badawcza.png");
        this.setIconImage(appIcon.getImage());

        this.add(layeredMainPane);
        this.setTitle("EDP: Ekstremalnie Debilny Planer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1280, 720);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controller.exitingApp(e);
            }
        });

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
        layeredMainPane.add(meetingPanelView, JLayeredPane.POPUP_LAYER);

        this.setVisible(true);
        this.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.buttonClicked(e);
    }
}
