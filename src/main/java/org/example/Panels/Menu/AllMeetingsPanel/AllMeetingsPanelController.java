package org.example.Panels.Menu.AllMeetingsPanel;

import java.awt.event.ActionEvent;
import java.util.Comparator;

import org.example.Models.Controllers;
import org.example.Models.Meeting;
import org.example.Models.Views;

public class AllMeetingsPanelController {
    AllMeetingsPanelView view;

    public AllMeetingsPanelController(AllMeetingsPanelView view) {
        this.view = view;
        Controllers.allMeetingsPanelController = this;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.sortByEarliestButton) {
            Views.mainFrameView.getMeetings().sort(Comparator.comparing(Meeting::getMeetingDate));
            Controllers.allMeetingsScrollPaneController.UpdateShowAllMeetings();
            Views.mainFrameView.repaint();
            Views.mainFrameView.revalidate();
        } else if (e.getSource() == view.sortByLatestButton) {
            Views.mainFrameView.getMeetings().sort((Meeting m1, Meeting m2) -> m2.getMeetingDate()
                    .compareTo(m1.getMeetingDate()));
            Controllers.allMeetingsScrollPaneController.UpdateShowAllMeetings();
            Views.mainFrameView.repaint();
            Views.mainFrameView.revalidate();
        }
    }
}
