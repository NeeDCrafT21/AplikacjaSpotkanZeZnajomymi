package org.example.Models;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class MeetingExpMapMarker implements Serializable {
    private String name;
    private String description;
    private LocationReverse location;

    @SneakyThrows
    public MeetingExpMapMarker(String name, String description, LocationReverse location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }
}
