package org.vaadin.gwtol3.client.interaction;

/**
 * Interaction that allows drawing of geometries
 */
public class DrawInteraction extends Interaction{
    protected DrawInteraction() {
    }

    public static final native DrawInteraction create()/*-{
        return new $wnd.ol.interaction.Draw();
    }-*/;

    public static final native DrawInteraction create(DrawInteractionOptions options)/*-{
        return new $wnd.ol.interaction.Draw(options);
    }-*/;
    
    public native final void addDrawInteractionListener(OnDrawInteractionListener onDrawInteractionListener) /*-{
        if (!this.__onDrawInteractionRegistered) {
            var that = this;
            
            var drawendCallback = function(event) {
                var drawendEvent = {type: "drawend", feature: this.feature, nativeEvent: event.originalEvent};
                that.__notifyDrawInteractionListeners(drawendEvent);
            };
            this.on("drawend", $entry(drawendCallback), this);
            
            var drawstartCallback = function(event) {
                var drawstartEvent = {type: "drawstart", feature: this.feature, nativeEvent: event.originalEvent};
                that.__notifyDrawInteractionListeners(drawstartEvent);
            };
            this.on("drawstart", $entry(drawstartCallback), this);
            
            this.__onDrawInteractionRegistered=true;
            this.__drawInteractionListeners=[];
            this.__notifyDrawInteractionListeners = function(drawInteractionEvent) {
                var length=this.__drawInteractionListeners.length;
                for(var i=0; i<length; i++){
                    var listener = this.__drawInteractionListeners[i];
                    listener.@org.vaadin.gwtol3.client.interaction.OnDrawInteractionListener::onDrawInteraction(Lorg/vaadin/gwtol3/client/interaction/DrawInteractionEvent;)(drawInteractionEvent);
                }
            };
        }
        this.__drawInteractionListeners.push(onDrawInteractionListener);
    }-*/;
}
