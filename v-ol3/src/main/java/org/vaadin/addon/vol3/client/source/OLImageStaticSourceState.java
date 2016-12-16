package org.vaadin.addon.vol3.client.source;

import org.vaadin.addon.vol3.client.OLExtent;

/**
 * Shared state for the OLImageWMSSource
 */
public class OLImageStaticSourceState extends OLSourceState {
    public String[] attributions;
    public OLExtent imageExtent;
    // crs name of the projection
    public String projection;
    public String url;

}
