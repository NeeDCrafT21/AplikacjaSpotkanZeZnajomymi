package org.example.Panels.Menu.MenuPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
import org.example.Models.Meeting;
import org.example.Models.OSMMap;
import org.example.Panels.Markers.MarkerPanel.MarkerPanelView;
import org.example.Panels.Meetings.CreateMeetingPanel.CreateMeetingPanelView;
import org.example.Panels.Menu.AllMeetingsScrollPane.AllMeetingsScrollPaneView;
import org.example.Panels.Menu.MenuButtonPanel.MenuButtonPanelView;
import org.example.Panels.Menu.SavedMarkersScrollPane.SavedMarkersScrollPaneView;

public class MenuPanelView extends MenuPanelTemplate implements ActionListener {

    public MenuPanelView(
            OSMMap map,
            MarkerPanelView markerPanelView,
            CreateMeetingPanelView createMeetingPanelView,
            List<Meeting> meetings) {
        this.markerPanelView = markerPanelView;
        this.createMeetingPanelView = createMeetingPanelView;
        this.meetings = meetings;

        controller = new MenuPanelController(this);

        savedMarkersScrollPaneView = new SavedMarkersScrollPaneView(map, markerPanelView, this);

        allMeetingsScrollPaneView = new AllMeetingsScrollPaneView(meetings);

        ImageIcon closeIcon = new ImageIcon("close_icon.png");
        closeButton = new JButton();
        closeButton.setBounds(260, 10, 30, 30);
        closeButton.setIcon(closeIcon);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        ImageIcon backIcon = new ImageIcon("back_icon.png");
        backButton = new JButton();
        backButton.setBounds(225, 10, 30, 30);
        backButton.setIcon(backIcon);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setVisible(false);

        menuButtonPanelView = new MenuButtonPanelView(this, createMeetingPanelView);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(10, 10, 300, 655);
        this.setLayout(null);

        this.add(closeButton);
        this.add(backButton);
        this.add(menuButtonPanelView);
        this.add(savedMarkersScrollPaneView);
        this.add(allMeetingsScrollPaneView);

        this.setVisible(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.buttonClicked(e);
    }
}
