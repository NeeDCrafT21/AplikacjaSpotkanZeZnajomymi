package org.example.MenuButtonPanel;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.example.CreateMeetingPanel.CreateMeetingPanelView;
import org.example.MenuPanel.MenuPanelView;

public abstract class MenuButtonPanelTemplate extends JPanel {
    public MenuPanelView menuPanelView;
    protected CreateMeetingPanelView createMeetingPanelView;
    protected JButton openSavedMarkersButton;
    protected JButton createMeetingButton;
    protected JButton showMeetingsButton;

    public JButton initButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setMaximumSize(new Dimension(260, 50));
        button.setFocusable(false);
        button.addActionListener((ActionListener) this);
        return button;
    }
}
