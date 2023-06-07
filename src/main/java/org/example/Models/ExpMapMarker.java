package org.example.Models;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.example.Service.LocationsReverseService;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import java.awt.*;
import java.io.File;
import java.io.Serializable;

@Getter
@Setter
public class ExpMapMarker extends MapMarkerDot implements Serializable {

    private boolean isCreated = false;
    private boolean isTemp = false;
    private String description = "";
    private LocationReverse location;
    private String defaultImagePath = "location_default.png";

    private transient Image locationPicture;

    @SneakyThrows
    public ExpMapMarker(String name, Coordinate coord) {
        super(name, coord);

        LocationsReverseService locationsReverseService = new LocationsReverseService(new ObjectMapper());
        String lat = String.valueOf(this.getCoordinate().getLat());
        String lon = String.valueOf(this.getCoordinate().getLon());
        location = locationsReverseService.getLocationFromCoordinates(lat, lon, "18");
        //System.out.println(location.getDisplayName());

        locationPicture = ImageIO.read(new File(defaultImagePath));
    }
}
