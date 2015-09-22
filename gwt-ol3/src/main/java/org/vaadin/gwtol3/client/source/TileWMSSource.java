package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Tile WMS Source
 */
public class TileWMSSource extends TileImageSource {
    protected TileWMSSource() {
    }

    public static final native TileWMSSource create() /*-{
        return new $wnd.ol.source.TileWMS();
    }-*/;

    public static final native TileWMSSource create(TileWMSSourceOptions options) /*-{
        return new $wnd.ol.source.TileWMS(options);
    }-*/;

    /** Return the GetFeatureInfo URL for the passed coordinate, resolution, and projection. Return null if the GetFeatureInfo URL cannot be constructed.
     *
     * @param coordinate coordinate
     * @param resolution resolution
     * @param projection projection
     * @param params GetFeatureInfo params. INFO_FORMAT at least should be provided. If QUERY_LAYERS is not provided then the layers specified in the LAYERS parameter will be used. VERSION should not be specified here.
     * @return
     */
    public final native String getGetFeatureInfoUrl(Coordinate coordinate, double resolution, Projection projection, GetFeatureInfoOptions params)/*-{
        var url = this.getGetFeatureInfoUrl(coordinate,resolution, projection, params);
        if(typeof(url) == 'undefined'){
            return null;
        } else{
            return url;
        }
    }-*/;

    /** Get the user-provided params, i.e. those passed to the constructor through the "params" option, and possibly updated using the updateParams method
     *
     * @return
     */
    public final native JavaScriptObject getParams()/*-{
        return this.getParams();
    }-*/;

    /** Return the URLs used for this WMS source
     *
     * @return
     */
    public final native JsArrayString getUrls()/*-{
        return this.getUrls();
    }-*/;

    /** Update the user-provided params
     *
     * @param params
     */
    public final native void updateParams(JavaScriptObject params)/*-{
        this.updateParams(params);
    }-*/;

}
