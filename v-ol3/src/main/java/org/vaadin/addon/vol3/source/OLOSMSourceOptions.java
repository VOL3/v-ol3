package org.vaadin.addon.vol3.source;

/**
 * Options provided to the osm tile source on creation
 */
public class OLOSMSourceOptions {
    private Boolean showAttributions;
    private String [] customAttributions;
    private Integer maxZoom;
    private String crossOriginPolicy;

    /** Show osm attributions
     *
     * @param showAttributions
     */
    public OLOSMSourceOptions setShowAttributions(Boolean showAttributions) {
        this.showAttributions = showAttributions;
        return this;
    }

    public Boolean getShowAttributions() {
        return showAttributions;
    }

    public String[] getCustomAttributions() {
        return customAttributions;
    }

    /** Custom attributions to be shown
     *
     * @param customAttributions
     */
    public OLOSMSourceOptions setCustomAttributions(String[] customAttributions) {
        this.customAttributions = customAttributions;
        return this;
    }

    public Integer getMaxZoom() {
        return maxZoom;
    }

    /** Set the maximum zoom level
     *
     * @param maxZoom
     */
    public OLOSMSourceOptions setMaxZoom(Integer maxZoom) {
        this.maxZoom = maxZoom;
        return this;
    }

    public String getCrossOriginPolicy() {
        return crossOriginPolicy;
    }

    /** Sets the cross origin policy for the loaded tiles. 'anonymous' by default.
     *
     * @param crossOriginPolicy
     */
    public OLOSMSourceOptions setCrossOriginPolicy(String crossOriginPolicy) {
        this.crossOriginPolicy = crossOriginPolicy;
        return this;
    }
}
