package org.example.Model;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

public class OSMMap extends JMapViewer {

    ExpMapMarker marker;

    public OSMMap() {
        ICoordinate position = new Coordinate(52.23, 21.0);
        this.setDisplayPosition(position, 11); // zoom from 0 to 19

        this.zoomSlider.setVisible(false);
        this.zoomInButton.setVisible(false);
        this.zoomOutButton.setVisible(false);

        marker = new ExpMapMarker("Warsaw", new Coordinate(52.23, 21.0));
        marker.isCreated = true;
        this.addMapMarker(marker);

        this.setBounds(0, 0, 1280, 720);
    }
}
