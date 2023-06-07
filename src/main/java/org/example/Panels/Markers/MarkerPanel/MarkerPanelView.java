package org.example.Panels.Markers.MarkerPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.imageio.ImageIO;
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

        locationPictureLabel = new JLabel();
        locationPictureLabel.setBounds(20, 90, 350, 155);

        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setText("Description");
        descriptionLabel.setBounds(20, 250, 320, 30);
        descriptionLabel.setFont(new Font(null, Font.BOLD, 17));

        descriptionTextArea = new JTextArea(null, 5, 5);
        descriptionTextArea.setFont(new Font(null, Font.PLAIN, 15));
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setEditable(false);

        JScrollPane descriptionPane = new JScrollPane(descriptionTextArea);
        descriptionPane.setBounds(20, 285, 320, 150);

        JLabel addressLabel = new JLabel();
        addressLabel.setText("Address");
        addressLabel.setBounds(20, 440, 320, 30);
        addressLabel.setFont(new Font(null, Font.BOLD, 17));

        addressTextArea = new JTextArea(null, 5, 5);
        addressTextArea.setBounds(20, 475, 320, 100);
        addressTextArea.setFont(new Font(null, Font.PLAIN, 15));
        addressTextArea.setLineWrap(true);
        addressTextArea.setEditable(false);
        addressTextArea.setBorder(null);

        lonLabel = new JLabel();
        lonLabel.setText("Lon.:");
        lonLabel.setBounds(20, 615, 170, 30);
        lonLabel.setFont(new Font(null, Font.PLAIN, 15));

        latLabel = new JLabel();
        latLabel.setText("Lat.:");
        latLabel.setBounds(190, 615, 170, 30);
        latLabel.setFont(new Font(null, Font.PLAIN, 15));

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setBounds(10, 10, 400, 655);
        this.setLayout(null);

        this.add(closeMenuButton);
        this.add(nameLabel);
        this.add(locationPictureLabel);
        this.add(descriptionLabel);
        this.add(descriptionPane);
        this.add(addressLabel);
        this.add(addressTextArea);
        this.add(lonLabel);
        this.add(latLabel);

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
