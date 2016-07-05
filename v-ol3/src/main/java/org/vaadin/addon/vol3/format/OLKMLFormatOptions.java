package org.vaadin.addon.vol3.format;

/**
 * Created by Vaadin Ltd / mjhosio on 14/06/16.
 */
public class OLKMLFormatOptions extends OLFeatureFormatOptions{
	Boolean extractStyles;
	Boolean showPointNames;
	Boolean extractAttributes;

	public Boolean getExtractStyles() {
		return extractStyles;
	}

	public void setExtractStyles(Boolean extractStyles) {
		this.extractStyles = extractStyles;
	}

	public Boolean getShowPointNames() {
		return showPointNames;
	}

	public void setShowPointNames(Boolean showPointNames) {
		this.showPointNames = showPointNames;
	}
}
