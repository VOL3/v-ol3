package org.vaadin.addon.vol3.layer;

import org.vaadin.addon.vol3.client.layer.OLTileLayerState;
import org.vaadin.addon.vol3.source.OLSource;

/**
 *
 * Layer for layer sources that provide pre-rendered, tiled images in grids that are organized by zoom levels for specific resolutions.
 * Created by mjhosio on 30/06/14.
 */
public class OLTileLayer extends OLLayer {

    public OLTileLayer(OLSource source){
        this(source,null);
    }

    public OLTileLayer(OLSource source, OLTileLayerOptions options) {
        super(source, options);
    }

    @Override
    protected OLTileLayerState getState() {
        return (OLTileLayerState) super.getState();
    }

    @Override
    protected OLTileLayerState getState(boolean markAsDirty) {
        return (OLTileLayerState) super.getState(markAsDirty);
    }

    protected void setOptions(OLTileLayerOptions options) {
        super.setOptions(options);
        getState().useInterimTilesOnError=options.getUseInterimTilesOnError();
        getState().preload=options.getPreload();
    }

    /** Returns true if the interim tiles are loaded on error
     *
     * @return
     */
    public Boolean getUseInterimTilesOnError(){
        return getState(false).useInterimTilesOnError;
    }

    /** Gets the level up to the tiles are preloaded
     *
     * @return
     */
    public Integer getPreload(){
        return getState(false).preload;
    }

}
