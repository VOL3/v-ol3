package org.vaadin.addon.vol3.layer;

import org.vaadin.addon.vol3.client.layer.OLTileState;
import org.vaadin.addon.vol3.source.OLSource;

/**
 *
 * Layer for layer sources that provide pre-rendered, tiled images in grids that are organized by zoom levels for specific resolutions.
 * Created by mjhosio on 30/06/14.
 */
public class OLTile extends OLLayer {

    public OLTile(OLSource source){
        this(source,null);
    }

    public OLTile(OLSource source, OLTileOptions options) {
        super(source);
        if(options!=null){
            setOptions(options);
        }
    }

    @Override
    protected OLTileState getState() {
        return (OLTileState) super.getState();
    }

    @Override
    protected OLTileState getState(boolean markAsDirty) {
        return (OLTileState) super.getState(markAsDirty);
    }

    private void setOptions(OLTileOptions options) {
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
