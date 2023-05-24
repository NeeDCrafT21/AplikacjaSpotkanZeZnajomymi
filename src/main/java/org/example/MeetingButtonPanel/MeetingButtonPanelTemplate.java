package org.example.MeetingButtonPanel;

import javax.swing.*;
import lombok.Getter;
import org.example.Model.Meeting;

@Getter
public abstract class MeetingButtonPanelTemplate extends JPanel {
    protected MeetingButtonPanelController controller;
    protected Meeting meeting;
}
