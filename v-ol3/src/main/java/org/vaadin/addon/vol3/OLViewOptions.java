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
    private OLExtent restrictedExtent;
    private Double maxResolution;
    private Double minResolution;
    private Integer maxZoom;
    private Integer minZoom;
    private Double zoomFactor;
    private String mapProjection;
    private String inputProjection;
    private double [] resolutions;

    public Boolean getEnableRotation() {
        return enableRotation;
    }

    /**Enable rotation. Default is true.
     *
     * @param enableRotation
     */
    public OLViewOptions setEnableRotation(Boolean enableRotation) {
        this.enableRotation = enableRotation;
        return this;
    }

    public OLExtent getExtent() {
        return extent;
    }

    /** The extent that constrains the center, in other words, center cannot be set outside this extent.
     *
     * @param extent
     */
    public OLViewOptions setExtent(OLExtent extent) {
        this.extent = extent;
        return this;
    }

    public OLExtent getRestrictedExtent() {
        return restrictedExtent;
    }

    /** The extent that constrains the view, in other words, panning cannot go outside this extent.
     *
     * @param extent
     */
    public OLViewOptions setRestrictedExtent(OLExtent extent) {
        this.restrictedExtent = extent;
        return this;
    }

    public Double getMaxResolution() {
        return maxResolution;
    }

    /** The maximum resolution used to determine the resolution constraint.
     *
     * @param maxResolution
     */
    public OLViewOptions setMaxResolution(Double maxResolution) {
        this.maxResolution = maxResolution;
        return this;
    }

    public Double getMinResolution() {
        return minResolution;
    }

    /** The minimum resolution used to determine the resolution constraint.
     *
     * @param minResolution
     */
    public OLViewOptions setMinResolution(Double minResolution) {
        this.minResolution = minResolution;
        return this;
    }

    public Integer getMaxZoom() {
        return maxZoom;
    }

    /** The maximum zoom level used to determine the resolution constraint.
     *
     * @param maxZoom
     */
    public OLViewOptions setMaxZoom(Integer maxZoom) {
        this.maxZoom = maxZoom;
        return this;
    }

    public Integer getMinZoom() {
        return minZoom;
    }

    /** The minimum zoom level used to determine the resolution constraint
     *
     * @param minZoom
     */
    public OLViewOptions setMinZoom(Integer minZoom) {
        this.minZoom = minZoom;
        return this;
    }

    public String getMapProjection() {
        return mapProjection;
    }

    /** Sets the projection used on the map layers. Default is EPSG:3857 (Spherical Mercator). This MUST match the projection used by your map server. The EPSG:3857 and EPSG:4326 are supported out of the box. Others must be enabled from map options passed to the OLMap on creation.
     *
     * @param mapProjection the map projection
     */
    public OLViewOptions setMapProjection(String mapProjection) {
        this.mapProjection = mapProjection;
        return this;
    }

    public String getInputProjection(){
        return inputProjection;
    }

    /** Sets the projection used when interpreting Coordinates and Extents passed in view api calls. If the inputProjection differs from map projection,
     * automatic conversion is done by the wrapper. The default is the value of the map projection.
     * @param inputProjection the input projection
     */
    public OLViewOptions setInputProjection(String inputProjection){
        this.inputProjection=inputProjection;
        return this;
    }

    public Double getZoomFactor() {
        return zoomFactor;

    }

    /** The zoom factor used to determine the resolution constraint. Default is 2
     *
     * @param zoomFactor
     */
    public OLViewOptions setZoomFactor(Double zoomFactor) {
        this.zoomFactor = zoomFactor;
        return this;
    }

    public OLRotationConstraint getRotationConstraint() {
        return rotationConstraint;
    }

    /** Rotation constraints for the map
     *
     * @param rotationConstraint
     */
    public OLViewOptions setRotationConstraint(OLRotationConstraint rotationConstraint) {
        this.rotationConstraint = rotationConstraint;
        return this;
    }


    public double[] getResolutions() {
        return resolutions;
    }

    /** Resolutions to determine the resolution constraint. If set the maxResolution, minResolution, minZoom, maxZoom, and zoomFactor options are ignored
     *
     * @param resolutions
     */
    public OLViewOptions setResolutions(double[] resolutions) {
        this.resolutions = resolutions;
        return this;
    }
}
