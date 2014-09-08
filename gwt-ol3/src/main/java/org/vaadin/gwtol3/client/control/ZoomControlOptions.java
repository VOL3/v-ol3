package org.vaadin.gwtol3.client.control;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Options passed to the ZoomControl on creation
 */
public class ZoomControlOptions extends JavaScriptObject {
    protected ZoomControlOptions() {
    }

    public static final native ZoomControlOptions create()/*-{
        return {};
    }-*/;

    /** Sets the css class name of the control. Default is ol-zoom
     *
     * @param className className
     */
    public final native void setClassName(String className)/*-{
        this.className=className;
    }-*/;

    /** Animation duration in milliseconds. Default is 250.
     *
     * @param duration
     */
    public final native void setDuration(int duration)/*-{
        this.duration=duration;
    }-*/;

    /** ext label to use for the zoom-in button. Default is +
     *
     * @param zoomInLabel
     */
    public final native void setZoomInLabel(String zoomInLabel)/*-{
        this.zoomInLabel=zoomInLabel;
    }-*/;

    /** Text label to use for the zoom-out button. Default is -
     *
     * @param zoomOutLabel
     */
    public final native void setZoomOutLabel(String zoomOutLabel)/*-{
        this.zoomOutLabel=zoomOutLabel;
    }-*/;

    /** Text label to use for the button tip. Default is Zoom out
     *
     * @param zoomOutTipLabel
     */
    public final native void setZoomOutTipLabel(String zoomOutTipLabel)/*-{
        this.zoomOutTipLabel=zoomOutTipLabel;
    }-*/;

    /** Text label to use for the button tip. Default is Zoom in
     *
     * @param zoomInTipLabel
     */
    public final native void setZoomInTipLabel(String zoomInTipLabel)/*-{
        this.zoomInTipLabel=zoomInTipLabel;
    }-*/;

    /** The zoom delta applied on each click.
     *
     * @param delta
     */
    public final native void setDelta(double delta)/*-{
        this.delta=delta;
    }-*/;
}
