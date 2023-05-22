package org.example.Controller;

import org.example.View.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController implements ActionListener {
    MainFrame view;

    public MainFrameController(MainFrame view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getMenuButton()) {
            view.getMenuPanel().openPanel();

            System.out.println("menu");
        }
        else if(e.getSource() == view.getFriendsButton()) {
            view.getFriendsPanel().setVisible(true);
            view.getFriendsPanel().getAddedFriendsScrollPane().updateShowAddedFriends();

            System.out.println("friends");
        }
        else if(e.getSource() == view.getMenuPanel().getSavedMarkersScrollPane().getClickedButton()) {
            System.out.println("MainFrame: " + view.getMenuPanel().getSavedMarkersScrollPane().getClickedButton().getText());
        }
    }


}
