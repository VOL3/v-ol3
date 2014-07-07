package org.vaadin.gwtol3.client.format;

/**
 * Created by mjhosio on 07/07/14.
 */
public class KMLFormat extends FeatureFormat{
    protected KMLFormat() {
    }

    public static final native KMLFormat create()/*-{
        return new $wnd.ol.format.KML();
    }-*/;

    public static final native KMLFormat create(String defaultStyle)/*-{
        return new $wnd.ol.format.KML({defaultStyle: defaultStyle});
    }-*/;

}
