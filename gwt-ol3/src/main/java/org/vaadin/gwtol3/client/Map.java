package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import org.vaadin.gwtol3.client.control.Control;
import org.vaadin.gwtol3.client.interaction.Interaction;
import org.vaadin.gwtol3.client.layer.Base;
import org.vaadin.gwtol3.client.layer.Group;

/**
 * Created by mjhosio on 24/06/14.
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
    public native final void addLayer(Base layer)/*-{
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

    public native final Collection getControls()/*-{
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
    public native final Collection getInteractions()/*-{
        return this.getInteractions();
    }-*/;

    /**
     * Get the layergroup associated with this map.
     *
     * @return
     */
    public native final Group getLayerGroup()/*-{
        return this.getLayerGroup();
    }-*/;

    /**
     * Get the collection of layers associated with this map.
     * @return
     */
    public native final Collection getLayers()/*-{
        return this.getLayers();
    }-*/;

    public native final Collection getOverlays()/*-{
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
    public native final void removeLayer(Base layer)/*-{
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
    public native final void setLayerGroup(Group layerGroup)/*-{
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
}
