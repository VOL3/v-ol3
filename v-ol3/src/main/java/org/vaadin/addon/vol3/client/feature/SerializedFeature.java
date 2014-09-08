package org.vaadin.addon.vol3.client.feature;

import org.vaadin.addon.vol3.client.style.OLStyle;

import java.io.Serializable;
import java.util.List;

/**
 * Serialized version of a feature to be drawn on the vector layer
 */
public class SerializedFeature implements Serializable {
    public String id;
    public List<OLStyle> styles;
    // the serialized geometry
    public String serializedGeometry;
}
