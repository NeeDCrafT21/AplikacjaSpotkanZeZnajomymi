package org.example.Frame.MainFrame;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import lombok.Getter;
import lombok.SneakyThrows;
import org.example.Models.Controllers;
import org.example.Models.OSMMap;
import org.example.Service.DBConnection;
import org.example.Service.LocationsReverseService;
import org.example.Service.LocationsSearchService;

@Getter
public class MainFrameController {
    MainFrameView view;
    DBConnection dbConnection;
    LocationsReverseService locationsReverseService;
    LocationsSearchService locationsSearchService;

    @SneakyThrows
    public MainFrameController(MainFrameView view) {
        this.view = view;

        locationsReverseService = new LocationsReverseService(new ObjectMapper());
        locationsSearchService = new LocationsSearchService(new ObjectMapper());
        dbConnection = new DBConnection();
        Controllers.mainFrameController = this;

        view.map = new OSMMap();
        dbConnection.getMarkers(view.map);
        view.friends = dbConnection.getFriends();
        view.meetings = dbConnection.getMeetings();
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
