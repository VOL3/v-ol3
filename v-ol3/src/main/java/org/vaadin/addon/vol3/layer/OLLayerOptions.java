package org.vaadin.addon.vol3.layer;

import org.vaadin.addon.vol3.client.OLExtent;

/**
 * Options common for all layer types
 */
public class OLLayerOptions {

    private Double brightness;
    private Double contrast;
    private Double hue;
    private Double maxResolution;
    private Double minResolution;
    private Double opacity;
    private Double saturation;
    private Boolean visible;
    private OLExtent extent;
    private String inputProjection;
    private String title;

    public Double getBrightness() {
        return brightness;
    }

    public OLLayerOptions setBrightness(Double brightness) {
        this.brightness = brightness;
        return this;
    }

    public Double getContrast() {
        return contrast;
    }

    public OLLayerOptions setContrast(Double contrast) {
        this.contrast = contrast;
        return this;
    }

    public Double getHue() {
        return hue;
    }

    public OLLayerOptions setHue(Double hue) {
        this.hue = hue;
        return this;
    }

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

    public Double getSaturation() {
        return saturation;
    }

    public OLLayerOptions setSaturation(Double saturation) {
        this.saturation = saturation;
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
}
