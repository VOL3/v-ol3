package org.vaadin.addon.vol3.format;

/**
 * Created by Vaadin Ltd / mjhosio on 14/06/16.
 */
public class OLEsriJSONFormatOptions extends OLFeatureFormatOptions{
	private String geometryName;

	public String getGeometryName() {
		return geometryName;
	}

	public void setGeometryName(String geometryName) {
		this.geometryName = geometryName;
	}
}
