package org.vaadin.gwtol3.client.control;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Options for the MousePositionControl passed on creation.
 */
public class MousePositionControlOptions extends JavaScriptObject{
    protected MousePositionControlOptions() {
    }

    public static final native MousePositionControlOptions create()/*-{
        return {};
    }-*/;

    /** Sets the css class name of the control. Default is ol-mouse-position
     *
     * @param className className
     */
    public final native void setClassName(String className)/*-{
        this.className=className;
    }-*/;

    /** Sets the projection where mouse position is reported in
     *
     * @param projection
     */
    public final native void setProjection(Projection projection)/*-{
        this.projection=projection;
    }-*/;

    /** Sets the string displayed when there is no coordinates to display. Empty string by default.
     *
     * @param undefinedHTML
     */
    public final native void setUndefinedHTML(String undefinedHTML)/*-{
        this.undefinedHTML = undefinedHTML;
    }-*/;
}
