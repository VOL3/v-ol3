package org.vaadin.addon.vol3.client.source;

/**
 * Created by Vaadin Ltd / mjhosio on 21/04/15.
 */
public class OLWMTSSourceState extends OLSourceState {
	public String [] attributions;
	public String crossOriginPolicy;
	public String logo;
	// tilegrid for the source
	public OLTileGrid tileGrid;
	// crs name of the projection
	public String projection;
	// Request encoding. Default is KVP.
	public String requestEncoding;
	// requested layer
	public String layer;
	// style
	public String style;
	// The pixel ratio used by the tile service. For example, if the tile service advertizes 256px by 256px tiles but actually sends 512px by 512px images (for retina/hidpi devices) then tilePixelRatio should be set to 2. Default is 1.
	public Double tilePixelRatio;
	// WMTS version. Default is 1.0.0.
	public String version;
	// Image format. Default is image/jpeg
	public String format;
	// Matrix set
	public String matrixSet;
	// WMS service url
	public String url;
	// Max zoom level
	public Double maxZoom;
	// WMS service urls. Use this instead of url when the WMS supports multiple urls for GetMap requests
	public String [] urls;
	// Whether to wrap the world horizontally. Default is false.
	public Boolean wrapX;
	// whether the layer is opaque
	public Boolean opaque;
}
