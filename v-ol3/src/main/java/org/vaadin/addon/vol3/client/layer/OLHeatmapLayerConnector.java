package org.vaadin.addon.vol3.client.layer;

import org.vaadin.addon.vol3.client.util.DataConversionUtils;
import org.vaadin.addon.vol3.layer.OLHeatmapLayer;
import org.vaadin.gwtol3.client.layer.HeatmapLayer;
import org.vaadin.gwtol3.client.layer.Layer;
import org.vaadin.gwtol3.client.source.Source;
import org.vaadin.gwtol3.client.source.VectorSource;

import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.shared.ui.Connect;

/**
 * Client-side connector for the heatmap layer
 */
@SuppressWarnings("serial")
@Connect(OLHeatmapLayer.class)
public class OLHeatmapLayerConnector extends OLLayerConnector {

    @Override
    public OLHeatmapLayerState getState() {
        return (OLHeatmapLayerState) super.getState();
    }

    @Override
    protected Layer createLayer(Source source) {
        return HeatmapLayer.create((VectorSource) source);
    }

    @Override
    public HeatmapLayer getLayer() {
        return (HeatmapLayer) super.getLayer();
    }

    @OnStateChange("gradient")
    void updateGradient() {
        if (getState().gradient != null) {
            getLayer().setGradient(DataConversionUtils.toJsArrayString(getState().gradient));
        }
    }

    @OnStateChange("radius")
    void updateRadius() {
        if (getState().radius != null) {
            getLayer().setRadius(getState().radius);
        }
    }

    @OnStateChange("blur")
    void updateBlur() {
        if (getState().blur != null) {
            getLayer().setBlur(getState().blur);
        }
    }

    @OnStateChange("shadow")
    void updateShadow() {
        if (getState().shadow != null) {
            getLayer().setShadow(getState().shadow);
        }
    }

    @OnStateChange("weight")
    void updateWeight() {
        if (getState().weight != null) {
            getLayer().setWeight(getState().weight);
        }
    }
}
