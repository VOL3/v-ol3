package org.vaadin.addon.vol3.source;

/**
 * Options passed to OLVectorSource on creation
 */
public class OLVectorSourceOptions extends OLSourceOptions {
	private String inputProjection;

	public String getInputProjection() {
		return inputProjection;
	}

	/** Sets the input projection for the vector source. The features added to this vector source must be in the given projection. The wrapper does the conversion to base map coordinates transparently. If omitted, the default is EPSG:4326.
	 *
	 * @param inputProjection the input projection to be used. EPSG:4326 by default.
	 */
	public void setInputProjection(String inputProjection) {
		this.inputProjection = inputProjection;
	}
}
