package org.vaadin.addon.vol3.feature;

import org.vaadin.addon.vol3.client.OLCoordinate;

import java.util.Arrays;
import java.util.List;

/**
 * Polygon type of a geometry
 */
public class OLPolygon extends OLGeometry<List<OLCoordinate>> {

    public OLPolygon(OLCoordinate ... coordinates){
        add(Arrays.asList(coordinates));
    }

    public void addInteriorRing(OLCoordinate ... coordinates){
        add(Arrays.asList(coordinates));
    }

    public void addInteriorRing(List<OLCoordinate> coordinates){
        add(coordinates);
    }

}
