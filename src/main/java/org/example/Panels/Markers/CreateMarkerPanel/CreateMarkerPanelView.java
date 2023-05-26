package org.example.Panels.Markers.CreateMarkerPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import org.example.Models.OSMMap;

public class CreateMarkerPanelView extends CreateMarkerPanelTemplate implements ActionListener {

    public CreateMarkerPanelView(OSMMap map) {
        this.map = map;

        controller = new CreateMarkerController(this);

        ImageIcon closeIcon = new ImageIcon("close_icon.png");
        closeButton = new JButton();
        closeButton.setBounds(360, 10, 30, 30);
        closeButton.setIcon(closeIcon);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        addMarkerButton = new JButton("Add");
        addMarkerButton.setBounds(150, 590, 100, 50);
        addMarkerButton.setFocusable(false);
        addMarkerButton.addActionListener(this);

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Create new marker");
        titleLabel.setBounds(20, 20, 320, 50);
        titleLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
        titleLabel.setFont(new Font(null, Font.BOLD, 25));
        // titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name");
        nameLabel.setBounds(20, 100, 320, 30);
        nameLabel.setFont(new Font(null, Font.PLAIN, 15));

        nameTextField = new JTextField();
        nameTextField.setBounds(20, 130, 320, 30);
        nameTextField.setFont(new Font(null, Font.PLAIN, 15));

        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setText("Description");
        descriptionLabel.setBounds(20, 180, 320, 30);
        descriptionLabel.setFont(new Font(null, Font.PLAIN, 15));

        descriptionTextArea = new JTextArea(5, 5);
        descriptionTextArea.setFont(new Font(null, Font.PLAIN, 15));
        descriptionTextArea.setLineWrap(true);

        JScrollPane descriptionPane = new JScrollPane(descriptionTextArea);
        descriptionPane.setBounds(20, 210, 320, 150);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(10, 10, 400, 655);
        this.setLayout(null);

        this.add(closeButton);
        this.add(addMarkerButton);
        this.add(titleLabel);
        this.add(nameLabel);
        this.add(nameTextField);
        this.add(descriptionLabel);
        this.add(descriptionPane);

        this.setVisible(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.buttonClicked(e);
    }
}
