package org.vaadin.addon.vol3.client.control;

import java.io.Serializable;

/**
 * A slider type of control for zooming.
 */
public class OLZoomSliderControl implements Serializable {
    // the css class name of the control. Default is ol-zoom-slider
    public String className;
    // minimum resolution
    public Double minResolution;
    // maximum resolution
    public Double maxResolution;
}
