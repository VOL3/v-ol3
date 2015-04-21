package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLTileGrid;
import org.vaadin.addon.vol3.client.source.OLWMTSSourceState;

/**
 * Layer source for tile data from WMTS servers
 * Created by Vaadin Ltd / mjhosio on 21/04/15.
 */
public class OLWMTSSource extends OLSource{
	/** Creates a new instance of the layer data source
	 *
	 */
	public OLWMTSSource(){
		super();
	}

	/** Creates a new instance of the layer data source
	 *
	 * @param options options for the data source
	 */
	public OLWMTSSource(OLWMTSSourceOptions options){
		this();
		setOptions(options);
	}

	@Override
	protected OLWMTSSourceState getState() {
		return (OLWMTSSourceState) super.getState();
	}

	@Override
	protected OLWMTSSourceState getState(boolean markAsDirty) {
		return (OLWMTSSourceState) super.getState(markAsDirty);
	}

	private void setOptions(OLWMTSSourceOptions options) {
		getState().attributions=options.getAttributions();
		getState().crossOriginPolicy=options.getCrossOriginPolicy();
		getState().projection=options.getProjection();
		getState().logo=options.getLogo();
		getState().url=options.getUrl();
		getState().urls=options.getUrls();
		getState().maxZoom=options.getMaxZoom();
		getState().tileGrid=options.getTileGrid();
		getState().requestEncoding=options.getRequestEncoding();
		getState().layer=options.getLayer();
		getState().style=options.getStyle();
		getState().tilePixelRatio=options.getTilePixelRatio();
		getState().version=options.getVersion();
		getState().format=options.getFormat();
		getState().matrixSet=options.getMatrixSet();
		getState().wrapX=options.getWrapX();
		getState().opaque=options.getOpaque();
	}

	public String[] getAttributions() {
		return getState(false).attributions;
	}

	public String getCrossOriginPolicy() {
		return getState(false).crossOriginPolicy;
	}

	public String getProjection() {
		return getState(false).projection;
	}

	public String getLogo() {
		return getState(false).logo;
	}

	public String getUrl() {
		return getState(false).url;
	}

	public String[] getUrls() {
		return getState(false).urls;
	}

	public Double getMaxZoom() {
		return getState(false).maxZoom;
	}

	public OLTileGrid getTileGrid(){
		return getState(false).tileGrid;
	}

	public String getRequestEncoding(){
		return getState(false).requestEncoding;
	}

	public String getLayer(){
		return getState(false).layer;
	}

	public String getStyle(){
		return getState(false).style;
	}

	public Double getTilePixelRatio(){
		return getState(false).tilePixelRatio;
	}

	public String getVersion(){
		return getState(false).version;
	}

	public String getFormat(){
		return getState(false).format;
	}

	public String getMatrixSet(){
		return getState(false).matrixSet;
	}

	public Boolean getWrapX(){
		return getState(false).wrapX;
	}

	public Boolean getOpaque(){
		return getState(false).opaque;
	}
}
