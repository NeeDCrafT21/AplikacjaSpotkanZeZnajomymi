package org.example.Panels.Menu.AllMeetingsPanel;

import lombok.AllArgsConstructor;
import org.example.Models.Controllers;
import org.example.Models.Meeting;
import org.example.Models.Views;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collections;

public class AllMeetingsPanelController {
    AllMeetingsPanelView view;

    public AllMeetingsPanelController(AllMeetingsPanelView view) {
        this.view = view;
        Controllers.allMeetingsPanelController = this;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.sortByEarliestButton) {
            Collections.sort(Views.mainFrameView.getMeetings(), (Meeting m1, Meeting m2) -> m1.getMeetingDate().compareTo(m2.getMeetingDate()));
            Controllers.allMeetingsScrollPaneController.UpdateShowAllMeetings();
            Views.mainFrameView.repaint();
            Views.mainFrameView.revalidate();
        } else if (e.getSource() == view.sortByLatestButton) {
            Collections.sort(Views.mainFrameView.getMeetings(), (Meeting m1, Meeting m2) -> m2.getMeetingDate().compareTo(m1.getMeetingDate()));
            Controllers.allMeetingsScrollPaneController.UpdateShowAllMeetings();
            Views.mainFrameView.repaint();
            Views.mainFrameView.revalidate();
        }
    }
}
