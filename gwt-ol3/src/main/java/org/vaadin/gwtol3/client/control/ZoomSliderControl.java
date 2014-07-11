package org.vaadin.gwtol3.client.control;

/**
 * A slider type of control for zooming.
 * Created by mjhosio on 11/07/14.
 */
public class ZoomSliderControl extends Control{
    protected ZoomSliderControl() {
    }

    public static final native ZoomSliderControl create()/*-{
        return new $wnd.ol.control.ZoomSlider();
    }-*/;

    public static final native ZoomSliderControl create(ZoomSliderControlOptions options)/*-{
        return new $wnd.ol.control.ZoomSlider(options);
    }-*/;
}
