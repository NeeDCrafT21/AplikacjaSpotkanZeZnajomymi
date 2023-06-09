package org.example.Panels.Menu.AllMeetingsScrollPane;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import org.example.Models.Meeting;
import org.example.Models.Views;

public class AllMeetingsScrollPaneView extends AllMeetingsScrollPaneTemplate {
    public AllMeetingsScrollPaneView() {
        this.meetings = Views.mainFrameView.getMeetings();
        controller = new AllMeetingsScrollPaneController(this);

        meetingsPanel = new JPanel();
        meetingsPanel.setLayout(new BoxLayout(meetingsPanel, BoxLayout.Y_AXIS));
        meetingsPanel.setBackground(Color.WHITE);

        this.setBounds(0, 50, 280, 555);
        this.setBorder(null);
        this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        //this.setVisible(false);
        this.setViewportView(meetingsPanel);

        showAllMeetings();
    }
}
