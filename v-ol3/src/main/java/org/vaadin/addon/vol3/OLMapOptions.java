package org.vaadin.addon.vol3;

import org.vaadin.addon.vol3.client.OLDeviceOptions;
import org.vaadin.addon.vol3.client.OLRendererType;

import java.util.HashMap;
import java.util.Map;

/**
 * Options provided to the map on initialization.
 */
public class OLMapOptions {

    public OLMapOptions(){}

    private Boolean showOl3Logo;
    private OLRendererType renderer;
    private Double pixelRatio;
    private OLDeviceOptions deviceOptions;
    private Map<String,String> coordinateSystemDefinitions;


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

    /** Activates the given projection using the proj4js library. You must activate the projection before you can use it in your views and data sources. Please note that the proj4js library is not included in the add-on. If you need other coordinate systems, you need to do include proj4js manually using the @JavaScript annotation. See the test code in Proj4jsMap for details.
     *
     * @param epsgCode the epsgCode for the projection
     * @param proj4jsString the proj4jsString to define the projection. You can use for example the epsg.io to come up with this one. Just type in your EPSG code to the search page and look below for the proj4js in the export section.
     */
    public void defineProjection(String epsgCode, String proj4jsString){
        if(epsgCode==null){
            throw new IllegalArgumentException("epsgCode can not be null");
        }
        if(proj4jsString==null){
            throw new IllegalArgumentException("proj4jsString can not be null");
        }
        if(coordinateSystemDefinitions==null){
            coordinateSystemDefinitions=new HashMap<String,String>();
        }
        coordinateSystemDefinitions.put(epsgCode, proj4jsString);
    }

    /** Returns the additional coordinate system definitions that should be enabled using proj4js
     *
     * @return
     */
    public Map<String, String> getCoordinateSystemDefinitions() {
        return coordinateSystemDefinitions;
    }
}
