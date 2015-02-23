package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.tilegrid.TileGrid;

/**
 * Options for the TileWMSSource
 */
public class TileWMSSourceOptions extends JavaScriptObject{

    protected TileWMSSourceOptions() {
    }

    public static native final TileWMSSourceOptions create()/*-{
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

    /** The type of the remote WMS server. Currently only used when hidpi is true.
     *
     * @param serverType the type of the server
     */
    public native final void setServerType(String serverType)/*-{
        this.serverType = serverType;
    }-*/;

    public native final void setLogo(String logo)/*-{
        this.logo = logo;
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
        this.params = params;
    }-*/;

    /** The size in pixels of the gutter around image tiles to ignore. By setting this property to a non-zero value, images will be requested that are wider and taller than the tile size by a value of 2 x gutter. Defaults to zero. Using a non-zero value allows artifacts of rendering at tile edges to be ignored. If you control the WMS service it is recommended to address "artifacts at tile edges" issues by properly configuring the WMS service. For example, MapServer has a tile_map_edge_buffer configuration parameter for this. See http://mapserver.org/output/tile_mode.html.
     *
      * @param gutter
     */
    public native final void setGutter(double gutter)/*-{
        this.gutter = gutter;
    }-*/;

    /** WMS service urls. Use this instead of url when the WMS supports multiple urls for GetMap requests.
     *
     * @param urls
     */
    public native final void setUrls(JsArrayString urls)/*-{
        this.urls = urls;
    }-*/;

    /** Sets the maximum zoom
     *
     * @param maxZoom
     */
    public native final void setMaxZoom(double maxZoom)/*-{
        this.maxZoom = maxZoom;
    }-*/;
    
    public native final void setTileGrid(TileGrid tileGrid)/*-{
    	this.tileGrid = tileGrid;
	}-*/;
    
}
