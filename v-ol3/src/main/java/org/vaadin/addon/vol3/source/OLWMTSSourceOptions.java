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

	public void setAttributions(String[] attributions) {
		this.attributions = attributions;
	}

	public String getCrossOriginPolicy() {
		return crossOriginPolicy;
	}

	public void setCrossOriginPolicy(String crossOriginPolicy) {
		this.crossOriginPolicy = crossOriginPolicy;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public OLTileGrid getTileGrid() {
		return tileGrid;
	}

	public void setTileGrid(OLTileGrid tileGrid) {
		this.tileGrid = tileGrid;
	}

	public String getProjection() {
		return projection;
	}

	public void setProjection(String projection) {
		this.projection = projection;
	}

	public String getRequestEncoding() {
		return requestEncoding;
	}

	public void setRequestEncoding(String requestEncoding) {
		this.requestEncoding = requestEncoding;
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Double getTilePixelRatio() {
		return tilePixelRatio;
	}

	public void setTilePixelRatio(Double tilePixelRatio) {
		this.tilePixelRatio = tilePixelRatio;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getMatrixSet() {
		return matrixSet;
	}

	public void setMatrixSet(String matrixSet) {
		this.matrixSet = matrixSet;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getMaxZoom() {
		return maxZoom;
	}

	public void setMaxZoom(Double maxZoom) {
		this.maxZoom = maxZoom;
	}

	public String[] getUrls() {
		return urls;
	}

	public void setUrls(String[] urls) {
		this.urls = urls;
	}

	public Boolean getWrapX() {
		return wrapX;
	}

	public void setWrapX(Boolean wrapX) {
		this.wrapX = wrapX;
	}

	public Boolean getOpaque() {
		return opaque;
	}

	public void setOpaque(Boolean opaque) {
		this.opaque = opaque;
	}
}
