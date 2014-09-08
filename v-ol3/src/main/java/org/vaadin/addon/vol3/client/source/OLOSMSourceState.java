package org.vaadin.addon.vol3.client.source;

/**
 * Shared state for the OLOSMSource
 */
public class OLOSMSourceState extends OLXYZSourceState{
    public Boolean showDataAttributions;
    public Boolean showTileAttributions;
    public String [] customAttributions;
    public Integer maxZoom;
    public String crossOriginPolicy;
}
