package org.example.AddFriendPanel;

import java.util.List;
import javax.swing.*;
import lombok.Getter;
import org.example.FriendPanel.FriendPanelView;
import org.example.Model.Friend;

@Getter
public abstract class AddFriendPanelTemplate extends JPanel {
    protected AddFriendPanelController controller;
    protected JButton closeButton;
    protected JButton addFriendButton;
    protected JTextField nameTextField;
    protected JTextArea descriptionTextArea;
    protected FriendPanelView friendPanelView;
    protected List<Friend> friends;
}
