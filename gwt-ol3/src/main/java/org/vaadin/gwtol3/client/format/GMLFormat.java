package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Reader/Writer for GML features
 */
public class GMLFormat extends GMLBaseFormat{
    protected GMLFormat() {
    }

    public static final native GMLFormat create()/*-{
        return new $wnd.ol.format.GML();
    }-*/;

    public static final native GMLFormat create(JavaScriptObject opts)/*-{
        return new $wnd.ol.format.GML(opts);
    }-*/;

    public static final native GMLFormat create(GMLFormatOptions options)/*-{
        return new $wnd.ol.format.GML(options);
    }-*/;
}
