package org.vaadin.gwtol3.client.source;

/**
 * Static vector source in GeoJSON format
 */
public class GeoJSONSource extends StaticVectorSource{
    protected GeoJSONSource() {
    }

    public static final native GeoJSONSource create() /*-{
        return new $wnd.ol.source.GeoJSON();
    }-*/;

    public static final native GeoJSONSource create(GeoJSONSourceOptions options) /*-{
        return new $wnd.ol.source.GeoJSON(options);
    }-*/;
}
