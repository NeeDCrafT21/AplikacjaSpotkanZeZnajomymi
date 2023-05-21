package org.example;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Meeting {
    List<Friend> attendingFriends;
    ExpMapMarker meetingLocation;
    Date meetingDate;
    LocalTime meetingTime;

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
}
