package org.vaadin.gwtol3.client.source;

/**
 * OSMXML layer data source
 */
public class OSMXMLSource extends StaticVectorSource{
    protected OSMXMLSource() {
    }

    public static final native OSMXMLSource create() /*-{
        return new $wnd.ol.source.OSMXML();
    }-*/;

    public static final native OSMXMLSource create(OSMXMLSourceOptions options) /*-{
        return new $wnd.ol.source.OSMXML(options);
    }-*/;

}
