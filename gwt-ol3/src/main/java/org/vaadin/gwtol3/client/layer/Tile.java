package org.vaadin.gwtol3.client.layer;

import org.vaadin.gwtol3.client.source.Source;

/**
 * Created by mjhosio on 24/06/14.
 */
public class Tile extends Layer{

    protected Tile() {
    }

    public static native Tile create(Source src)
    /*-{
        return new $wnd.ol.layer.Tile({source: src});
    }-*/;

    public static native Tile create(TileOptions options)
    /*-{
        return new $wnd.ol.layer.Tile(options);
    }-*/;

}
