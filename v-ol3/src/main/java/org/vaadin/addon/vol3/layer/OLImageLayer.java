package org.vaadin.addon.vol3.layer;

import org.vaadin.addon.vol3.source.OLSource;

/**
 * Layer for layer sources that provide server-rendered images that are available for arbitrary extents and resolutions.
 */
public class OLImageLayer extends OLLayer{
    public OLImageLayer(OLSource source) {
        this(source, null);
    }

    public OLImageLayer(OLSource source, OLImageLayerOptions options) {
        super(source, options);
    }
}
