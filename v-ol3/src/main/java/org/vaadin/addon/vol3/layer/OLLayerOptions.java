package org.vaadin.addon.vol3.layer;

import org.vaadin.addon.vol3.client.OLExtent;

/**
 * Options common for all layer types
 */
public class OLLayerOptions {

    private Double maxResolution;
    private Double minResolution;
    private Double opacity;
    private Boolean visible;
    private OLExtent extent;
    private String inputProjection;
    private int zIndex;
    private String title;

    public Double getMaxResolution() {
        return maxResolution;
    }

    public OLLayerOptions setMaxResolution(Double maxResolution) {
        this.maxResolution = maxResolution;
        return this;
    }

    public Double getMinResolution() {
        return minResolution;
    }

    public OLLayerOptions setMinResolution(Double minResolution) {
        this.minResolution = minResolution;
        return this;
    }

    public Double getOpacity() {
        return opacity;
    }

    public OLLayerOptions setOpacity(Double opacity) {
        this.opacity = opacity;
        return this;
    }

    public Boolean getVisible() {
        return visible;
    }

    public OLLayerOptions setVisible(Boolean visible) {
        this.visible = visible;
        return this;
    }

    public OLExtent getExtent() {
        return extent;
    }

    public OLLayerOptions setExtent(OLExtent extent) {
        this.extent = extent;
        return this;
    }

    public String getInputProjection() {
        return inputProjection;
    }

    public OLLayerOptions setInputProjection(String inputProjection) {
        this.inputProjection = inputProjection;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public OLLayerOptions setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getZIndex() {
        return zIndex;
    }

    public OLLayerOptions setZIndex(int zIndex) {
        this.zIndex = zIndex;
        return this;
    }
}
