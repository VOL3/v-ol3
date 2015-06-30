package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLTileGrid;

import java.util.Map;

/**
 * Options passed to OLTileWMSSource on construction
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

    private OLTileGrid tileGrid;

    private String projection;

    public String getCrossOriginPolicy() {
        return crossOriginPolicy;
    }

    public OLTileWMSSourceOptions setCrossOriginPolicy(String crossOriginPolicy) {
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
    public OLTileWMSSourceOptions setHidpi(Boolean hidpi) {
        this.hidpi = hidpi;
        return this;
    }

    public String getServerType() {
        return serverType;
    }

    /** The type of the remote WMS server: mapserver, geoserver or qgis. Used when hidpi=true.
     *
     * @param serverType
     */
    public OLTileWMSSourceOptions setServerType(String serverType) {
        this.serverType = serverType;
        return this;

    }

    public String getUrl() {
        return url;
    }

    /** WMS service url
     *
     * @param url
     */
    public OLTileWMSSourceOptions setUrl(String url) {
        this.url = url;
        return this;

    }

    public String[] getUrls() {
        return urls;
    }

    /** WMS service urls. Use this instead of url when the WMS supports multiple urls for GetMap requests
     *
     * @param urls
     */
    public OLTileWMSSourceOptions setUrls(String[] urls) {
        this.urls = urls;
        return this;

    }

    public Double getGutter() {
        return gutter;
    }

    /** The size in pixels of the gutter around image tiles to ignore.
     *
     * @param gutter
     */
    public OLTileWMSSourceOptions setGutter(Double gutter) {
        this.gutter = gutter;
        return this;

    }

    public Double getMaxZoom() {
        return maxZoom;
    }

    /** Max zoom level
     *
     * @param maxZoom
     */
    public OLTileWMSSourceOptions setMaxZoom(Double maxZoom) {
        this.maxZoom = maxZoom;
        return this;

    }

    public Map<String, String> getParams() {
        return params;
    }

    /** WMS request parameters. At least a LAYERS param is required. STYLES is '' by default. VERSION is 1.3.0 by default. WIDTH, HEIGHT, BBOX and CRS (SRS for WMS version &lt; 1.3.0) will be set dynamically.
     *
     * @param params
     */
    public OLTileWMSSourceOptions setParams(Map<String, String> params) {
        this.params = params;
        return this;

    }

    public OLTileGrid getTileGrid() {
        return tileGrid;
    }

    public OLTileWMSSourceOptions setTileGrid(OLTileGrid tileGrid) {
        this.tileGrid = tileGrid;
        return this;

    }

    public String getProjection() {
        return projection;
    }

    /** Sets the csr name of the used projection
     *
     * @param projection
     */
    public OLTileWMSSourceOptions setProjection(String projection) {
        this.projection = projection;
        return this;

    }

}
