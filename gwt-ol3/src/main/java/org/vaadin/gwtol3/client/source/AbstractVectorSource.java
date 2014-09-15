package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.Extent;
import org.vaadin.gwtol3.client.feature.Feature;

/**
 * Base class for vector sources
 */
public abstract class AbstractVectorSource extends Source {
    protected AbstractVectorSource() {
    }


    public final native void addFeature(Feature feature)/*-{
        this.addFeature(feature);
    }-*/;

    public final native void addFeatures(JsArray<Feature> features)/*-{
        this.addFeatures(features);
    }-*/;

    public final native Feature getClosestFeatureToCoordinate(Coordinate coordinate)/*-{
        return this.getClosestFeatureToCoordinate(coordinate);
    }-*/;

    public final native Extent getExtent()/*-{
        return this.getExtent();
    }-*/;

    /** Get a feature by its identifier (the value returned by feature.getId()).
     *
     * @param id
     * @return
     */
    public final native Feature getFeatureById(String id)/*-{
        return this.getFeatureById(id);
    }-*/;

    public final native JsArray<Feature> getFeatures()/*-{
        return this.getFeatures();
    }-*/;

    public final native JsArray<Feature> getFeaturesAtCoordinate(Coordinate coordinate)/*-{
        return this.getFeaturesAtCoordinate(coordinate);
    }-*/;

    public final native void removeFeature(Feature feature)/*-{
        return this.removeFeature(feature);
    }-*/;
}

