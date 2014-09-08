package org.vaadin.addon.vol3.feature;

/**
 * Geometry consisting of multiple points
 */
public class OLMultiPoint extends OLGeometry<OLPoint> {

    public OLMultiPoint(OLPoint ... points){
        super(points);
    }
}
