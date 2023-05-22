package org.example.Model;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Meeting {
    private List<Friend> attendingFriends;
    private ExpMapMarker meetingLocation;
    private Date meetingDate;
    private LocalTime meetingTime;
    private Boolean isFinished = false;

    public Meeting(List<Friend> attendingFriends, ExpMapMarker meetingLocation, Date meetingDate, LocalTime meetingTime) {
        this.attendingFriends = attendingFriends;
        this.meetingLocation = meetingLocation;
        this.meetingDate = meetingDate;
        this.meetingTime = meetingTime;
    }

    public void printMeetingInfo() {
        System.out.println(attendingFriends);
        System.out.println(meetingLocation);
        System.out.println(meetingDate);
        System.out.println(meetingTime);

    }

    public ExpMapMarker getMeetingLocation() {
        return meetingLocation;
    }

    public List<Friend> getAttendingFriends() {
        return attendingFriends;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public LocalTime getMeetingTime() {
        return meetingTime;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }
}
