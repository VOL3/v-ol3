package org.vaadin.gwtol3.client.source;

import org.vaadin.gwtol3.client.Attribution;

/**
 * Layer source for the OpenStreetMap tile server
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

    public static final native Attribution createOSMAttribution() /*-{
        return $wnd.ol.source.OSM.ATTRIBUTION;
    }-*/;
}
