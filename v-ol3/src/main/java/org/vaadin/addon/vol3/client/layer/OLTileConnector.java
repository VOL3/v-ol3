package org.vaadin.addon.vol3.client.layer;

import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.layer.OLTile;
import org.vaadin.gwtol3.client.layer.Tile;

/**
 * Created by mjhosio on 30/06/14.
 */
@Connect (OLTile.class)
public class OLTileConnector extends OLLayerConnector {

    private Tile tile;

    @Override
    public Tile getLayer() {
        if(tile==null){
            tile=Tile.create(super.getSource());
        }
        return tile;
    }
}
