package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.tilegrid.TileGrid;

/**
 * Created by mjhosio on 23/02/15.
 */
public class TileImageSourceOptions extends JavaScriptObject {

	protected TileImageSourceOptions() {
	}

	public native final void setAttributions(JsArray<Attribution> attributions)/*-{
        this.attributions = attributions;
    }-*/;

	public native final void setCrossOrigin(String crossOrigin)/*-{
        this.crossOrigin = crossOrigin;
    }-*/;

	public native final void setLogo(String logo)/*-{
        this.logo = logo;
    }-*/;

	public native final void setOpaque(boolean opaque)/*-{
        this.opaque = opaque;
    }-*/;

    public native final void setProjection(String projection)/*-{
        this.projection = projection;
    }-*/;

    public native final void setState(String state)/*-{
        this.state = state;
    }-*/;

    public native final void setTileGrid(TileGrid tileGrid)/*-{
        this.tileGrid = tileGrid;
    }-*/;

    public native final void setTilePixelRation(double pixelRatio)/*-{
        this.tilePixelRatio = pixelRatio;
    }-*/;
}
