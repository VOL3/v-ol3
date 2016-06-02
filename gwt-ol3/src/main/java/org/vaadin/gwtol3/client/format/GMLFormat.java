package org.vaadin.gwtol3.client.format;

/**
 * Reader/Writer for GML features
 */
public class GMLFormat extends GMLBaseFormat{
    protected GMLFormat() {
    }

    public static final native GMLFormat create()/*-{
        return new $wnd.ol.format.GML();
    }-*/;

    public static final native GMLFormat create(GMLFormatOptions options)/*-{
        return new $wnd.ol.format.GML(options);
    }-*/;
}
