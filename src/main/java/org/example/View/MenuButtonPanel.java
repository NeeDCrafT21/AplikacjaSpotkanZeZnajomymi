package org.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButtonPanel extends JPanel implements ActionListener {
    private final MenuPanel menuPanel;
    private final CreateMeetingPanel createMeetingPanel;
    private final JButton openSavedMarkersButton;
    private final JButton createMeetingButton;
    private final JButton showMeetingsButton;

    public MenuButtonPanel(MenuPanel menuPanel, CreateMeetingPanel createMeetingPanel) {
        this.menuPanel = menuPanel;
        this.createMeetingPanel = createMeetingPanel;

        openSavedMarkersButton = initButton("Save markers");
        createMeetingButton = initButton("Create meeting");
        showMeetingsButton = initButton("My meetings");

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

    public JButton initButton(String buttonText) {
        JButton jButton = new JButton(buttonText);
        jButton.setMaximumSize(new Dimension(260, 50));
        jButton.setFocusable(false);
        jButton.addActionListener(this);
        return jButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == openSavedMarkersButton) {
            this.setVisible(false);
            menuPanel.backButton.setVisible(true);
            menuPanel.savedMarkersScrollPane.UpdateShowCreatedMarkers();
            menuPanel.savedMarkersScrollPane.setVisible(true);
            System.out.println("Saved markers");
        }
        else if(e.getSource() == createMeetingButton) {
            menuPanel.setVisible(false);
            createMeetingPanel.clearPanelInfo();
            createMeetingPanel.setVisible(true);
        }
        else if(e.getSource() == showMeetingsButton) {
            this.setVisible(false);
            menuPanel.backButton.setVisible(true);
            menuPanel.allMeetingsScrollPane.UpdateShowAllMeetings();
            menuPanel.allMeetingsScrollPane.setVisible(true);
        }
    }
}
