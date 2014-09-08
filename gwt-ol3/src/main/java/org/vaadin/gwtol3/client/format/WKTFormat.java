package org.vaadin.gwtol3.client.format;

/**
 * Reader/Writer for WKT features
 */
public class WKTFormat extends FeatureFormat{
    protected WKTFormat() {
    }

    public static final native WKTFormat create()/*-{
        return new $wnd.ol.format.WKT();
    }-*/;

    public static final native WKTFormat create(boolean splitCollection)/*-{
        return new $wnd.ol.format.WKT({splitCollection: splitCollection});
    }-*/;
}
