package org.vaadin.addon.vol3.feature;

import org.vaadin.addon.vol3.client.OLCoordinate;

/**
 * Created by mjhosio on 27/08/14.
 */
public class OLLineString extends OLGeometry<OLCoordinate> {

    public OLLineString(OLCoordinate ... coordinates){
        super(coordinates);
    }
}
