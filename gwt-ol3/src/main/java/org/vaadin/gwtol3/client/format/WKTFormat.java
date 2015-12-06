package org.vaadin.gwtol3.client.format;

import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.geom.Geometry;

/**
 * Reader/Writer for WKT features
 */
public class WKTFormat extends FeatureFormat{
    protected WKTFormat() {
    }

    public static final native WKTFormat create()/*-{
        return new $wnd.ol.format.WKT();
    }-*/;

    public static final native WKTFormat create(boolean splitCollection)/*-{
        return new $wnd.ol.format.WKT({splitCollection: splitCollection});
    }-*/;
    
    public final native Geometry readGeometry(String wktString, String dataProjection, String featureProjection)/*-{
        return this.readGeometry(wktString,{featureProjection: featureProjection, dataProjection: dataProjection});
    }-*/;
    
    public final native String writeGeometry(Geometry geometry, String dataProjection, String featureProjection) /*-{
        return this.writeGeometry(geometry, {featureProjection: featureProjection, dataProjection: dataProjection});
    }-*/;
    
    public final native String writeGeometry(Geometry geometry) /*-{
        return this.writeGeometry(geometry);
    }-*/;

    public final native Feature readFeature(String wktString)/*-{
        return this.readFeature(wktString);
    }-*/;
    
    public final native String writeFeature(Feature feature, String dataProjection, String featureProjection) /*-{
        return this.writeFeature(feature, {featureProjection: featureProjection, dataProjection: dataProjection});
    }-*/;
}
