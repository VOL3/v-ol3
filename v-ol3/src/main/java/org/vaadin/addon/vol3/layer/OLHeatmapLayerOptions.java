package org.vaadin.addon.vol3.layer;

/**
 * Options passed to image layer on creation
 */
public class OLHeatmapLayerOptions extends OLLayerOptions {
    private String[] gradient;
    private double radius;
    private double blur;
    private double shadow;
    private String weight;

    public String[] getGradient() {
        return gradient;
    }

    public void setGradient(String[] gradient) {
        this.gradient = gradient;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getBlur() {
        return blur;
    }

    public void setBlur(double blur) {
        this.blur = blur;
    }

    public double getShadow() {
        return shadow;
    }

    public void setShadow(double shadow) {
        this.shadow = shadow;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

}
