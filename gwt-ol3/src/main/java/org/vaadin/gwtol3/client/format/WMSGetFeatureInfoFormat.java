package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import org.vaadin.gwtol3.client.feature.Feature;

/**
 * Created by Vaadin Ltd / mjhosio on 02/06/16.
 */
public class WMSGetFeatureInfoFormat extends XMLFeatureFormat {
	protected WMSGetFeatureInfoFormat() {
	}

	public static final native WKTFormat create()/*-{
        return new $wnd.ol.format.WMSGetFeatureInfo();
    }-*/;

	public static final native WKTFormat create(JsArrayString layers)/*-{
        return new $wnd.ol.format.WMSGetFeatureInfo({layers: layers});
    }-*/;

	public final native JsArray<Feature> readFeatures(String featureInfoString)/*-{
        return this.readFeatures(featureInfoString);
    }-*/;

	public final native JsArray<Feature> readFeatures(String featureInfoString, String dataProjection, String featureProjection)/*-{
        return this.readFeatures(featureInfoString, {dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;
}
