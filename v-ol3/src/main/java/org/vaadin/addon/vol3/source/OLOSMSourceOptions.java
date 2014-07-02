package org.vaadin.addon.vol3.source;

/**
 * Options provided to the osm tile source on creation
 * Created by mjhosio on 02/07/14.
 */
public class OLOSMSourceOptions {
    private Boolean showDataAttributions;
    private Boolean showTileAttributions;
    private String [] customAttributions;
    private Integer maxZoom;
    private String crossOriginPolicy;

    public Boolean getShowDataAttributions() {
        return showDataAttributions;
    }

    /** Show osm data attributions
     *
     * @param showDataAttributions
     */
    public void setShowDataAttributions(Boolean showDataAttributions) {
        this.showDataAttributions = showDataAttributions;
    }

    public Boolean getShowTileAttributions() {
        return showTileAttributions;
    }

    /** Show osm tile attributions
     *
     * @param showTileAttributions
     */
    public void setShowTileAttributions(Boolean showTileAttributions) {
        this.showTileAttributions = showTileAttributions;
    }

    public String[] getCustomAttributions() {
        return customAttributions;
    }

    /** Custom attributions to be shown
     *
     * @param customAttributions
     */
    public void setCustomAttributions(String[] customAttributions) {
        this.customAttributions = customAttributions;
    }

    public Integer getMaxZoom() {
        return maxZoom;
    }

    /** Set the maximum zoom level
     *
     * @param maxZoom
     */
    public void setMaxZoom(Integer maxZoom) {
        this.maxZoom = maxZoom;
    }

    public String getCrossOriginPolicy() {
        return crossOriginPolicy;
    }

    /** Sets the cross origin policy for the loaded tiles. 'anonymous' by default.
     *
     * @param crossOriginPolicy
     */
    public void setCrossOriginPolicy(String crossOriginPolicy) {
        this.crossOriginPolicy = crossOriginPolicy;
    }
}
