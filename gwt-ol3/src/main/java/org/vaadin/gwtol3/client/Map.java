package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import org.vaadin.gwtol3.client.control.Control;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.interaction.Interaction;
import org.vaadin.gwtol3.client.layer.Layer;
import org.vaadin.gwtol3.client.layer.LayerBase;
import org.vaadin.gwtol3.client.layer.LayerGroup;
import org.vaadin.gwtol3.client.map.OnClickListener;
import org.vaadin.gwtol3.client.map.OnMapChangeListener;
import org.vaadin.gwtol3.client.map.OnMoveListener;

/**
 * Wrapper for the OpenLayers map
 */
public class Map extends JavaScriptObject{

    protected Map(){

    }

    /**
     * Initializes Open Layer v3 map to the given element with default options
     *
     * @param root the element root for the map
     * @return the OL3 map instance
     */
    public static native Map create(Element root)
    /*-{
        return new $wnd.ol.Map({target: root});
    }-*/;

    /**
     * Initializes Open Layer v3 map using the given map options
     *
     * @param options the map options
     * @return the OL3 map instance
     */
    public static native Map create(MapOptions options)
    /*-{
        return new $wnd.ol.Map(options);
    }-*/;

    /**
     * Add the given control to the map.
     *
     * @param control
     */
    public native final void addControl(Control control)/*-{
        this.addControl(control);
    }-*/;

    /**
     * Add the given interaction to the map.
     *
     * @param interaction
     */
    public native final void addInteraction(Interaction interaction)/*-{
        this.addInteraction(interaction);
    }-*/;

    /**
     * Adds the given layer to the top of this map.
     *
     * @param layer
     */
    public native final void addLayer(LayerBase layer)/*-{
        this.addLayer(layer);
    }-*/;

    /**
     * Add the given overlay to the map.
     *
     * @param overlay
     */
    public native final void addOverlay(Overlay overlay)/*-{
        this.addOverlay(overlay);
    }-*/;

//    public native final void beforeRender()/*-{
//        //TODO: find a nice way to do this in GWT
//    }-*/;
//
//    public native final void forEachFeatureAtPixel()/*-{
//        //TODO: find a nice way to do this in GWT
//    }-*/;

    public native final Collection<Control> getControls()/*-{
        return this.getControls();
    }-*/;

    public native final Coordinate getCoordinateFromPixel(Pixel pixel)/*-{
        return this.getCoordinateFromPixel()
    }-*/;

    /**
     * Returns the geographical coordinate for a browser event.
     *
     * @param event
     * @return
     */
    public native final Coordinate getEventCoordinate(NativeEvent event)/*-{
        return this.getEventCoordinate(event);
    }-*/;

    /**
     * Returns the map pixel position for a browser event.
     *
     * @param event
     * @return
     */
    public native final Pixel getEventPixel(NativeEvent event)/*-{
        return this.getEventPixel(event);
    }-*/;

    /**
     * Gets the collection of ol.interaction.Interaction instances associated with this map. Modifying this collection changes the interactions associated with the map. Interactions are used for e.g. pan, zoom and rotate.
     *
     * @return
     */
    public native final Collection<Interaction> getInteractions()/*-{
        return this.getInteractions();
    }-*/;

    /**
     * Get the layergroup associated with this map.
     *
     * @return
     */
    public native final LayerGroup getLayerGroup()/*-{
        return this.getLayerGroup();
    }-*/;

    /**
     * Get the collection of layers associated with this map.
     * @return
     */
    public native final Collection<Layer> getLayers()/*-{
        return this.getLayers();
    }-*/;

    public native final Collection<Overlay> getOverlays()/*-{
        return this.getOverlays();
    }-*/;

    public native final Pixel getPixelFromCoordinate(Coordinate coordinate)/*-{
        return this.getPixelFromCoordinate(coordinate);
    }-*/;

    /**
     * Get the size of this map.
     *
     * @return
     */
    public native final Size getSize()/*-{
        return this.getSize();
    }-*/;

    /**
     * Get the target element in which this map is rendered.
     *
     * @return
     */
    public native final Element getTarget()/*-{
        return this.getTarget();
    }-*/;

    /**
     * Get the view associated with this map. This can be a 2D or 3D view. A 2D view manages properties such as center and resolution.
     *
     * @return
     */
    public native final View getView()/*-{
        return this.getView();
    }-*/;


    public native final Element getViewPort()/*-{
        return this.getViewport();
    }-*/;

    /**
     * Remove the given control from the map.
     *
     * @param control
     */
    public native final void removeControl(Control control)/*-{
        this.removeControl(control);
    }-*/;

    /**
     * Remove the given interaction from the map.
     *
     * @param interaction
     */
    public native final void removeInteraction(Interaction interaction)/*-{
        this.removeInteraction(interaction);
    }-*/;

    /**
     * Removes the given layer from the map.
     *
     * @param layer
     */
    public native final void removeLayer(LayerBase layer)/*-{
        this.removeLayer(layer);
    }-*/;

    /**
     * Remove the given overlay from the map.
     *
     * @param overlay
     */
    public native final void removeOverlay(Overlay overlay)/*-{
        this.removeOverlay(overlay);
    }-*/;

    /**
     * Requests a render frame; rendering will effectively occur at the next browser animation frame.
     *
     */
     public native final void render()/*-{
        this.render();
    }-*/;

    /**
     * Requests an immediate render in a synchronous manner
     *
     */
    public native final void renderSync()/*-{
        this.renderSync();
    }-*/;

    /**
     * Sets the layergroup of this map
     *
     * @param layerGroup
     */
    public native final void setLayerGroup(LayerGroup layerGroup)/*-{
        this.setLayerGroup(layerGroup);
    }-*/;

