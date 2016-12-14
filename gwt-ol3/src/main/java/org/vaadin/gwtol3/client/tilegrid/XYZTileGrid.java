package org.vaadin.gwtol3.client.tilegrid;

/**
 * Set the grid pattern for sources accessing XYZ tiled-image servers
 */
public class XYZTileGrid extends TileGrid {
    protected XYZTileGrid() {
    }

    public static final native XYZTileGrid create()/*-{
        return new $wnd.ol.tilegrid.TileGrid();
    }-*/;

    public static final native XYZTileGrid create(XYZTileGridOptions options)/*-{
        return new $wnd.ol.tilegrid.TileGrid(options);
    }-*/;


    public static final native XYZTileGrid create(double maxZoom)/*-{
        return new $wnd.ol.tilegrid.XYZ({maxZoom: maxZoom});
    }-*/;

}
