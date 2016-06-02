package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Reader/Writer for IGC features
 */
public class IGCFormat extends TextFeatureFormat{
    protected IGCFormat() {
    }

    public static final native IGCFormat create()/*-{
        return new $wnd.ol.format.IGC();
    }-*/;

    public static final native IGCFormat create(String altitudeMode)/*-{
        return new $wnd.ol.format.IGC({altitudeMode: altitudeMode});
    }-*/;

    public final native Feature readFeature(String IGCString)/*-{
        return this.readFeature(IGCString);
    }-*/;

    public final native Feature readFeature(String IGCString, String dataProjection, String featureProjection)/*-{
        return this.readFeature(IGCString,{dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

    public final native JsArray<Feature> readFeatures(String IGCString)/*-{
        return this.readFeatures(IGCString);
    }-*/;

    public final native JsArray<Feature> readFeatures(String IGCString, String dataProjection, String featureProjection)/*-{
        return this.readFeatures(IGCString, {dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;


    public final native Projection readProjection(String IGCString)/*-{
        return this.readProjection(IGCString);
    }-*/;


}
