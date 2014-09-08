package org.vaadin.addon.vol3.client.control;

import java.io.Serializable;

/**
 * A control with 2 buttons, one for zoom in and one for zoom out. This control is one of the default controls of a map. To style this control use css selectors .ol-zoom-in and .ol-zoom-out.
 */
public class OLZoomControl implements Serializable {

    // the css class name of the control. Default is ol-zoom
    public String className;
    // animation duration in milliseconds. Default is 250 ms
    public Integer duration;
    // ext label to use for the zoom-in button. Default is +
    public String zoomInLabel;
    // ext label to use for the zoom-out button. Default is -
    public String zoomOutLabel;
    // Text label to use for the button tip. Default is Zoom in
    public String zoomInTipLabel;
    // Text label to use for the button tip. Default is Zoom out
    public String zoomOutTipLabel;
    // The zoom delta applied on each click
    public Double delta;
}
