package org.vaadin.addon.vol3.client.layer;

/**
 * Shared state for the heatmap layer
 */
@SuppressWarnings("serial")
public class OLHeatmapLayerState extends OLLayerState {
    public String[] gradient;
    public Double radius;
    public Double blur;
    public Double shadow;
    public String weight;
}
