package org.example.Panels.Meetings.CreateMeetingPanel;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import lombok.AllArgsConstructor;
import org.example.Models.Controllers;
import org.example.Models.Meeting;
import org.example.Models.MeetingExpMapMarker;

@AllArgsConstructor
public class CreateMeetingPanelController {
    CreateMeetingPanelView view;

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
                view.errorLabel.setText("Select friends and/or place");
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
                Meeting newMeeting =
                        new Meeting(view.selectedFriends, meetingMarker, newMeetingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), newMeetingTime);
                view.meetings.add(newMeeting);
                Controllers.mainFrameController.getDbConnection().addMeeting(newMeeting);
                newMeeting.printMeetingInfo();
                clearPanelInfo();
                view.setVisible(false);
            }
        }
    }
}
