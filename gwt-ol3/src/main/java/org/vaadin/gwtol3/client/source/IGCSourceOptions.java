package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Options for the IGC source
 */
public class IGCSourceOptions extends JavaScriptObject{
    protected IGCSourceOptions() {
    }

    public static final native IGCSourceOptions create() /*-{
        return {};
    }-*/;

    public native final void setUrl(String url)/*-{
        this.url = url;
    }-*/;

    public native final void setUrls(JsArrayString urls)/*-{
        this.urls = urls;
    }-*/;

    public final native void setText(String text)/*-{
        this.text=text;
    }-*/;

    public final native void setProjection(String projection)/*-{
        this.projection=projection;
    }-*/;

    /** Altitude mode. Possible values are barometric, gps, and none. Default is none.
     *
     * @param altitudeMode
     */
    public final native void setAltitudeMode(String altitudeMode)/*-{
        this.altitudeMode=altitudeMode;
    }-*/;

}
