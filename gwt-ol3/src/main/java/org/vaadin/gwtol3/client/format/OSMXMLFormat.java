package org.vaadin.gwtol3.client.format;

/**
 * Created by mjhosio on 07/07/14.
 */
public class OSMXMLFormat extends FeatureFormat {
    protected OSMXMLFormat() {
    }

    public static final native OSMXMLFormat create()/*-{
        return new $wnd.ol.format.OSMXML();
    }-*/;

}
