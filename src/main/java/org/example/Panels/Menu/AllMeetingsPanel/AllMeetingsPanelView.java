package org.example.Panels.Menu.AllMeetingsPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.example.Models.Views;
import org.example.Panels.Menu.AllMeetingsScrollPane.AllMeetingsScrollPaneView;

public class AllMeetingsPanelView extends AllMeetingsPanelTemplate implements ActionListener {
    public AllMeetingsPanelView() {
        controller = new AllMeetingsPanelController(this);
        Views.allMeetingsPanelView = this;

        allMeetingsScrollPaneView = new AllMeetingsScrollPaneView();

        JLabel sortLabel = new JLabel("Sort by:");
        sortLabel.setBounds(10, 15, 150, 30);
        sortLabel.setFont(new Font(null, Font.BOLD, 17));

        sortByLatestButton = new JButton("Latest");
        sortByLatestButton.setBounds(200, 15, 80, 30);
        sortByLatestButton.setFocusable(false);
        sortByLatestButton.addActionListener(this);

        sortByEarliestButton = new JButton("Earliest");
        sortByEarliestButton.setBounds(115, 15, 80, 30);
        sortByEarliestButton.setFocusable(false);
        sortByEarliestButton.addActionListener(this);

        this.setBounds(10, 40, 280, 605);
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setVisible(false);

        this.add(sortLabel);
        this.add(sortByEarliestButton);
        this.add(sortByLatestButton);
        this.add(allMeetingsScrollPaneView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.actionPerformed(e);
    }
}
