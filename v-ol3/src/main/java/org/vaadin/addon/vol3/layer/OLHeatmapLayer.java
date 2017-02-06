package org.vaadin.addon.vol3.layer;

import java.util.List;

import org.vaadin.addon.vol3.client.layer.OLHeatmapLayerState;
import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.addon.vol3.source.OLSource;

/**
 * Vector layer for drawing markers (features)
 */
@SuppressWarnings("serial")
public class OLHeatmapLayer extends OLLayer {

    /**
     * Creates a new instance of the layer
     * 
     * @param source
     *            the data source for the vector data
     */
    public OLHeatmapLayer(OLSource source) {
        super(source, null);
    }

    /**
     * Creates a new instance of the layer
     *
     * @param source
     *            the data source for the vector data
     * @param options
     *            vector source options
     */
    public OLHeatmapLayer(OLSource source, OLHeatmapLayerOptions options) {
        super(source, options);
    }

    @Override
    protected OLHeatmapLayerState getState() {
        return (OLHeatmapLayerState) super.getState();
    }

    public void setGradient(String[] gradient) {
        getState().gradient = gradient;
    }

    public String[] getGradient() {
        return getState().gradient;
    }

    public void setRadius(double radius) {
        getState().radius = radius;
    }

    public double getRadius() {
        return getState().radius;
    }

    public void setBlur(double blur) {
        getState().blur = blur;
    }

    public double getBlur() {
        return getState().blur;
    }

    public void setShadow(double shadow) {
        getState().shadow = shadow;
    }

    public double getShadow() {
        return getState().shadow;
    }

    public void setWeight(String weight) {
        getState().weight = weight;
    }

    public String getWeight() {
        return getState().weight;
    }
}
