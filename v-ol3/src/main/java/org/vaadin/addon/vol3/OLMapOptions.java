package org.vaadin.addon.vol3;

import org.vaadin.addon.vol3.client.OLDeviceOptions;
import org.vaadin.addon.vol3.client.OLRendererType;

/**
 * Created by mjhosio on 01/07/14.
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

    public void setShowOl3Logo(Boolean showOl3Logo) {
        this.showOl3Logo = showOl3Logo;
    }

    public OLRendererType getRenderer() {
        return renderer;
    }

    public void setRenderer(OLRendererType renderer) {
        this.renderer = renderer;
    }

    public Double getPixelRatio() {
        return pixelRatio;
    }

    public void setPixelRatio(Double pixelRatio) {
        this.pixelRatio = pixelRatio;
    }

    public OLDeviceOptions getDeviceOptions() {
        return deviceOptions;
    }

    public void setDeviceOptions(OLDeviceOptions deviceOptions) {
        this.deviceOptions = deviceOptions;
    }
}
