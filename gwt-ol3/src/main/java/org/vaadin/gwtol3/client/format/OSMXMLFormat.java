package org.vaadin.gwtol3.client.format;

/**
 * Reader/Writer for OSMXML features
 */
public class OSMXMLFormat extends FeatureFormat {
    protected OSMXMLFormat() {
    }

    public static final native OSMXMLFormat create()/*-{
        return new $wnd.ol.format.OSMXML();
    }-*/;

}
