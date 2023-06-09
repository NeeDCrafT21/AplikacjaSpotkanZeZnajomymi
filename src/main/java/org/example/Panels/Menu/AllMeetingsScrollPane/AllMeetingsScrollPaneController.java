package org.example.Panels.Menu.AllMeetingsScrollPane;

import lombok.AllArgsConstructor;
import org.example.Models.Controllers;

public class AllMeetingsScrollPaneController {
    AllMeetingsScrollPaneView view;

    public AllMeetingsScrollPaneController(AllMeetingsScrollPaneView view) {
        this.view = view;
        Controllers.allMeetingsScrollPaneController = this;
    }

    public void UpdateShowAllMeetings() {
        view.meetingsPanel.removeAll();
        view.showAllMeetings();
    }
}
