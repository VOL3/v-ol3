package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import org.vaadin.gwtol3.client.Attribution;

/**
 * Settings passed to the ImageWMSSource on creation
 */
public class ImageWMSSourceOptions extends JavaScriptObject {

    protected ImageWMSSourceOptions() {
    }

    public static native final ImageWMSSourceOptions create()/*-{
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

    public native final void setProjection(String projection)/*-{
        this.projection=projection;
    }-*/;

    /** Use the Map.pixelRatio value when requesting the image from the remote server. Default is true.
     *
     * @param hidpi
     */
    public native final void setHidpi(boolean hidpi)/*-{
        this.hidpi = hidpi;
    }-*/;

    /** The type of the remote WMS server: mapserver, geoserver or qgis. Only needed if hidpi is true.
     *
     * @param serverType the type of the server
     */
    public native final void setServerType(String serverType)/*-{
        this.serverType = serverType;
    }-*/;

    public native final void setLogo(String logo)/*-{
        this.logo = logo;
    }-*/;

    /**
     * Ratio. 1 means image requests are the size of the map viewport, 2 means twice the size of the map viewport, and so on. Default is 1.5.
     * @param ratio
     */
    public native final void setRatio(double ratio)/*-{
        this.ratio= ratio;
    }-*/;

    /** Resolutions. If specified, requests will be made for these resolutions only.
     *
     * @param resolutions
     */
    public native final void setResolutions(JsArrayNumber resolutions)/*-{
        this.resolutions = resolutions;
    }-*/;

    /** Set WMS service URL
     *
     * @param url
     */
    public native final void setUrl(String url)/*-{
        this.url = url;
    }-*/;

    /** WMS request parameters. At least a LAYERS param is required. STYLES is '' by default. VERSION is 1.3.0 by default. WIDTH, HEIGHT, BBOX and CRS (SRS for WMS version &lt; 1.3.0) will be set dynamically.
     *
     * @param params
     */
    public native final void setParams(JavaScriptObject params)/*-{
        this.params=params;
    }-*/;
}
