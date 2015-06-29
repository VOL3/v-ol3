package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.source.vector.FeatureSetChangeListener;

/**
 * Base class for vector sources
 */
public class VectorSource extends AbstractVectorSource{
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

}
