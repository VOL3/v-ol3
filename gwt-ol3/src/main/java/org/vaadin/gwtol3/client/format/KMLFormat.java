package org.vaadin.gwtol3.client.format;

/**
 * Reader/Writer for KML features
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
