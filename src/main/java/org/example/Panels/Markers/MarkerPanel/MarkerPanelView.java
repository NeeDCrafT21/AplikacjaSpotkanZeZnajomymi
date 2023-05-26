package org.example.Panels.Markers.MarkerPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class MarkerPanelView extends MarkerPanelTemplate implements ActionListener {
    public MarkerPanelView() {
        controller = new MarkerPanelController(this);

        ImageIcon closeIcon = new ImageIcon("close_icon.png");

        closeMenuButton = new JButton();
        closeMenuButton.setBounds(360, 10, 30, 30);
        closeMenuButton.setIcon(closeIcon);
        closeMenuButton.setFocusable(false);
        closeMenuButton.addActionListener(this);

        nameLabel = new JLabel();
        nameLabel.setBounds(20, 20, 320, 50);
        nameLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
        nameLabel.setFont(new Font(null, Font.BOLD, 25));
        nameLabel.setHorizontalTextPosition(JLabel.CENTER);

        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setText("Description");
        descriptionLabel.setBounds(20, 100, 320, 30);
        descriptionLabel.setFont(new Font(null, Font.PLAIN, 15));

        descriptionTextArea = new JTextArea(null, 5, 5);
        descriptionTextArea.setFont(new Font(null, Font.PLAIN, 15));
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setEditable(false);

        JScrollPane descriptionPane = new JScrollPane(descriptionTextArea);
        descriptionPane.setBounds(20, 130, 320, 150);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(10, 10, 400, 655);
        this.setLayout(null);

        this.add(closeMenuButton);
        this.add(nameLabel);
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
