package org.vaadin.addon.vol3.client.source;

import java.util.Map;

/**
 * Created by mjhosio on 03/07/14.
 */
public class OLImageWMSSourceState extends OLSourceState {
    public String [] attributions;
    public String crossOriginPolicy;
    // crs name of the projection
    public String projection;
    //Use the Map.pixelRatio value when requesting the image from the remote server
    public Boolean hidpi;
    // The type of the remote WMS server: mapserver, geoserver or qgis
    public String serverType;
    public String logo;
    //Ratio. 1 means image requests are the size of the map viewport, 2 means twice the size of the map viewport, and so on. Default is 1.5.
    public Double ratio;
    // Resolutions. If specified, requests will be made for these resolutions only.
    public double [] resolutions;
    // WMS service url
    public String url;
    // WMS request parameters. At least a LAYERS param is required. STYLES is '' by default. VERSION is 1.3.0 by default. WIDTH, HEIGHT, BBOX and CRS (SRS for WMS version < 1.3.0) will be set dynamically.
    public Map<String,String> params;
}
