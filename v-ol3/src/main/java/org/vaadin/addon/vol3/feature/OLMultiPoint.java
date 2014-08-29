package org.vaadin.addon.vol3.feature;

/**
 * Geometry consisting of multiple points
 * Created by mjhosio on 27/08/14.
 */
public class OLMultiPoint extends OLGeometry<OLPoint> {

    public OLMultiPoint(OLPoint ... points){
        super(points);
    }
}
