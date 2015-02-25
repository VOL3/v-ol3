package org.vaadin.addon.vol3.client.source;

/**
 * Shared state for the OLOSMSource
 */
public class OLOSMSourceState extends OLXYZSourceState{
    public Boolean showOSMAttributions;
    public String [] customAttributions;
    public Integer maxZoom;
    public String crossOriginPolicy;
}
