package org.vaadin.addon.vol3.format;

/**
 * Created by Vaadin Ltd / mjhosio on 05/07/16.
 */
public class OLWFSFormatOptions extends OLFeatureFormatOptions {
	private String featureNS;
	private String featureType;
	private String schemaLocation;

	public String getFeatureNS() {
		return featureNS;
	}

	public void setFeatureNS(String featureNS) {
		this.featureNS = featureNS;
	}

	public String getFeatureType() {
		return featureType;
	}

	public void setFeatureType(String featureType) {
		this.featureType = featureType;
	}

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}
}
