package org.vaadin.gwtol3.client.format;

/**
 * Created by mjhosio on 07/07/14.
 */
public class GPXFormat extends FeatureFormat{
    protected GPXFormat() {
    }

    public static final native GPXFormat create()/*-{
        return new $wnd.ol.format.GPX();
    }-*/;
}
