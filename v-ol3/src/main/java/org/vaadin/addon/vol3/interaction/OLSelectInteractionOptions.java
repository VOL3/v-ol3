package org.vaadin.addon.vol3.interaction;

import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.addon.vol3.layer.OLLayer;

import java.util.List;

/**
 * Options for the select interaction
 */
public class OLSelectInteractionOptions {
	private String condition;
    private List<OLLayer> layers;
    private List<OLStyle> styles;
    
    /** Gets the string specifying the OpenLayers condition that determines when the feature selection changes
     * 
     * @return
     */
    public String getCondition() {
    	return condition;
    }
    
    /** Sets the OpenLayers condition that determines when the feature selection changes. 
     * 
     * @param condition The name of the OpenLayers condition (eg altKeyOnly, pointerMove, etc)
     * @return
     */
    public OLSelectInteractionOptions setCondition(String condition) {
    	this.condition = condition;
    	return this;
    }

    /** Gets the layers where selections can be made.
     *
     * @return
     */
    public List<OLLayer> getLayers() {
        return layers;
    }

    /** Sets the layers where selections can be made. If not set, all visible layers are available for selection.
     * @param layers
     */
    public OLSelectInteractionOptions setLayers(List<OLLayer> layers) {
        this.layers = layers;
        return this;
    }

    /** Gets the styles used for the selected features
     *
     * @return
     */
    public List<OLStyle> getStyles() {
        return styles;
    }

    /** Sets the styles used for the selected features
     *
     * @param styles
     */
    public OLSelectInteractionOptions setStyles(List<OLStyle> styles) {
        this.styles = styles;
        return this;
    }
}
