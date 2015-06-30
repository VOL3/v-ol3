package org.vaadin.addon.vol3.source;

import java.util.Map;

/**
 * Options passed to OLImageWMSSource on construction
 */
public class OLImageWMSSourceOptions extends OLSourceOptions {
    private String crossOriginPolicy;
    //Use the Map.pixelRatio value when requesting the image from the remote server
    private Boolean hidpi;
    // The type of the remote WMS server: mapserver, geoserver or qgis
    private String serverType;
    //Ratio. 1 means image requests are the size of the map viewport, 2 means twice the size of the map viewport, and so on. Default is 1.5.
    private Double ratio;
    // Resolutions. If specified, requests will be made for these resolutions only.
    private double [] resolutions;
    // WMS service url
    private String url;
    // WMS request parameters. At least a LAYERS param is required. STYLES is '' by default. VERSION is 1.3.0 by default. WIDTH, HEIGHT, BBOX and CRS (SRS for WMS version &lt; 1.3.0) will be set dynamically.
    private Map<String,String> params;

    private String projection;

    public String getProjection() {
        return projection;
    }

    /** Sets the csr name of the used projection
     *
     * @param projection
     */
    public OLImageWMSSourceOptions setProjection(String projection) {
        this.projection = projection;
        return this;
    }


    public String getCrossOriginPolicy() {
        return crossOriginPolicy;
    }

    public OLImageWMSSourceOptions setCrossOriginPolicy(String crossOriginPolicy) {
        this.crossOriginPolicy = crossOriginPolicy;
        return this;
    }

    public Boolean getHidpi() {
        return hidpi;
    }

    /** Use the Map.pixelRatio value when requesting the image from the remote server
     *
     * @param hidpi
     */
    public OLImageWMSSourceOptions setHidpi(Boolean hidpi) {
        this.hidpi = hidpi;
        return this;
    }

    public String getServerType() {
        return serverType;
    }

    /** The type of the remote WMS server: mapserver, geoserver or qgis
     *
     * @param serverType
     */
    public OLImageWMSSourceOptions setServerType(String serverType) {
        this.serverType = serverType;
        return this;
    }

    public Double getRatio() {
        return ratio;
    }

    /**
     * Ratio. 1 means image requests are the size of the map viewport, 2 means twice the size of the map viewport, and so on. Default is 1.5.
     * @param ratio
     */
    public OLImageWMSSourceOptions setRatio(Double ratio) {
        this.ratio = ratio;
        return this;
    }

    public double[] getResolutions() {
        return resolutions;
    }

    /** Resolutions. If specified, requests will be made for these resolutions only.
     *
     * @param resolutions
     */
    public OLImageWMSSourceOptions setResolutions(double[] resolutions) {
        this.resolutions = resolutions;
        return this;
    }

    public String getUrl() {
        return url;
    }

    /** WMS service url
     *
     * @param url
     */
    public OLImageWMSSourceOptions setUrl(String url) {
        this.url = url;
        return this;
    }

    public Map<String, String> getParams() {
        return params;
    }

    /** WMS request parameters. At least a LAYERS param is required. STYLES is '' by default. VERSION is 1.3.0 by default. WIDTH, HEIGHT, BBOX and CRS (SRS for WMS version &lt; 1.3.0) will be set dynamically.
     *
     * @param params
     */
    public OLImageWMSSourceOptions setParams(Map<String, String> params) {
        this.params = params;
        return this;
    }
}
