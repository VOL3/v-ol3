package org.vaadin.addon.vol3.feature;

import org.vaadin.addon.vol3.client.OLCoordinate;

/**
 * Point type geometry
 * Created by mjhosio on 27/08/14.
 */
public class OLPoint extends OLGeometry<OLCoordinate> {

    public OLPoint(OLCoordinate coordinate){
        super(coordinate);
    }

    public OLPoint(double longitude, double latitude){
        this(new OLCoordinate(longitude, latitude));
    }
}
