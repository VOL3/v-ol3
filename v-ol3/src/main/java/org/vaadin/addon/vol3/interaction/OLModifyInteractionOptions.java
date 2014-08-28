package org.vaadin.addon.vol3.interaction;

import org.vaadin.addon.vol3.client.style.OLStyle;

import java.util.List;

/**
 * Created by mjhosio on 25/08/14.
 */
public class OLModifyInteractionOptions {
    // Pixel tolerance for considering the pointer close enough to a segment or vertex for editing. Default is 10 pixels.
    private Double pixelTolerance;
    // The FeatureOverlay style
    private List<OLStyle> styles;

    /** Gets pixel tolerance for considering the pointer close enough to a segment or vertex for editing.
     *
     * @return
     */
    public Double getPixelTolerance() {
        return pixelTolerance;
    }

    /** Sets pixel tolerance for considering the pointer close enough to a segment or vertex for editing. Default is 10 pixels.
     *
     * @param pixelTolerance
     */
    public void setPixelTolerance(Double pixelTolerance) {
        this.pixelTolerance = pixelTolerance;
    }

    /** Gets the FeatureOverlay style
     *
     * @return
     */
    public List<OLStyle> getStyles() {
        return styles;
    }

    /** Sets the FeatureOverlay style
     *
     * @param styles
     */
    public void setStyles(List<OLStyle> styles) {
        this.styles = styles;
    }
}
