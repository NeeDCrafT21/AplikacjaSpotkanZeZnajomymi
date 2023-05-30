package org.example.Models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MeetingExpMapMarker implements Serializable {
    private String name;
    private String description;
    private LocationReverse location;

    public MeetingExpMapMarker(String name, String description, LocationReverse location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }
}
