package org.vaadin.gwtol3.client.format;

/**
 * Created by mjhosio on 07/07/14.
 */
public class TopoJSONFormat extends FeatureFormat{
    protected TopoJSONFormat() {
    }

    public static final native TopoJSONFormat create(String defaultProjection)/*-{
        return new $wnd.ol.format.TopoJSON({defaultProjection: defaultProjection});
    }-*/;
}
