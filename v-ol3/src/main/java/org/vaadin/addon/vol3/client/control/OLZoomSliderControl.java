package org.vaadin.addon.vol3.client.control;

import java.io.Serializable;

/**
 * A slider type of control for zooming.
 * Created by mjhosio on 11/07/14.
 */
public class OLZoomSliderControl implements Serializable {
    // the css class name of the control. Default is ol-zoom-slider
    public String className;
    // minimum resolution
    public Double minResolution;
    // maximum resolution
    public Double maxResolution;
}
