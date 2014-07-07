package org.vaadin.gwtol3.client.source;

/**
 * Static vector source in GPX format
 * Created by mjhosio on 07/07/14.
 */
public class GPXSource extends StaticVectorSource{
    protected GPXSource() {
    }

    public static final native GPXSource create() /*-{
        return new $wnd.ol.source.GPX();
    }-*/;

    public static final native GPXSource create(GPXSourceOptions options) /*-{
        return new $wnd.ol.source.GPX(options);
    }-*/;
}
