package org.example.Panels.Menu.AllMeetingsScrollPane;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AllMeetingsScrollPaneController {
    AllMeetingsScrollPaneView view;

    public void UpdateShowAllMeetings() {
        view.meetingsPanel.removeAll();
        view.showAllMeetings();
    }
}
