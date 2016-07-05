package org.vaadin.addon.vol3.format;

/**
 * Created by Vaadin Ltd / mjhosio on 05/07/16.
 */
public class OLTopoJSONFormatOptions extends OLFeatureFormatOptions {
	private String defaultDataProjection;

	public String getDefaultDataProjection() {
		return defaultDataProjection;
	}

	public void setDefaultDataProjection(String defaultDataProjection) {
		this.defaultDataProjection = defaultDataProjection;
	}
}
