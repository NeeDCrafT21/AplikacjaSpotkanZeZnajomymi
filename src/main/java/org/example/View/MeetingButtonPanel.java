package org.example.View;

import org.example.Model.Meeting;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

public class MeetingButtonPanel extends JPanel implements MouseListener {
    Meeting meeting;

    public MeetingButtonPanel(Meeting meeting) {
        this.meeting = meeting;

        JLabel nameLabel = new JLabel("Meeting in: " + meeting.getMeetingLocation().getName());
        nameLabel.setBounds(10, 10, 260, 30);
        nameLabel.setFont(new Font(null, Font.BOLD, 20));

        ImageIcon dateIcon = new ImageIcon("date_icon.png");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        JLabel dateLabel = new JLabel(sdf.format(meeting.getMeetingDate()));
        dateLabel.setBounds(10, 50, 150, 18);
        dateLabel.setIcon(dateIcon);
        dateLabel.setFont(new Font(null, Font.PLAIN, 12));

        ImageIcon timeIcon = new ImageIcon("time_icon.png");
        JLabel timeLabel = new JLabel(meeting.getMeetingTime().toString());
        timeLabel.setBounds(10, 70, 150, 18);
        timeLabel.setIcon(timeIcon);
        timeLabel.setFont(new Font(null, Font.PLAIN, 12));

        this.setPreferredSize(new Dimension(280, 100));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.setLayout(null);

        this.add(nameLabel);
        this.add(dateLabel);
        this.add(timeLabel);

        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}
