package org.vaadin.addon.vol3.client.layer;

import com.vaadin.shared.AbstractComponentState;
import org.vaadin.addon.vol3.client.OLExtent;

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
    public OLExtent extent;
    public String inputProjection;
}
