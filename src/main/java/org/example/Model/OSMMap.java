package org.example.Model;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class OSMMap extends JMapViewer implements MouseWheelListener {

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
        this.addMouseWheelListener(this);

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(this.getZoom() <= 11) {
            this.marker.setVisible(false);
            //marker.setVisible(false);
        }
        else {
            this.marker.setVisible(true);
        }

    }
}
