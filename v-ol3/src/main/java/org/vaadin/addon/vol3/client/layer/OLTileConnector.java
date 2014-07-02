package org.vaadin.addon.vol3.client.layer;

import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.layer.OLTile;
import org.vaadin.gwtol3.client.layer.Tile;
import org.vaadin.gwtol3.client.layer.TileOptions;

/**
 * Created by mjhosio on 30/06/14.
 */
@Connect (OLTile.class)
public class OLTileConnector extends OLLayerConnector {

    private Tile tile;

    @Override
    public Tile getLayer() {
        if(tile==null){
            tile=createTile();
        }
        return tile;
    }

    private Tile createTile(){
        TileOptions opts=TileOptions.create();
        if(getState().useInterimTilesOnError!=null){
            opts.setUseInterimTilesOnError(getState().useInterimTilesOnError);
        }
        if(getState().preload!=null){
            opts.setPreload(getState().preload);
        }
        opts.setSource(super.getSource());
        return Tile.create(opts);
    }

    @Override
    public OLTileState getState() {
        return (OLTileState) super.getState();
    }
}
