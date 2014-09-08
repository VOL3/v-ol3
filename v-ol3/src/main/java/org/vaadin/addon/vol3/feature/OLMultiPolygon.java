package org.vaadin.addon.vol3.feature;

/**
 * Geometry consisting of multiple polygons
 */
public class OLMultiPolygon extends OLGeometry<OLPolygon> {

    public OLMultiPolygon(OLPolygon ... polygons) {
        super(polygons);
    }
}

