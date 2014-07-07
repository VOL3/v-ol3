package org.vaadin.gwtol3.client.source;

/**
 * Created by mjhosio on 07/07/14.
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
