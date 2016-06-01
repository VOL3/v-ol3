package org.vaadin.gwtol3.client.source;

/**
 * Created by Martin Stypinski 20/03/2016
 */
public class BingSource extends TileImageSource{

    protected BingSource() {
    }

    public static final native BingSource create()
    /*-{
        return new $wnd.ol.source.BingMaps();
    }-*/;

    public static final native BingSource create(BingSourceOptions options)
    /*-{
        return new $wnd.ol.source.BingMaps(options);
    }-*/;
}
