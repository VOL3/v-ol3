package org.vaadin.gwtol3.client.source;

/**
 * Options passed to Open Street Map source on creation
 */
public class XYZTileSourceOptions extends TileImageSourceOptions {

    protected XYZTileSourceOptions() {
    }

    public static native final XYZTileSourceOptions create()/*-{
        return {};
    }-*/;

    /** Sets the max zoom level for the source
     *
     * @param maxZoom maximum zoom level
     */
    public final native void setMaxZoom(int maxZoom)/*-{
        this.maxZoom = maxZoom;
    }-*/;

    public final native void setUrl(String url) /*-{
        this.url = url;
    }-*/;
}
