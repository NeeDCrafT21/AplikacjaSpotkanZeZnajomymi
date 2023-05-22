package org.example.View;

import org.example.Model.Meeting;
import org.example.Model.OSMMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MenuPanel extends JPanel implements ActionListener {
    MarkerPanel markerPanel;
    CreateMeetingPanel createMeetingPanel;
    List<Meeting> meetings;

    SavedMarkersScrollPane savedMarkersScrollPane;
    AllMeetingsScrollPane allMeetingsScrollPane;
    MenuButtonPanel menuButtonPanel;

    private JButton closeButton;
    public JButton backButton;

    public MenuPanel(OSMMap map, MarkerPanel markerPanel, CreateMeetingPanel createMeetingPanel, List<Meeting> meetings) {
        this.markerPanel = markerPanel;
        this.createMeetingPanel = createMeetingPanel;
        this.meetings = meetings;

        savedMarkersScrollPane = new SavedMarkersScrollPane(map, markerPanel, this);

        allMeetingsScrollPane = new AllMeetingsScrollPane(meetings);

        ImageIcon closeIcon = new ImageIcon("close_icon.png");
        closeButton = new JButton();
        closeButton.setBounds(260, 10,30, 30);
        closeButton.setIcon(closeIcon);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        ImageIcon backIcon = new ImageIcon("back_icon.png");
        backButton = new JButton();
        backButton.setBounds(225, 10,30, 30);
        backButton.setIcon(backIcon);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setVisible(false);

        menuButtonPanel = new MenuButtonPanel(this, createMeetingPanel);

//        this.add(layeredMenuPane);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(10, 10, 300, 655);
        this.setLayout(null);

//        layeredMenuPane.add(closeMenuButton, JLayeredPane.PALETTE_LAYER);
//        layeredMenuPane.add(backButton, JLayeredPane.PALETTE_LAYER);
//        layeredMenuPane.add(menuButtonPanel, JLayeredPane.PALETTE_LAYER);
//        layeredMenuPane.add(savedMarkersScrollPane, JLayeredPane.POPUP_LAYER);

        this.add(closeButton);
        this.add(backButton);
        this.add(menuButtonPanel);
        this.add(savedMarkersScrollPane);
        this.add(allMeetingsScrollPane);

        this.setVisible(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
            }
        });

    }

    public void openPanel() {
        this.setVisible(true);
        savedMarkersScrollPane.setVisible(false);
        allMeetingsScrollPane.setVisible(false);
        menuButtonPanel.setVisible(true);
    }

    public void closePanel() {
        this.setVisible(false);
    }

    public SavedMarkersScrollPane getSavedMarkersScrollPane() {
        return savedMarkersScrollPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeButton) {
            closePanel();
        }
        else if(e.getSource() == backButton) {
            if(savedMarkersScrollPane.isVisible()) {
                backButton.setVisible(false);
                savedMarkersScrollPane.setVisible(false);
                menuButtonPanel.setVisible(true);
            }
            else if(allMeetingsScrollPane.isVisible()) {
                backButton.setVisible(false);
                allMeetingsScrollPane.setVisible(false);
                menuButtonPanel.setVisible(true);
            }

        }
    }
}
