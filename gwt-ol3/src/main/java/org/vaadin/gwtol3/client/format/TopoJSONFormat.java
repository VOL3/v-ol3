package org.vaadin.gwtol3.client.format;

/**
 * Reader/Writer for TopoJSON features
 */
public class TopoJSONFormat extends FeatureFormat{
    protected TopoJSONFormat() {
    }

    public static final native TopoJSONFormat create(String defaultProjection)/*-{
        return new $wnd.ol.format.TopoJSON({defaultProjection: defaultProjection});
    }-*/;
}
