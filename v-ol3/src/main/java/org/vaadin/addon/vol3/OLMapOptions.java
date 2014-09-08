package org.vaadin.addon.vol3;

import org.vaadin.addon.vol3.client.OLDeviceOptions;
import org.vaadin.addon.vol3.client.OLRendererType;

/**
 * Options provided to the map on initialization.
 */
public class OLMapOptions {

    public OLMapOptions(){}

    private Boolean showOl3Logo;
    private OLRendererType renderer;
    private Double pixelRatio;
    private OLDeviceOptions deviceOptions;

    public Boolean getShowOl3Logo() {
        return showOl3Logo;
    }

    /** Shows / hides the ol3 logo
     *
     * @param showOl3Logo
     */
    public void setShowOl3Logo(Boolean showOl3Logo) {
        this.showOl3Logo = showOl3Logo;
    }

    public OLRendererType getRenderer() {
        return renderer;
    }

    /** Sets the renderer used by the map. By default, Canvas, DOM and WebGL renderers are tested for support in that order, and the first supported used. Specify a renderer here to use a specific renderer. Note that at present only the Canvas renderer supports vector data.
     *
     * @param renderer
     */
    public void setRenderer(OLRendererType renderer) {
        this.renderer = renderer;
    }

    public Double getPixelRatio() {
        return pixelRatio;
    }

    /** The ratio between physical pixels and device-independent pixels (dips) on the device.
     *
     * @param pixelRatio
     */
    public void setPixelRatio(Double pixelRatio) {
        this.pixelRatio = pixelRatio;
    }

    public OLDeviceOptions getDeviceOptions() {
        return deviceOptions;
    }

    /** Set device options related to loading map tiles
     *
     * @param deviceOptions
     */
    public void setDeviceOptions(OLDeviceOptions deviceOptions) {
        this.deviceOptions = deviceOptions;
    }
}
