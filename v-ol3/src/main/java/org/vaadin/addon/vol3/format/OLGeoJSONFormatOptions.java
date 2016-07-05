package org.vaadin.addon.vol3.format;

/**
 * Created by Vaadin Ltd / mjhosio on 14/06/16.
 */
public class OLGeoJSONFormatOptions extends OLFeatureFormatOptions {
	private String defaultDataProjection;

	public String getDefaultDataProjection() {
		return defaultDataProjection;
	}

	public void setDefaultDataProjection(String defaultDataProjection) {
		this.defaultDataProjection = defaultDataProjection;
	}
}
