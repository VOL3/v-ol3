package org.vaadin.gwtol3.client.format;

/**
 * Created by mjhosio on 07/07/14.
 */
public class GMLFormat extends FeatureFormat {
    protected GMLFormat() {
    }

    public static final native GMLFormat create()/*-{
        return new $wnd.ol.format.GML();
    }-*/;

    public static final native GMLFormat create(GMLFormatOptions options)/*-{
        return new $wnd.ol.format.GML(options);
    }-*/;
}
