/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.interaction;

import org.vaadin.gwtol3.client.geom.Polygon;

/**
 * Some strange, errors in JS, on this time not working - FIXED!
 * Need add DragZoomInteraction by default to map!
 * @author iserge
 */
public class DragBoxInteraction extends PointerInteraction {
    protected DragBoxInteraction() {
        //
    }
    
    public static native DragBoxInteraction create() /*-{
        return new $wnd.ol.interaction.DragBox();
    }-*/;
    
    public static native DragBoxInteraction create(DragBoxInteractionOptions options) /*-{
        return new $wnd.ol.interaction.DragBox(options);
    }-*/;
    
    public final native Polygon getGeometry() /*-{
        return this.getGeometry();
    }-*/;
    
    public final native void addDragBoxInteractionListener(OnDragBoxInteractionListener onDragBoxInteractionListener) /*-{
        if (!this.__onDragBoxInteractionRegistered) {
            var that = this;
            
            var boxendCallback = function(event) {
                var boxendEvent = {type: "boxend", geometry: that.getGeometry(), nativeEvent: event.originalEvent};
                that.__notifyDragBoxInteractionListeners(boxendEvent);
            };
            this.on("boxend", $entry(boxendCallback), this);
            
            var boxstartCallback = function(event) {
                var boxstartEvent = {type: "boxstart", geometry: that.getGeometry(), nativeEvent: event.originalEvent};
                that.__notifyDragBoxInteractionListeners(boxstartEvent);
            };
            this.on("boxstart", $entry(boxstartCallback), this);
            
            this.__onDragBoxInteractionRegistered=true;
            this.__dragBoxInteractionListeners=[];
            this.__notifyDragBoxInteractionListeners = function(dragBoxInteractionEvent) {
                var length=this.__dragBoxInteractionListeners.length;
                for(var i=0; i<length; i++){
                    var listener = this.__dragBoxInteractionListeners[i];
                    listener.@org.vaadin.gwtol3.client.interaction.OnDragBoxInteractionListener::onDragBoxInteraction(Lorg/vaadin/gwtol3/client/interaction/DragBoxInteractionEvent;)(dragBoxInteractionEvent);
                }
            };
        }
        this.__dragBoxInteractionListeners.push(onDragBoxInteractionListener);
    }-*/;
}
