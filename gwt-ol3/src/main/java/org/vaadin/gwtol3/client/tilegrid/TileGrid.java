package org.vaadin.gwtol3.client.tilegrid;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
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

    public final native Double getMaxZoom()/*-{
        var res = this.getMaxZoom();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public final native Coordinate getOrigin()/*-{
        return this.getOrigin();
    }-*/;

    public final native Double getResolution(int number)/*-{
		var res = this.getResolution(number);
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public final native JsArrayNumber getResolutions()/*-{
        return this.getResolutions();
    }-*/;

    public final native Double getTileSize(int number)/*-{
        var res = this.getTileSize(number);
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;


}
