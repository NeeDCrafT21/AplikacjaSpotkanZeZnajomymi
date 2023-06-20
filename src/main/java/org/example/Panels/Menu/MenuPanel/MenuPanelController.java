package org.example.Panels.Menu.MenuPanel;

import java.awt.event.ActionEvent;
import org.example.Models.Controllers;
import org.example.Panels.Menu.SavedMarkersScrollPane.SavedMarkersScrollPaneView;

public class MenuPanelController {

    MenuPanelView view;

    public MenuPanelController(MenuPanelView view) {
        this.view = view;
        Controllers.menuPanelController = this;
    }

    public void openPanel() {
        view.setVisible(true);
        view.savedMarkersScrollPaneView.setVisible(false);
        view.allMeetingsPanelView.setVisible(false);
        view.menuButtonPanelView.setVisible(true);
    }

    public void closePanel() {
        view.setVisible(false);
    }

    public SavedMarkersScrollPaneView getSavedMarkersScrollPane() {
        return view.savedMarkersScrollPaneView;
    }

    public void buttonClicked(ActionEvent e) {
        if (e.getSource() == view.closeButton) {
            closePanel();
        } else if (e.getSource() == view.backButton) {
            if (view.savedMarkersScrollPaneView.isVisible()) {
                view.backButton.setVisible(false);
                view.savedMarkersScrollPaneView.setVisible(false);
                view.menuButtonPanelView.setVisible(true);
            } else if (view.allMeetingsPanelView.isVisible()) {
                view.backButton.setVisible(false);
                view.allMeetingsPanelView.setVisible(false);
                view.menuButtonPanelView.setVisible(true);
            }
        }
    }
}
