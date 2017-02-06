package org.vaadin.addon.vol3.client.source;

/**
 * Shared state for the OLOSMSource
 */
public class OLTileXYZSourceState extends OLXYZSourceState {
    public Boolean showOSMAttributions;
    public String[] customAttributions;
    public Integer maxZoom;
    public Integer minZoom;
    public String crossOriginPolicy;
    // tilegrid for the source
    public OLTileGrid tileGrid;
    public String projection;
}
