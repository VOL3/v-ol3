package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;

/**
 * Created by Vaadin Ltd / mjhosio on 02/06/16.
 */
public class GMLBaseFormat extends XMLFeatureFormat {
	protected GMLBaseFormat() {
	}

	public final native JsArray<Feature> readFeatures(String GMLString, String dataProjection, String featureProjection)/*-{
        return this.readFeatures(GMLString, {dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

	public final native JsArray<Feature> readFeatures(String GMLString)/*-{
        return this.readFeatures(GMLString);
    }-*/;

	public final native String writeFeatures(JsArray<Feature> features)/*-{
        return this.writeFeatures(features);
    }-*/;

	public final native String writeFeatures(JsArray<Feature> features, String dataProjection, String featureProjection, boolean rightHanded, int decimals)/*-{
        return this.writeFeatures(features, {featureProjection: featureProjection, dataProjection: dataProjection, rightHanded: rightHanded, decimals: decimals});
    }-*/;
}
