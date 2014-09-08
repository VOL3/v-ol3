package org.vaadin.gwtol3.client.control;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Options for the RotateControl passed on creation.
 */
public class RotateControlOptions extends JavaScriptObject{
    protected RotateControlOptions() {

    }

    public static final native RotateControlOptions create()/*-{
        return {};
    }-*/;

    /** Sets the css class name of the control. Default is ol-rotate
     *
     * @param className className
     */
    public final native void setClassName(String className)/*-{
        this.className=className;
    }-*/;

    /** Sets the text label for the rotate button
     *
     * @param label
     */
    public final native void setLabel(String label)/*-{
        this.label=label;
    }-*/;

    /** Sets the text label for the rotate tip. Default is Reset rotation
     *
     * @param tipLabel
     */
    public final native void setTipLabel(String tipLabel)/*-{
        this.tipLabel=tipLabel;
    }-*/;

    /** Sets the animation duration in milliseconds. Default is 250 ms.
     *
     * @param duration
     */
    public final native void setDuration(int duration)/*-{
        this.duration=duration;
    }-*/;

    /** Hide the control when rotation is 0. Default is true
     *
     * @param autoHide
     */
    public final native void setAutoHide(boolean autoHide)/*-{
        this.autoHide=autoHide;
    }-*/;
}
