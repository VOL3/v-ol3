package org.vaadin.gwtol3.client.tilegrid;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Coordinate;

/**
 * Base class for setting the grid pattern for sources accessing tiled-image servers
 * Created by mjhosio on 07/07/14.
 */
public class TileGrid extends JavaScriptObject{

    protected TileGrid() {
    }

    public final native double getMinZoom()/*-{
        return this.getMinZoom();
    }-*/;

    public final native Coordinate getOrigin(double z)/*-{
        return this.getOrigin();
    }-*/;

    public final native double getResolution(double z)/*-{
        return this.getResolution();
    }-*/;

    public final native double getTileSize()/*-{
        return this.getTileSize();
    }-*/;


}
