package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.Extent;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.format.FeatureFormat;
import org.vaadin.gwtol3.client.source.vector.FeatureSetChangeListener;

/**
 * Base class for vector sources
 */
public class VectorSource extends Source{
    protected VectorSource() {
    }

    public static final native VectorSource create(VectorSourceOptions options)/*-{
        var vector=new $wnd.ol.source.Vector(options);
        vector.featureSetChangeListeners=[];
        var fireAddEvent=function(event){
            var listenerCount=vector.featureSetChangeListeners.length;
            for(var i=0;i<listenerCount;i++){
                vector.featureSetChangeListeners[i].featureAdded(event.feature);
            }
        };
        var fireDeleteEvent=function(event){
            var listenerCount=vector.featureSetChangeListeners.length;
            for(var i=0;i<listenerCount;i++){
                vector.featureSetChangeListeners[i].featureDeleted(event.feature);
            }
        };
        vector.on("addfeature",fireAddEvent,this);
        vector.on("removefeature",fireDeleteEvent,this);
        return vector;
    }-*/;

    /** Adds feature set change listener
     *
     * @param listener the listener to be added
     * @return listener key that can be used to remove the listener
     */
    public native final JavaScriptObject addFeatureSetChangeListener(FeatureSetChangeListener listener)/*-{
        var changeListener = {
            featureAdded: $entry(function(feature) {
                    listener.@org.vaadin.gwtol3.client.source.vector.FeatureSetChangeListener::featureAdded(Lorg/vaadin/gwtol3/client/feature/Feature;)(feature);
            }),
            featureDeleted : $entry(function(feature) {
                listener.@org.vaadin.gwtol3.client.source.vector.FeatureSetChangeListener::featureDeleted(Lorg/vaadin/gwtol3/client/feature/Feature;)(feature);
            })
        };
        this.featureSetChangeListeners.push(changeListener);
    }-*/;

    public native final void removeFeatureSetChangeListener(JavaScriptObject listenerKey)/*-{
        var listenerCount=this.featureSetChangeListeners.length;
        for(var i=0;i<listenerCount;i++){
            if(this.featureSetChangeListeners[i]==listenerKey){
                this.featureSetChangeListeners[i].splice(i,1);
                return;
            }
        }
    }-*/;


    public final native void addFeature(Feature feature)/*-{
        this.addFeature(feature);
    }-*/;

    public final native void addFeatures(JsArray<Feature> features)/*-{
        this.addFeatures(features);
    }-*/;

	/** Removes all the features in this source
     *
     * @param fast if true, skip dispatching removefeature events
     */
    public final native void clear(boolean fast)/*-{
        this.clear(fast);
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

    public final native JsArray<Feature> getFeaturesInExtent(Extent extent)/*-{
        return this.getFeaturesInExtent(extent);
    }-*/;

    public final native FeatureFormat getFormat()/*-{
        return this.getFormat();
    }-*/;

    public final native String getUrl()/*-{
        return this.getUrl();
    }-*/;

    public final native void removeFeature(Feature feature)/*-{
        return this.removeFeature(feature);
    }-*/;
}
