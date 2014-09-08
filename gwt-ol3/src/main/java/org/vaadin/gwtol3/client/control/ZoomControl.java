package org.vaadin.gwtol3.client.control;

/**
 * A control with 2 buttons, one for zoom in and one for zoom out. This control is one of the default controls of a map. To style this control use css selectors .ol-zoom-in and .ol-zoom-out.
 */
public class ZoomControl extends Control{
    protected ZoomControl() {
    }

    public static final native ZoomControl create()/*-{
        return new $wnd.ol.control.Zoom();
    }-*/;

    public static final native ZoomControl create(ZoomControlOptions options)/*-{
        return new $wnd.ol.control.Zoom(options);
    }-*/;
}
