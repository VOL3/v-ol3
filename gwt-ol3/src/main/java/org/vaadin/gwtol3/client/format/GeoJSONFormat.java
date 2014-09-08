package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.geom.Geometry;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Reader / Writer for GeoJSON features / Geometries
 */
public class GeoJSONFormat extends FeatureFormat{
    protected GeoJSONFormat() {
    }

    public static final native GeoJSONFormat create()/*-{
        return new $wnd.ol.format.GeoJSON();
    }-*/;

    public static final native GeoJSONFormat create(String defaultProjection)/*-{
        return new $wnd.ol.format.GeoJSON({defaultProjection: defaultProjection});
    }-*/;

    public static final native GeoJSONFormat create(String defaultProjection, String geometryName)/*-{
        return new $wnd.ol.format.GeoJSON({defaultProjection: defaultProjection, geometryName: geometryName});
    }-*/;

    public final native Geometry readGeometry(String geoJSONString, String dataProjection, String featureProjection)/*-{
        return this.readGeometry(geoJSONString,{featureProjection: featureProjection, dataProjection: dataProjection});
    }-*/;

    public final native Feature readFeature(String geoJSONString)/*-{
        return this.readFeature(geoJSONString);
    }-*/;

    public final native JsArray<Feature> readFeatures(String geoJSONString)/*-{
        return this.readFeatures(geoJSONString);
    }-*/;

    public final native Projection readProjection(String geoJSONString)/*-{
        return this.readProjection(geoJSONString);
    }-*/;

    public final native String writeFeature(Feature feature)/*-{
        return this.writeFeature(feature);
    }-*/;

    public final native String writeFeatures(JsArray<Feature> features)/*-{
        return this.writeFeatures(features);
    }-*/;

    public final native String writeGeometry(Geometry geometry, String featureProjection, String dataProjection)/*-{
        return JSON.stringify(this.writeGeometry(geometry,{featureProjection: featureProjection, dataProjection: dataProjection}));
    }-*/;

}
