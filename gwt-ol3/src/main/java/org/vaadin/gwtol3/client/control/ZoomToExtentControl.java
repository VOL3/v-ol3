package org.vaadin.gwtol3.client.control;

/**
 * A button control which, when pressed, changes the map view to a specific extent. To style this control use the css selector .ol-zoom-extent.
 */
public class ZoomToExtentControl extends Control{
    protected ZoomToExtentControl() {
    }

    public static final native ZoomToExtentControl create()/*-{
        return new $wnd.ol.control.ZoomToExtent();
    }-*/;

    public static final native ZoomToExtentControl create(ZoomToExtentControlOptions options)/*-{
        return new $wnd.ol.control.ZoomToExtent(options);
    }-*/;
}
