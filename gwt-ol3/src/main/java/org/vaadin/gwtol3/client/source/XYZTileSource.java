package org.vaadin.gwtol3.client.source;

import org.vaadin.gwtol3.client.Attribution;

/**
 * Layer source for the OpenStreetMap tile server
 */
public class XYZTileSource extends XYZSource {
    protected XYZTileSource() {
    }

    public static final native XYZTileSource create() /*-{
        return new $wnd.ol.source.XYZ();
    }-*/;

    public static final native XYZTileSource create(XYZTileSourceOptions options) /*-{
        return new $wnd.ol.source.XYZ(options);
    }-*/;

    public static final native Attribution createTileOSMAttribution() /*-{
        return $wnd.ol.source.XYZ.ATTRIBUTION;
    }-*/;
}
