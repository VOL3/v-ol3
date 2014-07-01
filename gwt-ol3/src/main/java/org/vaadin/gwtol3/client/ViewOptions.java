package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 01/07/14.
 */
public class ViewOptions extends JavaScriptObject{

    protected ViewOptions() {
    }

    /**
     * Initializes View options. Basically a simple map wrapper that can be passed to View on initialization
     */
    public static native ViewOptions create()
    /*-{
        return {};
    }-*/;

    public native final void setConstrainRotation(boolean constrained)/*-{
        this.constrainRotation=constrained;
    }-*/;

    public native final void setConstrainRotation(int integerConstraint)/*-{
        this.constrainRotation=integerConstraint;
    }-*/;

    public native final void setEnableRotation(boolean enabled)/*-{
        this.enableRotation=enabled;
    }-*/;

    public native final void setExtent(Extent extent)/*-{
        this.extent=extent;
    }-*/;

    public native final void setMaxResolution(double maxResolution)/*-{
        this.maxResolution=maxResolution;
    }-*/;

    public native final void setMinResolution(double minResolution)/*-{
        this.minResolution=minResolution;
    }-*/;

    public native final void setMaxZoom(double maxZoom)/*-{
        this.maxZoom=maxZoom;
    }-*/;

    public native final void setMinZoom(double minZoom)/*-{
        this.minZoom=minZoom;
    }-*/;

    public native final void setZoomFactor(double zoomFactor)/*-{
        this.zoomFactor=zoomFactor;
    }-*/;

    public native final void setProjection(String projection)/*-{
        this.projection=projection;
    }-*/;
}
