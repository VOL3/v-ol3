package org.vaadin.addon.vol3;

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
    private Map<String,String> coordinateSystemDefinitions;
    private Boolean loadTilesWhileAnimating;
    private Boolean loadTilesWhileInteracting;
    private String inputProjection;


    public Boolean getShowOl3Logo() {
        return showOl3Logo;
    }

    /** Shows / hides the ol3 logo
     *
     * @param showOl3Logo
     */
    public OLMapOptions setShowOl3Logo(Boolean showOl3Logo) {
        this.showOl3Logo = showOl3Logo;
        return this;
    }

    public OLRendererType getRenderer() {
        return renderer;
    }

    /** Sets the renderer used by the map. By default, Canvas, DOM and WebGL renderers are tested for support in that order, and the first supported used. Specify a renderer here to use a specific renderer. Note that at present only the Canvas renderer supports vector data.
     *
     * @param renderer
     */
    public OLMapOptions setRenderer(OLRendererType renderer) {
        this.renderer = renderer;
        return this;
    }

    public Double getPixelRatio() {
        return pixelRatio;
    }

    /** The ratio between physical pixels and device-independent pixels (dips) on the device.
     *
     * @param pixelRatio
     */
    public OLMapOptions setPixelRatio(Double pixelRatio) {
        this.pixelRatio = pixelRatio;
        return this;
    }


    public Boolean getLoadTilesWhileAnimating() {
        return loadTilesWhileAnimating;
    }

    /**
     * When set to true, tiles will be loaded during animations. This may improve the user experience, but can also make animations stutter on devices with slow memory. Default is false
     * @param loadTilesWhileAnimating
     */
    public OLMapOptions setLoadTilesWhileAnimating(Boolean loadTilesWhileAnimating) {
        this.loadTilesWhileAnimating = loadTilesWhileAnimating;
        return this;
    }

    public Boolean getLoadTilesWhileInteracting() {
        return loadTilesWhileInteracting;
    }

    /**
     * When set to true, tiles will be loaded while interacting with the map. This may improve the user experience, but can also make map panning and zooming choppy on devices with slow memory. Default is false.
     * @param loadTilesWhileInteracting
     */
    public OLMapOptions setLoadTilesWhileInteracting(Boolean loadTilesWhileInteracting) {
        this.loadTilesWhileInteracting = loadTilesWhileInteracting;
        return this;
    }

    /** Activates the given projection using the proj4js library. You must activate the projection before you can use it in your views and data sources. Please note that the proj4js library is not included in the add-on. If you need other coordinate systems, you need to do include proj4js manually using the @JavaScript annotation. See the test code in Proj4jsMap for details.
     *
     * @param epsgCode the epsgCode for the projection
     * @param proj4jsString the proj4jsString to define the projection. You can use for example the epsg.io to come up with this one. Just type in your EPSG code to the search page and look below for the proj4js in the export section.
     */
    public OLMapOptions defineProjection(String epsgCode, String proj4jsString){
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
        return this;
    }

    /** Returns the additional coordinate system definitions that should be enabled using proj4js
     *
     * @return
     */
    public Map<String, String> getProjectionDefinitions() {
        return coordinateSystemDefinitions;
    }


    public String getInputProjection() {
        return inputProjection;
    }

    /** Sets the projection used when interpreting Coordinates and Extents passed in api calls. If the inputProjection differs from map projection,
     * automatic conversion is done by the wrapper. The default is the value of the map projection.
     * @param inputProjection the input projection
     */
    public OLMapOptions setInputProjection(String inputProjection) {
        this.inputProjection = inputProjection;
        return this;
    }
}
