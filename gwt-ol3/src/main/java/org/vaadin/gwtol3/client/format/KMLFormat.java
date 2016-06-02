package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.proj.Projection;
import org.vaadin.gwtol3.client.style.Style;

/**
 * Reader/Writer for KML features
 */
public class KMLFormat extends XMLFeatureFormat{
    protected KMLFormat() {
    }

    public static final native KMLFormat create()/*-{
        return new $wnd.ol.format.KML();
    }-*/;

    public static final native KMLFormat create(boolean extractStyles, boolean showPointNames)/*-{
        return new $wnd.ol.format.KML({extractStyles: extractStyles, showPointNames: showPointNames});
    }-*/;

    public static final native KMLFormat create(boolean extractStyles, boolean showPointNames, JsArray<Style> defaultStyle, boolean writeStyles)/*-{
        return new $wnd.ol.format.KML({extractStyles: extractStyles, showPointNames: showPointNames, defaultStyle: defaultStyle, writeStyles: writeStyles});
    }-*/;


    public final native Feature readFeature(String KMLString)/*-{
        return this.readFeature(KMLString);
    }-*/;

    public final native Feature readFeature(String KMLString, String dataProjection, String featureProjection)/*-{
        return this.readFeature(KMLString,{dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

    public final native JsArray<Feature> readFeatures(String KMLString)/*-{
        return this.readFeatures(KMLString);
    }-*/;

    public final native JsArray<Feature> readFeatures(String KMLString, String dataProjection, String featureProjection)/*-{
        return this.readFeatures(KMLString, {dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

    public final native String readName(String KMLString)/*-{
        return this.readName(KMLString);
    }-*/;

    public final native Projection readProjection(String KMLString)/*-{
        return this.readProjection(KMLString);
    }-*/;

    public final native String writeFeatures(JsArray<Feature> features)/*-{
        return this.writeFeatures(features);
    }-*/;

    public final native String writeFeatures(JsArray<Feature> features, String dataProjection, String featureProjection, boolean rightHanded, int decimals)/*-{
        return this.writeFeatures(features, {featureProjection: featureProjection, dataProjection: dataProjection, rightHanded: rightHanded, decimals: decimals});
    }-*/;

}
