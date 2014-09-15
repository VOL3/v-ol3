package org.vaadin.addon.vol3.feature;

import org.vaadin.addon.vol3.client.OLCoordinate;

/**
 * Point type geometry
 */
public class OLPoint extends OLGeometry<OLCoordinate> {

    public OLPoint(OLCoordinate coordinate) {
        super(coordinate);
    }

    public OLPoint(double longitude, double latitude) {
        this(new OLCoordinate(longitude, latitude));
    }

    public Double getX() {
        OLCoordinate coordinate = this.getElements().get(0);
        return coordinate.x;
    }

    public Double getY() {
        OLCoordinate coordinate = this.getElements().get(0);
        return coordinate.y;
    }

    public void setX(double x) {
        OLCoordinate coordinate = this.getElements().get(0);
        coordinate.x = x;
    }

    public void setY(double y) {
        OLCoordinate coordinate = this.getElements().get(0);
        coordinate.y = y;
    }

    public Double getLongitude() {
        OLCoordinate coordinate = this.getElements().get(0);
        return coordinate.x;
    }

    public Double getLatitude() {
        OLCoordinate coordinate = this.getElements().get(0);
        return coordinate.x;
    }

    public void setLongitude(double longitude) {
        OLCoordinate coordinate = this.getElements().get(0);
        coordinate.x = longitude;
    }

    public void setLatitude(double latitude) {
        OLCoordinate coordinate = this.getElements().get(0);
        coordinate.y = latitude;
    }
}
