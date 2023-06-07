package org.example.Panels.Friends.AddFriendPanel;

import java.util.List;
import javax.swing.*;
import lombok.Getter;
import org.example.Models.Friend;
import org.example.Panels.Friends.FriendPanel.FriendPanelView;
import org.example.Service.DBConnection;

@Getter
public abstract class AddFriendPanelTemplate extends JPanel {
    protected AddFriendPanelController controller;
    protected JButton closeButton;
    protected JButton addFriendButton;
    protected JTextField nameTextField;
    protected JTextField nicknameTextField;
    protected JTextArea descriptionTextArea;
    protected FriendPanelView friendPanelView;
    protected List<Friend> friends;
    protected JLabel errorLabel;
}
