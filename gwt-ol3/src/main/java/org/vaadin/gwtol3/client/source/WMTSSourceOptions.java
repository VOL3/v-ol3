package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JsArrayString;
import org.vaadin.gwtol3.client.tilegrid.WMTSTileGrid;

/**
 * Created by mjhosio on 23/02/15.
 */
public class WMTSSourceOptions extends TileImageSourceOptions{
	protected WMTSSourceOptions() {
	}

	public static native final WMTSSourceOptions create()/*-{
        return {};
    }-*/;

	/** Set WMTS service URL
	 *
	 * @param url
	 */
	public native final void setUrl(String url)/*-{
        this.url = url;
    }-*/;

	/** WMTS service urls. Use this instead of url when the WMTS supports multiple urls for map requests.
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

	/** Sets the tilegrid
	 *
	 * @param tileGrid
	 */
	public native final void setTileGrid(WMTSTileGrid tileGrid)/*-{
        this.tileGrid = tileGrid;
    }-*/;

	/** Sets the request encoding (KVP, REST)
	 *
	 * @param requestEncoding
	 */
	public native final void setRequestEncoding(String requestEncoding)/*-{
        this.requestEncoding = requestEncoding;
    }-*/;

	/** Sets the layer parameter
	 *
	 * @param layer
	 */
	public native final void setLayer(String layer)/*-{
        this.layer = layer;
    }-*/;

	/** Sets the style parameter
	 *
	 * @param style
	 */
	public native final void setStyle(String style)/*-{
        this.style = style;
    }-*/;

	/** Sets the WMTS version parameter
	 *
	 * @param version
	 */
	public native final void setVersion(String version)/*-{
        this.version = version;
    }-*/;

	/** Sets the image format
	 *
	 * @param format
	 */
	public native final void setFormat(String format)/*-{
        this.format = format;
    }-*/;

	/** Sets the matrix set
	 *
	 * @param matrixSet
	 */
	public native final void setMatrixSet(String matrixSet)/*-{
        this.matrixSet = matrixSet;
    }-*/;

	/** Whether to wrap the world horizontally. Default false.
	 *
	 * @param wrapX if true, the world will be wrapped horizontally
	 */
	public native final void setWrapX(boolean wrapX)/*-{
		this.wrapX=wrapX;
	}-*/;
}
