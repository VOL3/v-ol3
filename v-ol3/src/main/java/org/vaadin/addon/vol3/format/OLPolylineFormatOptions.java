package org.vaadin.addon.vol3.format;

/**
 * Created by Vaadin Ltd / mjhosio on 05/07/16.
 */
public class OLPolylineFormatOptions extends OLFeatureFormatOptions {
	private String factor;
	private String geometryLayout;

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public String getGeometryLayout() {
		return geometryLayout;
	}

	public void setGeometryLayout(String geometryLayout) {
		this.geometryLayout = geometryLayout;
	}
}
