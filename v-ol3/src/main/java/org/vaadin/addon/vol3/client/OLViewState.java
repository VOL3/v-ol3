package org.vaadin.addon.vol3.client;

import com.vaadin.shared.AbstractComponentState;

/**
 * Shared state for the view
 */
public class OLViewState extends AbstractComponentState {
    // crs name of the projection (EPSG:3857 and EPSG:4326 are supported out of the box)
    public String projection; // use spherical mercator by default;

    // enable rotation, defaults to true
    public Boolean enableRotation;
    // rotation constraint
    public OLRotationConstraint rotationConstraint;
    // The extent that constrains the center, in other words, center cannot be set outside this extent.
    public OLExtent extent;
    public Double maxResolution;
    public Double minResolution;
    public Integer maxZoom;
    public Integer minZoom;
    public Double zoomFactor;

}
