package org.vaadin.addon.vol3.feature;

/**
 * A geometry consisting a set of linestrings
 */
public class OLMultiLineString extends OLGeometry<OLLineString>{
    public OLMultiLineString(OLLineString ... lineString) {
        super(lineString);
    }
}
