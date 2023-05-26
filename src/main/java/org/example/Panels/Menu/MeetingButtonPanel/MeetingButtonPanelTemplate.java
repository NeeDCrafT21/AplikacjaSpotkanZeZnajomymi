package org.example.Panels.Menu.MeetingButtonPanel;

import javax.swing.*;
import lombok.Getter;
import org.example.Models.Meeting;

@Getter
public abstract class MeetingButtonPanelTemplate extends JPanel {
    protected MeetingButtonPanelController controller;
    protected Meeting meeting;
}
