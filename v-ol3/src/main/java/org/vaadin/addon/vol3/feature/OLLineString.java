package org.vaadin.addon.vol3.feature;

import org.vaadin.addon.vol3.client.OLCoordinate;

/**
 * A geometry consisting a continuous set of lines drawn on the layer. Basically kind of a path formed by a set of lines.
 */
public class OLLineString extends OLGeometry<OLCoordinate> {

    public OLLineString(OLCoordinate ... coordinates){
        super(coordinates);
    }
}
