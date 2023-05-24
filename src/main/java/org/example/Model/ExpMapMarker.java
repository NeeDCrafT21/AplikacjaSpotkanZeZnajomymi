package org.example.Model;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

public class ExpMapMarker extends MapMarkerDot {

    public boolean isCreated = false;
    public String description = "";

    public ExpMapMarker(String name, Coordinate coord) {
        super(name, coord);
    }
}
