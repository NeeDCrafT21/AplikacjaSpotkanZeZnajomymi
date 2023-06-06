package org.example.Frame.MainFrame;

import lombok.Getter;
import org.example.Models.Controllers;
import org.example.Models.OSMMap;
import org.example.Service.DBConnection;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

@Getter
public class MainFrameController {
    MainFrameView view;
    DBConnection dbConnection;

    public MainFrameController(MainFrameView view) {
        this.view = view;

        view.map = new OSMMap();
        dbConnection = new DBConnection();
        dbConnection.getMarkers(view.map);
        view.friends = dbConnection.getFriends();
        view.meetings = dbConnection.getMeetings();

        Controllers.mainFrameController = this;
    }

    public void exitingApp(WindowEvent e) {
        dbConnection.closeConnection();
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
