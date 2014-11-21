package org.vaadin.gwtol3.client.tilegrid;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Coordinate;

/**
 * Base class for setting the grid pattern for sources accessing tiled-image servers
 */
public class TileGrid extends JavaScriptObject{

    protected TileGrid() {
    }

    public final native Double getMinZoom()/*-{
		var res = this.getMinZoom();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public final native Coordinate getOrigin(double z)/*-{
        return this.getOrigin();
    }-*/;

    public final native Double getResolution(double z)/*-{
		var res = this.getResolution();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public final native Double getTileSize()/*-{
        var res = this.getTileSize();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;


}
