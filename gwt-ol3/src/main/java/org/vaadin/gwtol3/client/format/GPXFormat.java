package org.vaadin.gwtol3.client.format;

/**
 * Reader/Writer for GPX features
 */
public class GPXFormat extends FeatureFormat{
    protected GPXFormat() {
    }

    public static final native GPXFormat create()/*-{
        return new $wnd.ol.format.GPX();
    }-*/;
}
