package org.vaadin.addon.vol3.client;

import com.vaadin.shared.AbstractComponentState;

/**
 * Shared state for the view
 */
public class OLViewState extends AbstractComponentState {
    // crs name of the projection used in map (EPSG:3857 and EPSG:4326 are supported out of the box)
    public String mapProjection; // use spherical mercator (EPSG:3857) by default;

    // crs name of the projection used when interpreting coordinates and extents
    public String inputProjection;

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
    // resolutions for the map. If not specified, the resolutions will be calculated by ol3
    public double[] resolutions;
}
