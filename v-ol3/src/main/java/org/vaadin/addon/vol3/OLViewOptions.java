package org.vaadin.addon.vol3;

import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.OLRotationConstraint;

/**
 * Created by mjhosio on 01/07/14.
 */
public class OLViewOptions {
    private OLRotationConstraint rotationConstraint;
    private Boolean enableRotation;
    private OLExtent extent;
    private Double maxResolution;
    private Double minResolution;
    private Integer maxZoom;
    private Integer minZoom;
    private Double zoomFactor;
    private String projection;

    public Boolean getEnableRotation() {
        return enableRotation;
    }

    /**Enable rotation. Default is true.
     *
     * @param enableRotation
     */
    public void setEnableRotation(Boolean enableRotation) {
        this.enableRotation = enableRotation;
    }

    public OLExtent getExtent() {
        return extent;
    }

    /** The extent that constrains the center, in other words, center cannot be set outside this extent.
     *
     * @param extent
     */
    public void setExtent(OLExtent extent) {
        this.extent = extent;
    }

    public Double getMaxResolution() {
        return maxResolution;
    }

    /** The maximum resolution used to determine the resolution constraint.
     *
     * @param maxResolution
     */
    public void setMaxResolution(Double maxResolution) {
        this.maxResolution = maxResolution;
    }

    public Double getMinResolution() {
        return minResolution;
    }

    /** The minimum resolution used to determine the resolution constraint.
     *
     * @param minResolution
     */
    public void setMinResolution(Double minResolution) {
        this.minResolution = minResolution;
    }

    public Integer getMaxZoom() {
        return maxZoom;
    }

    /** The maximum zoom level used to determine the resolution constraint.
     *
     * @param maxZoom
     */
    public void setMaxZoom(Integer maxZoom) {
        this.maxZoom = maxZoom;
    }

    public Integer getMinZoom() {
        return minZoom;
    }

    /** The minimum zoom level used to determine the resolution constraint
     *
     * @param minZoom
     */
    public void setMinZoom(Integer minZoom) {
        this.minZoom = minZoom;
    }

    public String getProjection() {
        return projection;
    }

    /** The projection. Default is EPSG:3857 (Spherical Mercator).
     *
     * @param projection
     */
    public void setProjection(String projection) {
        this.projection = projection;
    }

    public Double getZoomFactor() {
        return zoomFactor;

    }

    /** The projection. Default is EPSG:3857 (Spherical Mercator).
     *
     * @param zoomFactor
     */
    public void setZoomFactor(Double zoomFactor) {
        this.zoomFactor = zoomFactor;
    }

    public OLRotationConstraint getRotationConstraint() {
        return rotationConstraint;
    }

    /** Rotation constraints for the map
     *
     * @param rotationConstraint
     */
    public void setRotationConstraint(OLRotationConstraint rotationConstraint) {
        this.rotationConstraint = rotationConstraint;
    }
}
