package org.example.Panels.Meetings.CreateMeetingPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.Models.*;

import javax.swing.*;

public class CreateMeetingPanelController {
    CreateMeetingPanelView view;

    public CreateMeetingPanelController(CreateMeetingPanelView view) {
        this.view = view;
        Controllers.createMeetingPanelController = this;
    }

    public void clearPanelInfo() {
        view.createMeetingSelectFriendsScrollPaneView.getController().updateShowAddedFriends();
        view.createMeetingSelectPlaceScrollPaneView.getController().updateShowCreatedMarkers();
        view.datePicker.getModel().setValue(null);
        view.hourComboBox.setSelectedIndex(0);
        view.minutesComboBox.setSelectedIndex(0);
        view.selectedFriends.clear();
        view.selectedPlace = null;
        view.errorLabel.setVisible(false);
    }

    public void updatePlaceInfo(ExpMapMarker marker) {
        view.placeNameLabel.setText(marker.getName());
        ImageIcon placePicture =
                new ImageIcon(marker.getLocationPicture().getScaledInstance(255, 140, Image.SCALE_DEFAULT));
        view.placePictureLabel.setIcon(placePicture);
        view.placeAddressTextArea.setText(marker.getLocation().getDisplayName());
    }

    public void buttonClicked(ActionEvent e) {
        if (e.getSource() == view.closeButton) {
            view.setVisible(false);
        } else if (e.getSource() == view.createButton) {
            Date meetingDate = (Date) view.datePicker.getModel().getValue();
            Date todaysDate = new Date();
            todaysDate.setHours(0);
            todaysDate.setMinutes(0);
            if (view.selectedFriends.isEmpty() || view.selectedPlace == null) {
                System.out.println("Niepoprawne dane");
                view.errorLabel.setText("Select friends and/or meeting place");
                view.errorLabel.setVisible(true);
            } else if (meetingDate == null || meetingDate.before(todaysDate)) {
                System.out.println("Wybierz date pozniejsza niz dzisiejsza");
                view.errorLabel.setText("Choose a date later than today");
                view.errorLabel.setVisible(true);
                view.datePicker.getModel().setValue(null);
            } else {
                Date newMeetingDate = (Date) view.datePicker.getModel().getValue();
                LocalTime newMeetingTime = LocalTime.parse(
                        view.hourComboBox.getSelectedItem() + ":" + view.minutesComboBox.getSelectedItem());
                MeetingExpMapMarker meetingMarker = new MeetingExpMapMarker(view.selectedPlace.getName(), view.selectedPlace.getDescription(), view.selectedPlace.getLocation());
                List<Friend> friends = new ArrayList<>(view.selectedFriends);
                Meeting newMeeting =
                        new Meeting(friends, meetingMarker, newMeetingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), newMeetingTime);
                Views.mainFrameView.getMeetings().add(newMeeting);
                Controllers.mainFrameController.getDbConnection().addMeeting(newMeeting);
                view.setVisible(false);
            }
        }
    }
}
