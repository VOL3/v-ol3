package org.vaadin.addon.vol3;

import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.OLRotationConstraint;

/**
 * Options for the view
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
    private String mapProjection;
    private String inputProjection;

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

    public String getMapProjection() {
        return mapProjection;
    }

    /** Sets the projection used on the map layers. Default is EPSG:3857 (Spherical Mercator). This MUST match the projection used by your map server
     *
     * @param mapProjection the map projection
     */
    public void setMapProjection(String mapProjection) {
        this.mapProjection = mapProjection;
    }

    public String getInputProjection(){
        return inputProjection;
    }

    /** Sets the projection used when interpreting Coordinates and Extents passed in view api calls. If the inputProjection differs from map projection,
     * automatic conversion is done by the wrapper. The default is the value of the map projection.
     * @param inputProjection the input projection
     */
    public void setInputProjection(String inputProjection){
        this.inputProjection=inputProjection;
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
