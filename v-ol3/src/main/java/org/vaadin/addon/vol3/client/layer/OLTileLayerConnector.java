package org.vaadin.addon.vol3.client.layer;

import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.layer.OLTileLayer;
import org.vaadin.gwtol3.client.layer.Layer;
import org.vaadin.gwtol3.client.layer.TileLayer;
import org.vaadin.gwtol3.client.layer.TileOptions;
import org.vaadin.gwtol3.client.source.Source;

/**
 * Client-side connector for the tile layer
 */
@Connect (OLTileLayer.class)
public class OLTileLayerConnector extends OLLayerConnector {

    protected Layer createLayer(Source source){
        TileOptions opts=TileOptions.create();
        if(getState().useInterimTilesOnError!=null){
            opts.setUseInterimTilesOnError(getState().useInterimTilesOnError);
        }
        if(getState().preload!=null){
            opts.setPreload(getState().preload);
        }
        if (getState().title != null) {
            opts.setTitle(getState().title);
        }
        opts.setSource(source);
        return TileLayer.create(opts);
    }

    @Override
    public OLTileLayerState getState() {
        return (OLTileLayerState) super.getState();
    }
}
