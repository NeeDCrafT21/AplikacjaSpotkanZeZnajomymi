package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JButton menuButton;
    JButton friendsButton;

    OSMMap map = new OSMMap();
    MarkerPanel markerPanel;
    MenuPanel menuPanel;
    MapPanel mapPanel;
    AddedFriendPanel addedFriendPanel;
    AddFriendPanel addFriendPanel;
    FriendsPanel friendsPanel;

    MainFrame() throws IOException {
        List<AddedFriend> addedFriends = new ArrayList<AddedFriend>();
        addedFriends.add(new AddedFriend("Piotr Czaaaarnecki"));

        markerPanel = new MarkerPanel();
        menuPanel = new MenuPanel(map, markerPanel);
        mapPanel = new MapPanel(map, markerPanel, menuPanel);
        addedFriendPanel = new AddedFriendPanel();
        addFriendPanel = new AddFriendPanel(addedFriendPanel, addedFriends);
        friendsPanel = new FriendsPanel(addedFriendPanel, addFriendPanel, addedFriends);

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
        menuButton.addActionListener(this);

        friendsButton = new JButton();
        friendsButton.setBounds(1195, 20,50, 50);
        friendsButton.setIcon(friendsIcon);
        friendsButton.setFocusable(false);
        friendsButton.addActionListener(this);

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
        layeredMainPane.add(addedFriendPanel, JLayeredPane.POPUP_LAYER);
        layeredMainPane.add(friendsPanel, JLayeredPane.POPUP_LAYER);
        layeredMainPane.add(addFriendPanel, JLayeredPane.POPUP_LAYER);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuButton) {
            menuPanel.openPanel();

            System.out.println("menu");
        }
        else if(e.getSource() == friendsButton) {
            friendsPanel.setVisible(true);
            friendsPanel.addedFriendsScrollPane.updateShowAddedFriends();

            System.out.println("friends");
        }
        else if(e.getSource() == menuPanel.savedMarkersPanel.clickedButton) {
            System.out.println("MainFrame: " + menuPanel.savedMarkersPanel.clickedButton.getText());
        }
    }
}
