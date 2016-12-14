package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLTileGrid;

/**
 * Options provided to the osm tile source on creation
 */
public class OLTileXYZSourceOptions {
    private Boolean showAttributions;
    private String [] customAttributions;
    private Integer maxZoom;
    private Integer minZoom;
    private String crossOriginPolicy;
    private OLTileGrid tileGrid;

    /** Show osm attributions
     *
     * @param showAttributions
     */
    public OLTileXYZSourceOptions setShowAttributions(Boolean showAttributions) {
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
    public OLTileXYZSourceOptions setCustomAttributions(String[] customAttributions) {
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
    public OLTileXYZSourceOptions setMaxZoom(Integer maxZoom) {
        this.maxZoom = maxZoom;
        return this;
    }

    public Integer getMinZoom() {
        return minZoom;
    }

    /** Set the minimum zoom level
     *
     * @param minZoom
     */
    public OLTileXYZSourceOptions setMinZoom(Integer minZoom) {
        this.minZoom = minZoom;
        return this;
    }

    public String getCrossOriginPolicy() {
        return crossOriginPolicy;
    }

    /** Sets the cross origin policy for the loaded tiles. 'anonymous' by default.
     *
     * @param crossOriginPolicy
     */
    public OLTileXYZSourceOptions setCrossOriginPolicy(String crossOriginPolicy) {
        this.crossOriginPolicy = crossOriginPolicy;
        return this;
    }

    public OLTileGrid getTileGrid() {
        return tileGrid;
    }

    public OLTileXYZSourceOptions setTileGrid(OLTileGrid tileGrid) {
        this.tileGrid = tileGrid;
        return this;

    }
}
