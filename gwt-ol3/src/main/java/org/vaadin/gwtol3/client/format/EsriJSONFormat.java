package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.geom.Geometry;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Created by Vaadin Ltd / mjhosio on 02/06/16.
 */
public class EsriJSONFormat extends JSONFeatureFormat {

	protected EsriJSONFormat() {
	}

	public static final native EsriJSONFormat create()/*-{
        return new $wnd.ol.format.EsriJSON();
    }-*/;

	public static final native EsriJSONFormat create(JavaScriptObject opts)/*-{
        return new $wnd.ol.format.EsriJSON(opts);
    }-*/;

	public static final native EsriJSONFormat create(String geometryName)/*-{
        return new $wnd.ol.format.EsriJSON({geometryName: geometryName});
    }-*/;

	public final native Feature readFeature(String esriJSONString)/*-{
        return this.readFeature(esriJSONString);
    }-*/;

	public final native Feature readFeature(String esriJSONString, String dataProjection, String featureProjection)/*-{
        return this.readFeature(esriJSONString,{dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

	public final native JsArray<Feature> readFeatures(String esriJSONString)/*-{
        return this.readFeatures(esriJSONString);
    }-*/;

	public final native JsArray<Feature> readFeatures(String esriJSONString, String dataProjection, String featureProjection)/*-{
        return this.readFeatures(esriJSONString, {dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;


	public final native Projection readProjection(String esriJSONString)/*-{
        return this.readProjection(esriJSONString);
    }-*/;

	public final native Geometry readGeometry(String esriJSONString)/*-{
        return this.readGeometry(esriJSONString);
    }-*/;


	public final native Geometry readGeometry(String esriJSONString, String dataProjection, String featureProjection)/*-{
        return this.readGeometry(esriJSONString,{featureProjection: featureProjection, dataProjection: dataProjection});
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

	public final native String writeGeometry(Geometry geometry)/*-{
        return this.writeGeometry(geometry);
    }-*/;

	public final native String writeGeometry(Geometry geometry, String featureProjection, String dataProjection, boolean rightHanded, int decimals)/*-{
        return this.writeGeometry(geometry,{featureProjection: featureProjection, dataProjection: dataProjection, rightHanded: rightHanded, decimals:decimals});
    }-*/;


}
