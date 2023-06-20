package org.example.Panels.Meetings.CreateMeetingSelectFriendsScrollPane;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import org.example.Models.Views;
import org.example.Panels.Meetings.CreateMeetingPanel.CreateMeetingPanelView;

public class CreateMeetingSelectFriendsScrollPaneView extends CreateMeetingSelectFriendsScrollPaneTemplate {
    public CreateMeetingSelectFriendsScrollPaneView(CreateMeetingPanelView createMeetingPanelView) {
        this.friends = Views.mainFrameView.getFriends();
        this.createMeetingPanelView = createMeetingPanelView;
        controller = new CreateMeetingSelectFriendsScrollPaneController(this);

        selectFriendsPanel = new JPanel();
        selectFriendsPanel.setLayout(new BoxLayout(selectFriendsPanel, BoxLayout.Y_AXIS));
        selectFriendsPanel.setBackground(Color.WHITE);

        this.setBounds(10, 50, 200, 595);
        this.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Friends"));
        this.setBackground(Color.WHITE);
        this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        this.setVisible(true);
        this.setViewportView(selectFriendsPanel);

        showAddedFriends();
    }
}
