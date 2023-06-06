package org.example.Models;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import lombok.Getter;
import lombok.Setter;
import org.example.Service.LocationsReverseService;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import java.io.Serializable;

@Getter
@Setter
public class ExpMapMarker extends MapMarkerDot implements Serializable {

    private boolean isCreated = false;
    private boolean isTemp = false;
    private String description = "";
    private LocationReverse location;

    public ExpMapMarker(String name, Coordinate coord) {
        super(name, coord);

        LocationsReverseService locationsReverseService = new LocationsReverseService(new ObjectMapper());
        String lat = String.valueOf(this.getCoordinate().getLat());
        String lon = String.valueOf(this.getCoordinate().getLon());
        location = locationsReverseService.getLocationFromCoordinates(lat, lon, "18");
        System.out.println(location.getDisplayName());
    }
}
