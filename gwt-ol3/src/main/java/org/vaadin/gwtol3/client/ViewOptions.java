package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * Options passed to the view on creation
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

    public native final void setRestrictedExtent(Extent extent)/*-{
        this.restrictedExtent=extent;
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

    /** This is the map projection that must always match the basemap projection.
     *
     * @param projection
     */
    public native final void setProjection(String projection)/*-{
        this.projection=projection;
    }-*/;

    /**
     * Resolutions to determine the resolution constraint. If set the maxResolution, minResolution, minZoom, maxZoom, and zoomFactor options are ignored.
     */
    public native final void setResolutions(JsArrayNumber resolutions)/*-{
        this.resolutions=resolutions;
    }-*/;


    /**
     * Toggles automatic coordinate transformation. By setting input projection, you can interact with the view by passing coordinates and extents in chosen projection instead of the map projection.
     * @param projection the input / output projections for coordinates and extents.
     */
    public native final void setInputProjection(String projection)/*-{
        this.__inputProjection=projection;
    }-*/;
}
