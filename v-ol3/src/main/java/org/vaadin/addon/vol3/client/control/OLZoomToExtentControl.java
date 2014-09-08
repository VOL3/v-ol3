package org.vaadin.addon.vol3.client.control;

import org.vaadin.addon.vol3.client.OLExtent;

import java.io.Serializable;

/**
 * A button control which, when pressed, changes the map view to a specific extent. To style this control use the css selector .ol-zoom-extent.
 */
public class OLZoomToExtentControl implements Serializable {

    // the css class name of the control. Default is ol-zoom-slider
    public String className;
    // Text label to use for the button tip. Default is Zoom to extent
    public String tipLabel;
    // The extent to zoom to. If null the validity extent of the view projection is used.
    public OLExtent extent;
}
