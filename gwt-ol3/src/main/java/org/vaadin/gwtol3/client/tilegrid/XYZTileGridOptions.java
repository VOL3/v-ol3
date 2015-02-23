package org.vaadin.gwtol3.client.tilegrid;

import org.vaadin.gwtol3.client.Extent;

/**
 * Created by mjhosio on 23/02/15.
 */
public class XYZTileGridOptions extends TileGridOptions {
	protected XYZTileGridOptions(){
	}

	public static final native XYZTileGridOptions create()/*-{
        return {};
    }-*/;

	public final native void setExtent(Extent extent)/*-{
        this.extent = extent;
    }-*/;
}
