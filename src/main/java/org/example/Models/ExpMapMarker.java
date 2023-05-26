package org.example.Models;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.example.Service.LocationsReverseService;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

@Getter
@Setter
public class ExpMapMarker extends MapMarkerDot {

    private boolean isCreated = false;
    private String description = "";
    private LocationReverse location;

    public ExpMapMarker(String name, Coordinate coord) {
        super(name, coord);

        LocationsReverseService locationsReverseService = new LocationsReverseService(new ObjectMapper());
        String lat = this.getCoordinate().getLat()+"";
        String lon = this.getCoordinate().getLon()+"";
        location = locationsReverseService.getLocationFromCoordinates(lat, lon, "18");
        System.out.println(location.getDisplayName());
    }
}
