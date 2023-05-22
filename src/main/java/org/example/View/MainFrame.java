package org.example.View;

import org.example.Controller.MainFrameController;
import org.example.Model.Friend;
import org.example.Model.Meeting;
import org.example.Model.OSMMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    MainFrameController controller;

    private JButton menuButton;

    private JButton friendsButton;
    private OSMMap map = new OSMMap();
    private MarkerPanel markerPanel;
    private MenuPanel menuPanel;
    private MapPanel mapPanel;
    private FriendPanel friendPanel;
    private AddFriendPanel addFriendPanel;
    private FriendsPanel friendsPanel;
    private CreateMeetingPanel createMeetingPanel;

    public MainFrame() throws IOException {
        controller = new MainFrameController(this);
        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Grzegorz Brzeczyszczykiewicz"));

        List<Meeting> meetings = new ArrayList<>();

        createMeetingPanel = new CreateMeetingPanel(map, friends, meetings);
        markerPanel = new MarkerPanel();
        menuPanel = new MenuPanel(map, markerPanel, createMeetingPanel, meetings);
        mapPanel = new MapPanel(map, markerPanel, menuPanel);
        friendPanel = new FriendPanel();
        addFriendPanel = new AddFriendPanel(friendPanel, friends);
        friendsPanel = new FriendsPanel(friendPanel, addFriendPanel, friends);

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
        menuButton.setBounds(20, 20,50, 50);
        menuButton.setIcon(menuIcon);
        menuButton.setFocusable(false);
        menuButton.addActionListener(controller);

        friendsButton = new JButton();
        friendsButton.setBounds(1195, 20,50, 50);
        friendsButton.setIcon(friendsIcon);
        friendsButton.setFocusable(false);
        friendsButton.addActionListener(controller);

        ImageIcon appIcon = new ImageIcon("grupa_badawcza.png");
        this.setIconImage(appIcon.getImage());

        this.add(layeredMainPane);
        this.setTitle("EDP: Ekstremalnie Debilny Planer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1280, 720);
        this.setResizable(false);

        layeredMainPane.add(mapPanel);
        layeredMainPane.add(markerPanel, JLayeredPane.PALETTE_LAYER);
        layeredMainPane.add(menuButton, JLayeredPane.PALETTE_LAYER);
        layeredMainPane.add(friendsButton, JLayeredPane.PALETTE_LAYER);
        layeredMainPane.add(MFLogo, JLayeredPane.PALETTE_LAYER);
        layeredMainPane.add(menuPanel, JLayeredPane.POPUP_LAYER);
        layeredMainPane.add(friendPanel, JLayeredPane.POPUP_LAYER);
        layeredMainPane.add(friendsPanel, JLayeredPane.POPUP_LAYER);
        layeredMainPane.add(addFriendPanel, JLayeredPane.POPUP_LAYER);
        layeredMainPane.add(createMeetingPanel, JLayeredPane.POPUP_LAYER);

        this.setVisible(true);
    }


//    public void actionPerformed(ActionEvent e) {
//        controller.actionPerformed(e);
//    }

    public JButton getMenuButton() {
        return menuButton;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public FriendsPanel getFriendsPanel() {
        return friendsPanel;
    }

    public JButton getFriendsButton() {
        return friendsButton;
    }
}
