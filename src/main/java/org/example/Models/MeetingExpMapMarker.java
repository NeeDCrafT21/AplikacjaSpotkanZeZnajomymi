package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.Serializable;

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
