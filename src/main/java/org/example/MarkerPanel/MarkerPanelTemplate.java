package org.example.MarkerPanel;

import javax.swing.*;
import lombok.Getter;

@Getter
public abstract class MarkerPanelTemplate extends JPanel {
    protected MarkerPanelController controller;
    protected JButton closeMenuButton;
    protected JTextArea descriptionTextArea;
    protected JLabel nameLabel;
}
