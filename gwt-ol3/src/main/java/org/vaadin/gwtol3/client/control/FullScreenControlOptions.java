package org.vaadin.gwtol3.client.control;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Options passed to the FullScreenControl on creation
 */
public class FullScreenControlOptions extends JavaScriptObject {
    protected FullScreenControlOptions() {
    }

    public static final native FullScreenControlOptions create()/*-{
        return {};
    }-*/;

    /** Sets the css class name of the control. Default is ol-full-screen
     *
     * @param className className
     */
    public final native void setClassName(String className)/*-{
        this.className=className;
    }-*/;

    /**
     * label to use for the button tip. Default is Toggle full-screen
     *
     * @param tipLabel
     */
    public final native void setTipLabel(String tipLabel)/*-{
        this.tipLabel=tipLabel;
    }-*/;

    public final native void setFullKeyboardAccess(boolean fullKeyboardAccess)/*-{
        this.keys=fullKeyboardAccess;
    }-*/;


}
