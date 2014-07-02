package org.vaadin.gwtol3.client.source;

import org.vaadin.gwtol3.client.Attribution;

/**
 * Layer source for the OpenStreetMap tile server
 * Created by mjhosio on 02/07/14.
 */
public class OSMSource extends XYZSource {
    protected OSMSource() {
    }

    public static final native OSMSource create() /*-{
        return new $wnd.ol.source.OSM();
    }-*/;

    public static final native OSMSource create(OSMSourceOptions options) /*-{
        return new $wnd.ol.source.OSM(options);
    }-*/;

    public static final native Attribution createDataAttribution() /*-{
        return $wnd.ol.source.OSM.DATA_ATTRIBUTION;
    }-*/;

    public static final native Attribution createTileAttribution() /*-{
        return $wnd.ol.source.OSM.TILE_ATTRIBUTION;
    }-*/;
}
