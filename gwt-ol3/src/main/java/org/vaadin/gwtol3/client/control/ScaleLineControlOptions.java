package org.vaadin.gwtol3.client.control;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Options passed to the ScaleLineControl on creation
 */
public class ScaleLineControlOptions extends JavaScriptObject {
    protected ScaleLineControlOptions() {
    }

    public static final native ScaleLineControlOptions create()/*-{
        return {};
    }-*/;

    /** Sets the css class name of the control. Default is ol-scale-line
     *
     * @param className className
     */
    public final native void setClassName(String className)/*-{
        this.className=className;
    }-*/;

    /** Sets the minimum width in pixels. Default is 64
     *
     * @param minWidth
     */
    public final native void setMinWidth(int minWidth)/*-{
        this.minWidth=minWidth;
    }-*/;

    /** Sets the units of the scale line ('degrees', 'imperial', 'nautical', 'metric', 'us') Default is metric.
     *
     * @param units
     */
    public final native void setUnits(String units)/*-{
        this.units=units;
    }-*/;

    public static final String UNITS_DEGREES="degrees";
    public static final String UNITS_IMPERIAL="imperial";
    public static final String UNITS_NAUTICAL="nautical";
    public static final String UNITS_METRIC="metric";
    public static final String UNITS_US="us";
}
