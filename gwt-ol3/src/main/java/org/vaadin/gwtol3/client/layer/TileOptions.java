package org.vaadin.gwtol3.client.layer;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.source.Source;

/**
 * Created by mjhosio on 02/07/14.
 */
public class TileOptions extends JavaScriptObject {
    protected TileOptions() {
    }


    /**
     * Initializes Tile options. Basically a simple map wrapper that can be passed to Tile on initialization
     */
    public static native TileOptions create()
    /*-{
        return {};
    }-*/;

    public final native void setPreload(int numberOfTiles)/*-{
        this.preload=numberOfTiles;
    }-*/;

    public final native void setUseInterimTilesOnError(boolean enabled)/*-{
        this.useInterimTilesOnError = enabled;
    }-*/;

    public final native void setSource(Source source)/*-{
        this.source=source;
    }-*/;
}
