package org.vaadin.addon.vol3.layer;

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

    public Double getBrightness() {
        return brightness;
    }

    public void setBrightness(Double brightness) {
        this.brightness = brightness;
    }

    public Double getContrast() {
        return contrast;
    }

    public void setContrast(Double contrast) {
        this.contrast = contrast;
    }

    public Double getHue() {
        return hue;
    }

    public void setHue(Double hue) {
        this.hue = hue;
    }

    public Double getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(Double maxResolution) {
        this.maxResolution = maxResolution;
    }

    public Double getMinResolution() {
        return minResolution;
    }

    public void setMinResolution(Double minResolution) {
        this.minResolution = minResolution;
    }

    public Double getOpacity() {
        return opacity;
    }

    public void setOpacity(Double opacity) {
        this.opacity = opacity;
    }

    public Double getSaturation() {
        return saturation;
    }

    public void setSaturation(Double saturation) {
        this.saturation = saturation;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
