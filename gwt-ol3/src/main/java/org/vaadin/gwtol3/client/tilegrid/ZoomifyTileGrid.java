package org.vaadin.gwtol3.client.tilegrid;

import com.google.gwt.core.client.JsArrayNumber;

/**
 * Grid pattern for sources accessing Zoomify tiled-image servers
 */
public class ZoomifyTileGrid extends TileGrid{
    protected ZoomifyTileGrid() {
    }

    public static final native ZoomifyTileGrid create()/*-{
        return new $wnd.ol.tilegrid.Zoomify();
    }-*/;

    public static final native ZoomifyTileGrid create(JsArrayNumber resolutions)/*-{
        return new $wnd.ol.tilegrid.Zoomify({resolutions : resolutions});
    }-*/;
}
