package org.vaadin.gwtol3.client.control;

/**
 * A button control which, when pressed, changes the map view to a specific extent. To style this control use the css selector .ol-zoom-extent.
 * Created by mjhosio on 11/07/14.
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
