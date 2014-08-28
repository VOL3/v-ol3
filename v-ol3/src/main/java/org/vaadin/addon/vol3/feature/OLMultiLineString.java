package org.vaadin.addon.vol3.feature;

/**
 * Created by mjhosio on 27/08/14.
 */
public class OLMultiLineString extends OLGeometry<OLLineString>{
    public OLMultiLineString(OLLineString ... lineString) {
        super(lineString);
    }
}
