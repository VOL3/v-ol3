package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLTileGrid;
import org.vaadin.addon.vol3.client.source.OLTileXYZSourceState;

/**
 * Layer source for an open street map tile server
 */
public class OLTileXYZSource extends OLXYZSource {

    /**
     * Creates a new instance of the Open Street Map source
     */
    public OLTileXYZSource() {
        super();
    }

    /**
     * Creates a new instance of the Open Street Map source
     *
     * @param options options for the source
     */
    public OLTileXYZSource(OLTileXYZSourceOptions options) {
        this();
        setOptions(options);
    }

    @Override
    protected OLTileXYZSourceState getState() {
        return (OLTileXYZSourceState) super.getState();
    }

    @Override
    protected OLTileXYZSourceState getState(boolean markAsDirty) {
        return (OLTileXYZSourceState) super.getState(markAsDirty);
    }

    private void setOptions(OLTileXYZSourceOptions options) {
        getState().customAttributions = options.getCustomAttributions();
        getState().crossOriginPolicy = options.getCrossOriginPolicy();
        getState().showOSMAttributions = options.getShowAttributions();
        getState().maxZoom = options.getMaxZoom();
        getState().minZoom = options.getMinZoom();
        getState().tileGrid = options.getTileGrid();
    }

    public Boolean getShowAttributions() {
        return getState(false).showOSMAttributions;
    }

    public String[] getCustomAttributions() {
        return getState(false).customAttributions;
    }

    public Integer getMaxZoom() {
        return getState(false).maxZoom;
    }

    public Integer getMinZoom() {
        return getState(false).minZoom;
    }

    public String getCrossOriginPolicy() {
        return getState(false).crossOriginPolicy;
    }

    public void setTileGrid(OLTileGrid tileGrid) {
        getState().tileGrid = tileGrid;
    }

    public void setProjection(String projection) {
        getState().projection = projection;
    }
}
