package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Reader/Writer for GPX features
 */
public class GPXFormat extends FeatureFormat{
    protected GPXFormat() {
    }

    public static final native GPXFormat create()/*-{
        return new $wnd.ol.format.GPX();
    }-*/;

    public static final native GPXFormat create(JavaScriptObject opts)/*-{
        return new $wnd.ol.format.GPX(opts);
    }-*/;


    public final native Feature readFeature(String GPXString, String dataProjection, String featureProjection)/*-{
        return this.readFeature(GPXString,{dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

    public final native JsArray<Feature> readFeatures(String GPXString)/*-{
        return this.readFeatures(GPXString);
    }-*/;

    public final native JsArray<Feature> readFeatures(String GPXString, String dataProjection, String featureProjection)/*-{
        return this.readFeatures(GPXString, {dataProjection: dataProjection, featureProjection: featureProjection});
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

    public final native Projection readProjection(String GPXString)/*-{
        return this.readProjection(GPXString);
    }-*/;
}
