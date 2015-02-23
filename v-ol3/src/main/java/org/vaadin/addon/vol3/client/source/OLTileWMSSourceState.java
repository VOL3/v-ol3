package org.vaadin.addon.vol3.client.source;

import java.util.Map;

import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.tilegrid.OLTileGrid;
import org.vaadin.gwtol3.client.tilegrid.TileGrid;

/**
 * Shared state for the OLTileWMSSource
 */
public class OLTileWMSSourceState extends OLSourceState{
    public String [] attributions;
    public String crossOriginPolicy;
    // crs name of the projection
    public String projection;
    //Use the Map.pixelRatio value when requesting the image from the remote server
    public Boolean hidpi;
    // The type of the remote WMS server: mapserver, geoserver or qgis. Used when hidpi=true.
    public String serverType;
    public String logo;
    // WMS service url
    public String url;
    // WMS service urls. Use this instead of url when the WMS supports multiple urls for GetMap requests
    public String [] urls;
    // The size in pixels of the gutter around image tiles to ignore.
    public Double gutter;
    // Max zoom level
    public Double maxZoom;
    // WMS request parameters. At least a LAYERS param is required. STYLES is '' by default. VERSION is 1.3.0 by default. WIDTH, HEIGHT, BBOX and CRS (SRS for WMS version < 1.3.0) will be set dynamically.
    public Map<String,String> params;
    
    
    //WMTS TILE OPTIONS CLASS STATE
	public Double WMTSTileGridOptionsOriginX;
	public Double WMTSTileGridOptionsOriginY;
	public Double[] WMTSTileGridOptionsresolutions;
	
	//public String[] matrixIds;
	
	public Double WMTSTileGridOptionsTileSize;
	public Double[] WMTSTileGridOptionsTileSizes;
		
}
