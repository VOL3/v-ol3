package org.vaadin.gwtol3.client.format;

/**
 * Created by mjhosio on 07/07/14.
 */
public class GeoJSONFormat extends FeatureFormat{
    protected GeoJSONFormat() {
    }

    public static final native GeoJSONFormat create(String defaultProjection)/*-{
        return new $wnd.ol.format.GeoJSON({defaultProjection: defaultProjection});
    }-*/;

    public static final native GeoJSONFormat create(String defaultProjection, String geometryName)/*-{
        return new $wnd.ol.format.GeoJSON({defaultProjection: defaultProjection, geometryName: geometryName});
    }-*/;

}
