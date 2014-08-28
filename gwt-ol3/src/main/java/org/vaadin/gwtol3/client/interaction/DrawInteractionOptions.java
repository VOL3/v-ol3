package org.vaadin.gwtol3.client.interaction;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Collection;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.source.VectorSource;
import org.vaadin.gwtol3.client.style.Style;

/**
 * Options for the DrawInteraction
 * Created by mjhosio on 25/08/14.
 */
public class DrawInteractionOptions extends PointerInteraction{

    protected DrawInteractionOptions() {
    }

    public static final native DrawInteractionOptions create()/*-{
        return {};
    }-*/;

    /** Sets destination collection for the drawn features
     *
     * @param features
     */
    public final native void setFeatures(Collection<Feature> features)/*-{
        this.features=features;
    }-*/;

    /** Sets destination source for the drawn features
     *
     * @param source
     */
    public final native void setSource(VectorSource source)/*-{
        this.source=source;
    }-*/;

    /** Pixel distance for snapping to the drawing finish. Default is 12.
     *
     * @param snapTolerance
     */
    public final native void setSnapTolerance(double snapTolerance)/*-{
        this.snapTolerance=snapTolerance;
    }-*/;

    /** Sets the drawing type ('Point', 'LineString', 'Polygon', 'MultiPoint', 'MultiLineString', or 'MultiPolygon')
     *
     * @param type
     */
    public final native void setType(String type)/*-{
        this.type=type;
    }-*/;

    /** The number of points that must be drawn before a polygon ring can be finished. Default is 3
     *
     * @param pointsPerRing
     */
    public final native void setMinPointsPerRing(double pointsPerRing)/*-{
        this.minPointsPerRing=pointsPerRing;
    }-*/;

    /** Sets the style for the sketch features
     *
     * @param style
     */
    public final native void setStyle(JsArray<Style> style)/*-{
        this.style=style;
    }-*/;

    /** Sets the geometry name to use for features created by the draw interaction.
     *
      * @param geometryName
     */
    public final native void setGeometryName(String geometryName)/*-{
        this.geometryName=geometryName;
    }-*/;

}