    /**
     * Sets the size of this map
     *
     * @param size
     */
    public native final void setSize(Size size)/*-{
        this.setSize(size);
    }-*/;

    /**
     * Set the target element to render this map into.
     *
     * @param element
     */
    public native final void setTarget(Element element)/*-{
        this.setTarget(element);
    }-*/;

    /**
     * Set the view for this map.
     *
     * @param view
     */
    public native final void setView(View view)/*-{
        this.setView(view);
    }-*/;

    /**
     * Force a recalculation of the map viewport size. This should be called when third-party code changes the size of the map viewport.
     *
     */
    public native final void updateSize()/*-{
        this.updateSize();
    }-*/;

    public native final Collection<Feature> getFeaturesFromPixel(Pixel pixel)/*-{
        var features = new $wnd.ol.Collection();
        this.forEachFeatureAtPixel(pixel, function(feature, layer){
            if(typeof(feature)!='undefined'){
                features.push(feature);
            }
        });
        return features;
    }-*/;

    /**
     * Add given listener to the map
     * @param onClickListener
     */
    public native final void addOnClickListener(OnClickListener onClickListener)/*-{
        // for the first time we need to register as event listener as well, we are never removing ourselves though
        if(!this.__registered){
            var that=this;
            // listen for singleclick
            var clickCallback=function(event){
                var clickEvent={pixel : event.pixel, coordinate: event.coordinate, type: "leftclick", nativeEvent : event.originalEvent};
                that.__notifyClickListeners(clickEvent);
            };
            this.on("singleclick", $entry(clickCallback),this);
            // listen for doubleclick
            var dblClickCallback=function(event){
                var clickEvent={pixel : event.pixel, coordinate: event.coordinate, type: "doubleclick", nativeEvent: event.originalEvent};
                that.__notifyClickListeners(clickEvent);
                event.preventDefault();
            };
            this.on("dblclick", $entry(dblClickCallback),this);
            // listen for right click
            var rightClickCallback=function(event){

                var clickEvent={pixel: that.getEventPixel(event), coordinate: that.getEventCoordinate(event), type: "rightclick", nativeEvent: event};
                that.__notifyClickListeners(clickEvent);
                event.preventDefault();
            };
            this.getViewport().addEventListener('contextmenu', $entry(rightClickCallback));
            this.__registered=true;
            this.__clickListeners=[];
            this.__notifyClickListeners = function(clickEvent){
                var length=this.__clickListeners.length;
                for(var i=0; i<length; i++){
                    var listener = this.__clickListeners[i];
                    listener.@org.vaadin.gwtol3.client.map.OnClickListener::onClick(Lorg/vaadin/gwtol3/client/map/ClickEvent;)(clickEvent);
                }
            };
        }
        this.__clickListeners.push(onClickListener);
    }-*/;

    public native final void removeOnClickListener(OnClickListener listener) /*-{
        var index = this.__clickListeners.indexOf(listener);
        if (index > -1) {
            this.__clickListeners.splice(index, 1);
        }
    }-*/;
    
    public native final void addOnMoveListener(OnMoveListener onMoveListener) /*-{
        if (!this.__onMoveRegistered) {
            var that=this;
            // listen for right click
            var moveCallback=function(event){

                var moveEvent={pixel: that.getEventPixel(event), coordinate: that.getEventCoordinate(event), type: "mousemove", nativeEvent: event};
                that.__notifyMoveListeners(moveEvent);
                event.preventDefault();
            };
            this.getViewport().addEventListener('mousemove', $entry(moveCallback));
            this.__onMoveRegistered=true;
            this.__moveListeners=[];
            this.__notifyMoveListeners = function(moveEvent){
                var length=this.__moveListeners.length;
                for(var i=0; i<length; i++){
                    var listener = this.__moveListeners[i];
                    listener.@org.vaadin.gwtol3.client.map.OnMoveListener::onMove(Lorg/vaadin/gwtol3/client/map/MoveEvent;)(moveEvent);
                }
            };
        }
        this.__moveListeners.push(onMoveListener);
    }-*/;
    
    public native final void removeOnMoveListener(OnMoveListener listener) /*-{
        var index = this.__moveListeners.indexOf(listener);
        if (index > -1) {
            this.__moveListeners.splice(index, 1);
        }
    }-*/;
    
    public native final void addOnMapChangeListener(OnMapChangeListener onMapChangeListener) /*-{
        if (!this.__onChangeRegistered) {
            var that = this;
            
            var sizeCallback = function(event) {
                var sizeEvent = {size: this.getSize(), type: "size", nativeEvent: event.originalEvent};
                that.__notifyChangeListeners(sizeEvent);
            };
            this.on("change:size", $entry(sizeCallback), this);
            
            var layerGroupCallback = function(event) {
                var layerGroupEvent = {type: "layergroup", nativeEvent: event.originalEvent};
                that.__notifyChangeListeners(layerGroupEvent);
            };
            this.on("change:layergroup", $entry(layerGroupCallback), this);
            
            this.__onChangeRegistered=true;
            this.__changeListeners=[];
            this.__notifyChangeListeners = function(changeEvent) {
                var length=this.__changeListeners.length;
                for(var i=0; i<length; i++){
                    var listener = this.__changeListeners[i];
                    listener.@org.vaadin.gwtol3.client.map.OnMapChangeListener::onMapChange(Lorg/vaadin/gwtol3/client/map/MapChangeEvent;)(changeEvent);
                }
            };
        }
        this.__changeListeners.push(onMapChangeListener);
    }-*/;
}
