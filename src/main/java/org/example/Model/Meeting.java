package org.example.Model;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import lombok.Getter;

@Getter
public class Meeting {
    private List<Friend> attendingFriends;
    private ExpMapMarker meetingLocation;
    private Date meetingDate;
    private LocalTime meetingTime;
    private Boolean isFinished = false;

    public Meeting(
            List<Friend> attendingFriends, ExpMapMarker meetingLocation, Date meetingDate, LocalTime meetingTime) {
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
