package org.vaadin.addon.vol3.format;

/**
 * Created by Vaadin Ltd / mjhosio on 05/07/16.
 */
public class OLMVTFormatOptions extends OLFeatureFormatOptions {
	private String geometryName;
	private String layerName;
	private String [] layers;
	private Boolean editable;

	public String getGeometryName() {
		return geometryName;
	}

	public void setGeometryName(String geometryName) {
		this.geometryName = geometryName;
	}

	public String getLayerName() {
		return layerName;
	}

	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	public String[] getLayers() {
		return layers;
	}

	public void setLayers(String[] layers) {
		this.layers = layers;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
}
