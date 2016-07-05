package org.vaadin.addon.vol3.source;

/**
 * Options passed to OLVectorSource on creation
 */
public class OLVectorSourceOptions extends OLAbstractVectorSourceOptions {
	private String inputProjection;

	public String getInputProjection() {
		return inputProjection;
	}

	/** Sets the input projection for the vector source. The features added to this vector source must be in the given projection. The wrapper does the conversion to base map coordinates transparently. If omitted, the default is EPSG:4326.
	 *
	 * @param inputProjection the input projection to be used. EPSG:4326 by default.
	 */
	public OLVectorSourceOptions setInputProjection(String inputProjection) {
		this.inputProjection = inputProjection;
		return this;
	}

	public OLVectorSourceOptions setWrapX(Boolean wrapX) {
		return (OLVectorSourceOptions) super.setWrapX(wrapX);
	}

	public OLVectorSourceOptions setUseSpatialIndex(Boolean useSpatialIndex) {
		return (OLVectorSourceOptions) super.setUseSpatialIndex(useSpatialIndex);
	}
}
