package org.vaadin.addon.vol3.client.layer;

import com.vaadin.shared.AbstractComponentState;

/**
 * Base class for layer states
 */
public class OLLayerState extends AbstractComponentState{

    public Double brightness;
    public Double contrast;
    public Double hue;
    public Double maxResolution;
    public Double minResolution;
    public Double opacity;
    public Double saturation;
    public Boolean visible;
}
