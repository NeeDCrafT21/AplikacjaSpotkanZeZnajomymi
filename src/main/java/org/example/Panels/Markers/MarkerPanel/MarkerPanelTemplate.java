package org.example.Panels.Markers.MarkerPanel;

import javax.swing.*;
import lombok.Getter;

@Getter
public abstract class MarkerPanelTemplate extends JPanel {
    protected MarkerPanelController controller;
    protected JButton closeMenuButton;
    protected JTextArea descriptionTextArea;
    protected JLabel nameLabel;
    protected ImageIcon locationPicture;
    protected JLabel locationPictureLabel;
    protected JTextArea addressTextArea;
    protected JLabel lonLabel;
    protected JLabel latLabel;
}
