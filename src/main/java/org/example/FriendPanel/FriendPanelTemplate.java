package org.example.FriendPanel;

import javax.swing.*;
import lombok.Getter;

@Getter
public abstract class FriendPanelTemplate extends JPanel {
    protected FriendPanelController controller;
    protected JButton closeButton;
    protected JLabel titleLabel;
    protected JTextArea descriptionTextArea;
    protected ImageIcon profilePicture;
    protected JLabel profilePictureLabel;
}
