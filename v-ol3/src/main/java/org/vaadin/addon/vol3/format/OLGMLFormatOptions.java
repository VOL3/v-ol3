package org.vaadin.addon.vol3.format;

/**
 * Created by Vaadin Ltd / mjhosio on 14/06/16.
 */
public class OLGMLFormatOptions extends OLFeatureFormatOptions {
	private String featureNS;
	private String featureType;
	private String srsName;
	private Boolean surface;
	private Boolean curve;
	private Boolean multiCurve;
	private Boolean multiSurface;
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

	public String getSrsName() {
		return srsName;
	}

	public void setSrsName(String srsName) {
		this.srsName = srsName;
	}

	public Boolean getSurface() {
		return surface;
	}

	public void setSurface(Boolean surface) {
		this.surface = surface;
	}

	public Boolean getCurve() {
		return curve;
	}

	public void setCurve(Boolean curve) {
		this.curve = curve;
	}

	public Boolean getMultiCurve() {
		return multiCurve;
	}

	public void setMultiCurve(Boolean multiCurve) {
		this.multiCurve = multiCurve;
	}

	public Boolean getMultiSurface() {
		return multiSurface;
	}

	public void setMultiSurface(Boolean multiSurface) {
		this.multiSurface = multiSurface;
	}

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}
}
