package org.vaadin.gwtol3.client.tilegrid;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import org.vaadin.gwtol3.client.Coordinate;

/**
 * Base class for tilegrid options
 */
public class TileGridOptions extends JavaScriptObject {

	protected TileGridOptions(){
	}

	public final native void setMinZoom(double minZoom)/*-{
        this.minZoom = minZoom;
    }-*/;

	public final native void setMaxZoom(double maxZoom)/*-{
        this.maxZoom = maxZoom;
    }-*/;

	public final native void setOrigin(Coordinate origin)/*-{
        this.origin=origin;
    }-*/;

	public final native void setOrigins(JsArray<Coordinate> origins)/*-{
        this.origins=origins;
    }-*/;

	public final native void setResolutions(JsArrayNumber resolutions)/*-{
        this.resolutions=resolutions;
    }-*/;

	public final native void setTileSize(double tileSize)/*-{
        this.tileSize=tileSize;
    }-*/;

	public final native void setTileSizes(JsArrayNumber tileSizes)/*-{
        this.tileSizes=tileSizes;
    }-*/;
}
