package org.example.MainFrame;

import java.awt.event.ActionEvent;

public class MainFrameController {
    MainFrameView view;

    public MainFrameController(MainFrameView view) {
        this.view = view;
    }

    public void buttonClicked(ActionEvent e) {
        if (e.getSource() == view.getMenuButton()) {
            view.getMenuPanelView().getController().openPanel();

            System.out.println("menu");
        } else if (e.getSource() == view.getFriendsButton()) {
            view.getFriendsPanelView().setVisible(true);
            view.getFriendsPanelView()
                    .getAddedFriendsScrollPaneView()
                    .getController()
                    .updateShowAddedFriends();

            System.out.println("friends");
        } else if (e.getSource()
                == view.getMenuPanelView().getSavedMarkersScrollPaneView().getClickedButton()) {
            System.out.println("MainFrame: "
                    + view.getMenuPanelView()
                            .getSavedMarkersScrollPaneView()
                            .getClickedButton()
                            .getText());
        }
    }
}
