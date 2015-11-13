package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import javafx.beans.binding.When;
import org.vaadin.gwtol3.client.control.Control;
import org.vaadin.gwtol3.client.interaction.Interaction;
import org.vaadin.gwtol3.client.layer.Layer;

import javax.validation.groups.Default;

/**
 * Options passed to Map on creation
 */
public class MapOptions extends JavaScriptObject{
    protected MapOptions() {
    }

    /**
     * Initializes Map options. Basically a simple map wrapper that can be passed to Map on initialization
     */
    public static native MapOptions create()
    /*-{
        return {};
    }-*/;

    /**
     * Controls initially added to the map
     *
     */
    public native final void setControls(Collection<Control> controls)/*-{
        this.controls=controls;
    }-*/;

    /**
     * When set to true, tiles will be loaded during animations. This may improve the user experience, but can also make animations stutter on devices with slow memory. Default is false
     * @param loadTilesWhileAnimating
     */
    public native final void setLoadTilesWhileAnimating(boolean loadTilesWhileAnimating)/*-{
        this.loadTilesWhileAnimating=loadTilesWhileAnimating;
    }-*/;

    /**
     * When set to true, tiles will be loaded while interacting with the map. This may improve the user experience, but can also make map panning and zooming choppy on devices with slow memory. Default is false.
     * @param loadTilesWhileInteracting
     */
    public native final void setLoadTilesWhileInteracting(boolean loadTilesWhileInteracting)/*-{
        this.loadTilesWhileInteracting = loadTilesWhileInteracting;
    }-*/;

    /**
     * The ratio between physical pixels and device-independent pixels (dips) on the device. If undefined then it gets set by using window.devicePixelRatio
     */
    public native final void setPixelRatio(double pixelRatio)/*-{
        this.pixelRatio=pixelRatio;
    }-*/;

    /**
     * Interactions that are initially added to the map. If not specified, ol.interaction.defaults() is used
     */
    public native final void setInteractions(Collection<Interaction> interactions)/*-{
        this.interactions=interactions;
    }-*/;

    /**
     * the element to listen to keyboard events on. This determines when the KeyboardPan and KeyboardZoom interactions trigger. For example, if this option is set to document the keyboard interactions will always trigger. If this option is not specified, the element the library listens to keyboard events on is the map target (i.e. the user-provided div for the map). If this is not document the target element needs to be focused for key events to be emitted, requiring that the target element has a tabindex attribute.
     */
    public native final void setKeyboardEventTarget(Element target)/*-{
        this.keyboardEventTarget=target;
    }-*/;

    /**
     * Layers. If this is not defined, a map with no layers will be rendered.
     *
     * @param layers initial layers
     */
    public native final void setLayers(Collection<Layer> layers)/*-{
        this.layers=layers;
    }-*/;

    /** Show ol3 logo. Default is true.
     *
     * @param show
     */
    public native final void setOl3Logo(boolean show)/*-{
        this.logo = show;
    }-*/;

    /** Overlays initially added to the map. By default, no overlays are added.
     *
     * @param overlays
     */
    public native final void setOverlays(Collection<Overlay> overlays)/*-{
        this.overlays = overlays;
    }-*/;

    /**
    * Renderer. By default, Canvas, DOM and WebGL renderers are tested for support in that order, and the first supported used. Specify one of the RendererType constants here to use a specific renderer. Note that at present only the Canvas renderer supports vector data.
    */
    public native final void setRenderer(String renderer)/*-{
        this.renderer = renderer;
    }-*/;

    /**
     * The container for the map. If not specified at construction time, ol.Map#setTarget must be called for the map to be rendered.
     */
    public native final void setTarget(Element targetElement)/*-{
        this.target=targetElement;
    }-*/;

    /**
     * The map's view. No layer sources will be fetched unless this is specified at construction time or through ol.Map#setView.
     * @param view
     */
    public native final void setView(View view)/*-{
        this.view=view;
    }-*/;
}
