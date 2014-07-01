package org.vaadin.addon.vol3.client;

import com.vaadin.shared.AbstractComponentState;

/**
 * Created by mjhosio on 30/06/14.
 */
public class OLViewState extends AbstractComponentState {
    public Integer zoom;
    public OLCoordinate center;
    public Double resolution;
    public Double rotation;
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
