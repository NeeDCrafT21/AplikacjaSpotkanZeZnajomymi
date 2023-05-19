package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButtonPanel extends JPanel implements ActionListener {
    MenuPanel menuPanel;
    private JButton openSavedMarkersButton;
    private JButton createMeetingButton;
    private JButton showMeetingsButton;
    public MenuButtonPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;

        openSavedMarkersButton = new JButton("Saved markers");
        openSavedMarkersButton.setMaximumSize(new Dimension(260, 50));
        openSavedMarkersButton.setFocusable(false);
        openSavedMarkersButton.addActionListener(this);

        createMeetingButton = new JButton("Create meeting");
        createMeetingButton.setMaximumSize(new Dimension(260, 50));
        createMeetingButton.setFocusable(false);
        createMeetingButton.addActionListener(this);

        showMeetingsButton = new JButton("My meetings");
        showMeetingsButton.setMaximumSize(new Dimension(260, 50));
        showMeetingsButton.setFocusable(false);
        showMeetingsButton.addActionListener(this);

        this.setBounds(20, 250,260, 200);
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(openSavedMarkersButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(createMeetingButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(showMeetingsButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == openSavedMarkersButton) {
            this.setVisible(false);
            menuPanel.backButton.setVisible(true);
            menuPanel.savedMarkersPanel.UpdateShowCreatedMarkers();
            //menuPanel.savedMarkersScrollPane.setViewportView(menuPanel.savedMarkersPanel);
            menuPanel.savedMarkersScrollPane.setVisible(true);
            System.out.println("Saved markers");
        }
    }
}
