package org.vaadin.addon.vol3.client.feature;

import org.vaadin.addon.vol3.client.style.OLStyle;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mjhosio on 08/07/14.
 */
public class SerializedFeature implements Serializable {
    public String id;
    public List<OLStyle> styles;
    // the geometry serialized as geojson
    public String serializedGeometry;
}
