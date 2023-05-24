package org.example.MenuButtonPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.example.CreateMeetingPanel.CreateMeetingPanelView;
import org.example.MenuPanel.MenuPanelView;

public class MenuButtonPanelView extends MenuButtonPanelTemplate implements ActionListener {

    public MenuButtonPanelView(MenuPanelView menuPanelView, CreateMeetingPanelView createMeetingPanelView) {
        this.menuPanelView = menuPanelView;
        this.createMeetingPanelView = createMeetingPanelView;

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
            menuPanelView.getAllMeetingsScrollPaneView().getController().UpdateShowAllMeetings();
            menuPanelView.getAllMeetingsScrollPaneView().setVisible(true);
        }
    }
}
