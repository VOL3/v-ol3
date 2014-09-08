package org.vaadin.gwtol3.client.control;

/**
 * A button control to reset rotation to 0. To style this control use css selector .ol-rotate.
 */
public class RotateControl extends Control {
    protected RotateControl() {
    }

    public static final native RotateControl create()/*-{
        return new $wnd.ol.control.Rotate();
    }-*/;

    public static final native RotateControl create(RotateControlOptions options)/*-{
        return new $wnd.ol.control.Rotate(options);
    }-*/;

}
