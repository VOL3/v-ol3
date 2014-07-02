package org.vaadin.addon.vol3.client.layer;

import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.layer.OLTileLayer;
import org.vaadin.gwtol3.client.layer.TileLayer;
import org.vaadin.gwtol3.client.layer.TileOptions;

/**
 * Created by mjhosio on 30/06/14.
 */
@Connect (OLTileLayer.class)
public class OLTileLayerConnector extends OLLayerConnector {

    private TileLayer tile;

    @Override
    public TileLayer getLayer() {
        if(tile==null){
            tile=createTile();
        }
        return tile;
    }

    private TileLayer createTile(){
        TileOptions opts=TileOptions.create();
        if(getState().useInterimTilesOnError!=null){
            opts.setUseInterimTilesOnError(getState().useInterimTilesOnError);
        }
        if(getState().preload!=null){
            opts.setPreload(getState().preload);
        }
        opts.setSource(super.getSource());
        return TileLayer.create(opts);
    }

    @Override
    public OLTileLayerState getState() {
        return (OLTileLayerState) super.getState();
    }
}
