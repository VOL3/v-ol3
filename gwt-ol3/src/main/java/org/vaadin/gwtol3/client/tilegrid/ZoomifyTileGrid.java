package org.vaadin.gwtol3.client.tilegrid;

import com.google.gwt.core.client.JsArrayNumber;

/**
 * Grid pattern for sources accessing Zoomify tiled-image servers
 * Created by mjhosio on 07/07/14.
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
