package org.vaadin.addon.vol3.source;

import java.util.Map;

/**
 * Options passed to OLTileWMSSource on construction
 * Created by mjhosio on 04/07/14.
 */
public class OLTileWMSSourceOptions extends OLSourceOptions {
    private String crossOriginPolicy;
    //Use the Map.pixelRatio value when requesting the image from the remote server
    private Boolean hidpi;
    // The type of the remote WMS server: mapserver, geoserver or qgis. Used when hidpi=true.
    private String serverType;
    // WMS service url
    private String url;
    // WMS service urls. Use this instead of url when the WMS supports multiple urls for GetMap requests
    private String [] urls;
    // The size in pixels of the gutter around image tiles to ignore.
    private Double gutter;
    // Max zoom level
    private Double maxZoom;
    // WMS request parameters. At least a LAYERS param is required. STYLES is '' by default. VERSION is 1.3.0 by default. WIDTH, HEIGHT, BBOX and CRS (SRS for WMS version &lt; 1.3.0) will be set dynamically.
    private Map<String,String> params;

    public String getCrossOriginPolicy() {
        return crossOriginPolicy;
    }

    public void setCrossOriginPolicy(String crossOriginPolicy) {
        this.crossOriginPolicy = crossOriginPolicy;
    }

    public Boolean getHidpi() {
        return hidpi;
    }

    /** Use the Map.pixelRatio value when requesting the image from the remote server
     *
     * @param hidpi
     */
    public void setHidpi(Boolean hidpi) {
        this.hidpi = hidpi;
    }

    public String getServerType() {
        return serverType;
    }

    /** The type of the remote WMS server: mapserver, geoserver or qgis. Used when hidpi=true.
     *
     * @param serverType
     */
     public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getUrl() {
        return url;
    }

    /** WMS service url
     *
     * @param url
     */
     public void setUrl(String url) {
        this.url = url;
    }

    public String[] getUrls() {
        return urls;
    }

    /** WMS service urls. Use this instead of url when the WMS supports multiple urls for GetMap requests
     *
     * @param urls
     */
     public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public Double getGutter() {
        return gutter;
    }

    /** The size in pixels of the gutter around image tiles to ignore.
     *
     * @param gutter
     */
     public void setGutter(Double gutter) {
        this.gutter = gutter;
    }

    public Double getMaxZoom() {
        return maxZoom;
    }

    /** Max zoom level
     *
     * @param maxZoom
     */
     public void setMaxZoom(Double maxZoom) {
        this.maxZoom = maxZoom;
    }

    public Map<String, String> getParams() {
        return params;
    }

    /** WMS request parameters. At least a LAYERS param is required. STYLES is '' by default. VERSION is 1.3.0 by default. WIDTH, HEIGHT, BBOX and CRS (SRS for WMS version &lt; 1.3.0) will be set dynamically.
     *
     * @param params
     */
    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
