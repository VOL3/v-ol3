package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLTileGrid;

/**
 * Created by Vaadin Ltd / mjhosio on 21/04/15.
 */
public class OLWMTSSourceOptions {
	private String [] attributions;
	private String crossOriginPolicy;
	private String logo;
	// tilegrid for the source
	private OLTileGrid tileGrid;
	// crs name of the projection
	private String projection;
	// Request encoding. Default is KVP.
	private String requestEncoding;
	// requested layer
	private String layer;
	// style
	private String style;
	// The pixel ratio used by the tile service. For example, if the tile service advertizes 256px by 256px tiles but actually sends 512px by 512px images (for retina/hidpi devices) then tilePixelRatio should be set to 2. Default is 1.
	private Double tilePixelRatio;
	// WMTS version. Default is 1.0.0.
	private String version;
	// Image format. Default is image/jpeg
	private String format;
	// Matrix set
	private String matrixSet;
	// WMS service url
	private String url;
	// Max zoom level
	private Double maxZoom;
	// WMS service urls. Use this instead of url when the WMS supports multiple urls for GetMap requests
	private String [] urls;
	// Whether to wrap the world horizontally. Default is false.
	private Boolean wrapX;
	// whether the layer is opaque
	private Boolean opaque;

	public String[] getAttributions() {
		return attributions;
	}

	public OLWMTSSourceOptions setAttributions(String[] attributions) {
		this.attributions = attributions;
		return this;
	}

	public String getCrossOriginPolicy() {
		return crossOriginPolicy;
	}

	public OLWMTSSourceOptions setCrossOriginPolicy(String crossOriginPolicy) {
		this.crossOriginPolicy = crossOriginPolicy;
		return this;
	}

	public String getLogo() {
		return logo;
	}

	public OLWMTSSourceOptions setLogo(String logo) {
		this.logo = logo;
		return this;
	}

	public OLTileGrid getTileGrid() {
		return tileGrid;
	}

	public OLWMTSSourceOptions setTileGrid(OLTileGrid tileGrid) {
		this.tileGrid = tileGrid;
		return this;
	}

	public String getProjection() {
		return projection;
	}

	public OLWMTSSourceOptions setProjection(String projection) {
		this.projection = projection;
		return this;
	}

	public String getRequestEncoding() {
		return requestEncoding;
	}

	public OLWMTSSourceOptions setRequestEncoding(String requestEncoding) {
		this.requestEncoding = requestEncoding;
		return this;
	}

	public String getLayer() {
		return layer;
	}

	public OLWMTSSourceOptions setLayer(String layer) {
		this.layer = layer;
		return this;
	}

	public String getStyle() {
		return style;
	}

	public OLWMTSSourceOptions setStyle(String style) {
		this.style = style;
		return this;
	}

	public Double getTilePixelRatio() {
		return tilePixelRatio;
	}

	public OLWMTSSourceOptions setTilePixelRatio(Double tilePixelRatio) {
		this.tilePixelRatio = tilePixelRatio;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public OLWMTSSourceOptions setVersion(String version) {
		this.version = version;
		return this;
	}

	public String getFormat() {
		return format;
	}

	public OLWMTSSourceOptions setFormat(String format) {
		this.format = format;
		return this;
	}

	public String getMatrixSet() {
		return matrixSet;
	}

	public OLWMTSSourceOptions setMatrixSet(String matrixSet) {
		this.matrixSet = matrixSet;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public OLWMTSSourceOptions setUrl(String url) {
		this.url = url;
		return this;
	}

	public Double getMaxZoom() {
		return maxZoom;
	}

	public OLWMTSSourceOptions setMaxZoom(Double maxZoom) {
		this.maxZoom = maxZoom;
		return this;
	}

	public String[] getUrls() {
		return urls;
	}

	public OLWMTSSourceOptions setUrls(String[] urls) {
		this.urls = urls;
		return this;
	}

	public Boolean getWrapX() {
		return wrapX;
	}

	public OLWMTSSourceOptions setWrapX(Boolean wrapX) {
		this.wrapX = wrapX;
		return this;
	}

	public Boolean getOpaque() {
		return opaque;
	}

	public OLWMTSSourceOptions setOpaque(Boolean opaque) {
		this.opaque = opaque;
		return this;
	}
}
