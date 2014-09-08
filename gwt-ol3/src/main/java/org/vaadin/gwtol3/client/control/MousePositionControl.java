package org.vaadin.gwtol3.client.control;

import org.vaadin.gwtol3.client.proj.Projection;

/**
 * A control to show the 2D coordinates of the mouse cursor. By default, these are in the view projection, but can be in any supported projection. By default the control is shown in the top right corner of the map, but this can be changed by using the css selector .ol-mouse-position.
 */
public class MousePositionControl extends Control {
    protected MousePositionControl() {
    }

    public static final native MousePositionControl create()/*-{
        return new $wnd.ol.control.MousePosition();
    }-*/;

    public static final native MousePositionControl create(MousePositionControlOptions options)/*-{
        return new $wnd.ol.control.MousePosition(options);
    }-*/;

    /** Sets the projection where mouse position is reported in
     *
     * @param projection
     */
    public final native void setProjection(Projection projection)/*-{
        this.setProjection(projection);
    }-*/;

    /** Gets the projection where mouse position is reported in
     *
     */
    public final native void getProjection()/*-{
        return this.getProjection();
    }-*/;

}
