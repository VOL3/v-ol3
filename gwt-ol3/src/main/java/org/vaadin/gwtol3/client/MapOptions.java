package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Options passed to Map on creation
 * Created by mjhosio on 01/07/14
 *
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
    public native final void setControls(Collection controls)/*-{
        this.controls=controls;
    }-*/;

    /**
     * Device options for the map
     *
     */
    public native final void setDeviceOptions(DeviceOptions options)/*-{
        this.deviceOptions=options;
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
    public native final void setInteractions(Collection interactions)/*-{
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
    public native final void setLayers(Collection layers)/*-{
        this.layers=layers;
    }-*/;

    /** Show ol3 logo. Default is true.
     *
     * @param show
     */
    public native final void setOl3Logo(boolean show)/*-{
        this.ol3Logo = show;
    }-*/;

    /** Overlays initially added to the map. By default, no overlays are added.
     *
     * @param overlays
     */
    public native final void setOverlays(Collection overlays)/*-{
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
