package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Attribution;

/**
 * Options passed to Open Street Map source on creation
 */
public class OSMSourceOptions extends JavaScriptObject {

    protected OSMSourceOptions() {
    }

    public static native final OSMSourceOptions create()/*-{
        return {};
    }-*/;

    /** Sets the attributions
     *
     * @param attributions attributions
     */
    public final native void setAttributions(JsArray<Attribution> attributions)/*-{
        this.attributions = attributions;
    }-*/;

    /** Sets the cross origin setting for image requests. Default is 'anonymous'
     *
     * @param crossOrigin cross origin setting
     */
    public final native void setCrossOrigin(String crossOrigin)/*-{
        this.crossOrigin = crossOrigin;
    }-*/;

    /** Sets the max zoom level for the source
     *
     * @param maxZoom maximum zoom level
     */
    public final native void setMaxZoom(int maxZoom)/*-{
        this.maxZoom = maxZoom;
    }-*/;

}
