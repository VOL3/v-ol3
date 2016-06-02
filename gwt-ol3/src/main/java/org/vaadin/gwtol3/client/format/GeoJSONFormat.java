package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.geom.Geometry;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Reader / Writer for GeoJSON features / Geometries
 */
public class GeoJSONFormat extends JSONFeatureFormat{
    protected GeoJSONFormat() {
    }

    public static final native GeoJSONFormat create()/*-{
        return new $wnd.ol.format.GeoJSON();
    }-*/;

    public static final native GeoJSONFormat create(String defaultProjection)/*-{
        return new $wnd.ol.format.GeoJSON({defaultDataProjection: defaultProjection});
    }-*/;

    public static final native GeoJSONFormat create(String defaultProjection, String geometryName)/*-{
        return new $wnd.ol.format.GeoJSON({defaultDataProjection: defaultProjection, geometryName: geometryName});
    }-*/;

    public final native Feature readFeature(String geoJSONString)/*-{
        return this.readFeature(geoJSONString);
    }-*/;

    public final native Feature readFeature(String geoJSONString, String dataProjection, String featureProjection)/*-{
        return this.readFeature(geoJSONString,{dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

    public final native JsArray<Feature> readFeatures(String geoJSONString)/*-{
        return this.readFeatures(geoJSONString);
    }-*/;

    public final native JsArray<Feature> readFeatures(String geoJSONString, String dataProjection, String featureProjection)/*-{
        return this.readFeatures(geoJSONString, {dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;


    public final native Projection readProjection(String geoJSONString)/*-{
        return this.readProjection(geoJSONString);
    }-*/;

    public final native Geometry readGeometry(String geoJSONString)/*-{
        return this.readGeometry(geoJSONString);
    }-*/;


    public final native Geometry readGeometry(String geoJSONString, String dataProjection, String featureProjection)/*-{
        return this.readGeometry(geoJSONString,{featureProjection: featureProjection, dataProjection: dataProjection});
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

    public final native String writeGeometry(Geometry geometry, String featureProjection, String dataProjection)/*-{
        return this.writeGeometry(geometry,{featureProjection: featureProjection, dataProjection: dataProjection});
    }-*/;

    public final native String writeGeometry(Geometry geometry, String featureProjection, String dataProjection, boolean rightHanded, int decimals)/*-{
        return this.writeGeometry(geometry,{featureProjection: featureProjection, dataProjection: dataProjection, rightHanded: rightHanded, decimals:decimals});
    }-*/;

}
