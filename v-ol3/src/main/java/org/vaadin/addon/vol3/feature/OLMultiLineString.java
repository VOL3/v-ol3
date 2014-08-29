package org.vaadin.addon.vol3.feature;

/**
 * A geometry consisting a set of linestrings
 * Created by mjhosio on 27/08/14.
 */
public class OLMultiLineString extends OLGeometry<OLLineString>{
    public OLMultiLineString(OLLineString ... lineString) {
        super(lineString);
    }
}
