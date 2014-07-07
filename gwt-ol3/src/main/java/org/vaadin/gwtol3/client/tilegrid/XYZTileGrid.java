package org.vaadin.gwtol3.client.tilegrid;

/**
 * Set the grid pattern for sources accessing XYZ tiled-image servers
 * Created by mjhosio on 07/07/14.
 */
public class XYZTileGrid extends TileGrid {
    protected XYZTileGrid() {
    }

    public static final native XYZTileGrid create(double maxZoom)/*-{
        return new $wnd.ol.tilegrid.XYZ({maxZoom: maxZoom});
    }-*/;

}
