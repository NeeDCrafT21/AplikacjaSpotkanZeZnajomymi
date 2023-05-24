package org.example.AllMeetingsScrollPane;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AllMeetingsScrollPaneController {
    AllMeetingsScrollPaneView view;

    public void UpdateShowAllMeetings() {
        view.meetingsPanel.removeAll();
        view.showAllMeetings();
    }
}
