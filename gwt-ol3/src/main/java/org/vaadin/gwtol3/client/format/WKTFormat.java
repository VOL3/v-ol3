package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
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

    public static final native WKTFormat create(JavaScriptObject opts)/*-{
        return new $wnd.ol.format.WKT(opts);
    }-*/;


    public static final native WKTFormat create(boolean splitCollection)/*-{
        return new $wnd.ol.format.WKT({splitCollection: splitCollection});
    }-*/;

    public final native Feature readFeature(String WKTString)/*-{
        return this.readFeature(WKTString);
    }-*/;

    public final native Feature readFeature(String WKTString, String dataProjection, String featureProjection)/*-{
        return this.readFeature(WKTString,{dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

    public final native JsArray<Feature> readFeatures(String WKTString)/*-{
        return this.readFeatures(WKTString);
    }-*/;

    public final native JsArray<Feature> readFeatures(String WKTString, String dataProjection, String featureProjection)/*-{
        return this.readFeatures(WKTString, {dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

    public final native Geometry readGeometry(String WKTString)/*-{
        return this.readGeometry(WKTString);
    }-*/;

    public final native Geometry readGeometry(String WKTString, String dataProjection, String featureProjection)/*-{
        return this.readGeometry(WKTString,{featureProjection: featureProjection, dataProjection: dataProjection});
    }-*/;

    public final native String writeGeometry(Geometry geometry) /*-{
        return this.writeGeometry(geometry);
    }-*/;

    public final native String writeFeature(Feature feature)/*-{
        return this.writeFeature(feature);
    }-*/;

    public final native String writeFeature(Feature feature, String dataProjection, String featureProjection, boolean rightHanded, int decimals)/*-{
        return this.writeFeature(feature, {featureProjection: featureProjection, dataProjection: dataProjection, rightHanded: rightHanded, decimals: decimals});
    }-*/;

    public final native String writeFeatures(JsArray<Feature> features)/*-{
        return this.writeFeatures(features);
    }-*/;

    public final native String writeFeatures(JsArray<Feature> features, String dataProjection, String featureProjection, boolean rightHanded, int decimals)/*-{
        return this.writeFeatures(features, {featureProjection: featureProjection, dataProjection: dataProjection, rightHanded: rightHanded, decimals: decimals});
    }-*/;
}
