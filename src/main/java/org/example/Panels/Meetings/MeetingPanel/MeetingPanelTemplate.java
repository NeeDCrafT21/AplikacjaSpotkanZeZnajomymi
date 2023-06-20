package org.example.Panels.Meetings.MeetingPanel;

import javax.swing.*;
import org.example.Panels.Meetings.MeetingFriendsScrollPane.MeetingFriendsScrollPaneView;

public abstract class MeetingPanelTemplate extends JPanel {
    protected MeetingPanelController controller;
    protected JButton closeMenuButton;
    protected JLabel titleLabel;
    protected JLabel locationDescriptionLabel;
    protected JTextArea locationDescriptionTextArea;
    protected JTextArea locationAddressTextArea;
    protected JLabel meetingDateInfoLabel;
    protected JLabel meetingTimeInfoLabel;
    protected MeetingFriendsScrollPaneView meetingFriendsScrollPaneView;
}
