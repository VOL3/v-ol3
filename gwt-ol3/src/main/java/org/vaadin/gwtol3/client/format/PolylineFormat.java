package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.geom.Geometry;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Reader/Writer for Polyline features
 */
public class PolylineFormat extends TextFeatureFormat{
    protected PolylineFormat() {
    }

    public static final native PolylineFormat create()/*-{
        return new $wnd.ol.format.Polyline();
    }-*/;

    public static final native PolylineFormat create(JavaScriptObject opts)/*-{
        return new $wnd.ol.format.Polyline(opts);
    }-*/;


    /** creates a new polyline format
     *
     * @param factor The factor by which the coordinates values will be scaled. Default is 1e5
     * @return
     */
    public static final native PolylineFormat create(double factor)/*-{
        return new $wnd.ol.format.Polyline({factor: factor});
    }-*/;

	/**
     * creates a new polyline format
     * @param factor The factor by which the coordinates values will be scaled. Default is 1e5
     * @param geometryLayout Layout of the feature geometries created by the format reader. Default is XY
     * @return
     */
    public static final native PolylineFormat create(double factor, String geometryLayout)/*-{
        return new $wnd.ol.format.Polyline({factor: factor, geometryLayout: geometryLayout});
    }-*/;


    public final native Feature readFeature(String polylineString)/*-{
        return this.readFeature(polylineString);
    }-*/;

    public final native Feature readFeature(String polylineString, String dataProjection, String featureProjection)/*-{
        return this.readFeature(polylineString,{dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

    public final native JsArray<Feature> readFeatures(String polylineString)/*-{
        return this.readFeatures(polylineString);
    }-*/;

    public final native JsArray<Feature> readFeatures(String polylineString, String dataProjection, String featureProjection)/*-{
        return this.readFeatures(polylineString, {dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;


    public final native Projection readProjection(String polylineString)/*-{
        return this.readProjection(polylineString);
    }-*/;

    public final native Geometry readGeometry(String polylineString)/*-{
        return this.readGeometry(polylineString);
    }-*/;


    public final native Geometry readGeometry(String polylineString, String dataProjection, String featureProjection)/*-{
        return this.readGeometry(polylineString,{featureProjection: featureProjection, dataProjection: dataProjection});
    }-*/;

    public final native String writeGeometry(Geometry geometry)/*-{
        return this.writeGeometry(geometry);
    }-*/;

    public final native String writeGeometry(Geometry geometry, String featureProjection, String dataProjection, boolean rightHanded, int decimals)/*-{
        return this.writeGeometry(geometry,{featureProjection: featureProjection, dataProjection: dataProjection, rightHanded: rightHanded, decimals:decimals});
    }-*/;

}
