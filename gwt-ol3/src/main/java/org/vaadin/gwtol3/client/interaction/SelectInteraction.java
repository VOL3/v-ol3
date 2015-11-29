package org.vaadin.gwtol3.client.interaction;

import org.vaadin.gwtol3.client.Collection;
import org.vaadin.gwtol3.client.Map;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.layer.VectorLayer;

/**
 * Interaction that handles selection of vector data
 */
public class SelectInteraction extends Interaction{
    protected SelectInteraction() {
    }

    public static final native SelectInteraction create()/*-{
        return new $wnd.ol.interaction.Select();
    }-*/;

    public static final native SelectInteraction create(SelectInteractionOptions options)/*-{
        return new $wnd.ol.interaction.Select(options);
    }-*/;
    
    /**
     * Returns the associated vectorlayer of the (last) selected feature. Note that this will not work with any programmatic method like pushing features to collection.
     * @param feature
     * @return associated vectorlayer of the (last) selected feature
     */
    public native final VectorLayer getLayer(Feature feature) /*-{
        return this.getLayer(feature);
    }-*/;

    /** Gets the selected features
     *
     * @return the collection of selected features
     */
    public native final Collection<Feature> getFeatures()/*-{
        return this.getFeatures();
    }-*/;

    /** Remove the interaction from its current map, if any, and attach it to a new map, if any. Pass null to just remove the interaction from the current map.
     *
     * @param map
     */
    public native final void setMap(Map map)/*-{
        this.setMap(map);
    }-*/;

    public native final void addSelectionChangeListener(SelectionChangeListener listener)/*-{
        var callback=function(){
            listener.@org.vaadin.gwtol3.client.interaction.SelectionChangeListener::selectionChanged()();
        };
        this.getFeatures().on("change:length",$entry(callback),this);
    }-*/;
    
    public native final void addOnSelectInteractionListener(OnSelectInteractionListener onSelectInteractionListener) /*-{
        if (!this.__onSelectRegistered) {
            var that = this;
            var selectCallback = function(event) {
                var selectEvent = {deselected: event.deselected, selected: event.selected, nativeEvent: event.originalEvent};
                that.__notifySelectListeners(selectEvent);
            };
            this.on("select", $entry(selectCallback), this);            
            
            this.__onSelectRegistered=true;
            this.__selectListeners=[];
            this.__notifySelectListeners = function(selectEvent) {
                var length = this.__selectListeners.length;
                for(var i=0; i<length; i++){
                    var listener = this.__selectListeners[i];
                    listener.@org.vaadin.gwtol3.client.interaction.OnSelectInteractionListener::onSelectInteraction(Lorg/vaadin/gwtol3/client/interaction/SelectInteractionEvent;)(selectEvent);
                }
            };
        }
        this.__selectListeners.push(onSelectInteractionListener);
    }-*/;
}
