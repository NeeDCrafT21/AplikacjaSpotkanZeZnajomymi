package org.example.Panels.Menu.MenuButtonPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.example.Models.Controllers;
import org.example.Models.Views;

public class MenuButtonPanelView extends MenuButtonPanelTemplate implements ActionListener {

    public MenuButtonPanelView() {
        this.menuPanelView = Views.menuPanelView;
        this.createMeetingPanelView = Views.createMeetingPanelView;

        openSavedMarkersButton = initButton("Save markers");
        createMeetingButton = initButton("Create meeting");
        showMeetingsButton = initButton("My meetings");

        this.setBounds(20, 250, 260, 200);
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(openSavedMarkersButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(createMeetingButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(showMeetingsButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openSavedMarkersButton) {
            this.setVisible(false);
            menuPanelView.getBackButton().setVisible(true);
            menuPanelView.getSavedMarkersScrollPaneView().getController().UpdateShowCreatedMarkers();
            menuPanelView.getSavedMarkersScrollPaneView().setVisible(true);
            System.out.println("Saved markers");
        } else if (e.getSource() == createMeetingButton) {
            menuPanelView.setVisible(false);
            createMeetingPanelView.getController().clearPanelInfo();
            createMeetingPanelView.setVisible(true);
        } else if (e.getSource() == showMeetingsButton) {
            this.setVisible(false);
            menuPanelView.getBackButton().setVisible(true);
            Controllers.allMeetingsScrollPaneController.UpdateShowAllMeetings();
            Views.allMeetingsPanelView.setVisible(true);
            //            menuPanelView.getAllMeetingsScrollPaneView().getController().UpdateShowAllMeetings();
            //            menuPanelView.getAllMeetingsScrollPaneView().setVisible(true);
        }
    }
}
