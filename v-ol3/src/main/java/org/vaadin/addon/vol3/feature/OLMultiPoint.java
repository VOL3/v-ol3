package org.vaadin.addon.vol3.feature;

import java.util.Collection;

/**
 * Geometry consisting of multiple points
 */
public class OLMultiPoint extends OLGeometry<OLPoint> {

    public OLMultiPoint(OLPoint ... points){
        super(points);
    }
    
    public OLMultiPoint(Collection<OLPoint> points){
        super(points);
    }
}
