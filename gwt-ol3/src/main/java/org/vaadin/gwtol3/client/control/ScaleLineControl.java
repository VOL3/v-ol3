package org.vaadin.gwtol3.client.control;

/**
 * A control displaying rough x-axis distances. By default it will show in the bottom left portion of the map, but this can be changed by using the css selector .ol-scale-line.
 */
public class ScaleLineControl extends Control{
    protected ScaleLineControl() {
    }

    public static final native ScaleLineControl create()/*-{
        return new $wnd.ol.control.ScaleLine();
    }-*/;

    public static final native ScaleLineControl create(ScaleLineControlOptions options)/*-{
        return new $wnd.ol.control.ScaleLine(options);
    }-*/;
}
