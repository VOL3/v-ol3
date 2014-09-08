package org.vaadin.addon.vol3.interaction;

import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.addon.vol3.layer.OLLayer;

import java.util.List;

/**
 * Options for the select interaction
 */
public class OLSelectInteractionOptions {
    private List<OLLayer> layers;
    private List<OLStyle> styles;

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
    public void setLayers(List<OLLayer> layers) {
        this.layers = layers;
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
    public void setStyles(List<OLStyle> styles) {
        this.styles = styles;
    }
}
