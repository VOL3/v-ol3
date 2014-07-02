package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.layer.OLTile;
import org.vaadin.addon.vol3.source.OLMapQuest;
import org.vaadin.addon.vol3.source.OLSource;

/**
 * Created by mjhosio on 02/07/14.
 */
public class MultiLayer extends BasicMapInitialization{
    @Override
    protected OLMap createMap() {
        OLMap map=super.createMap();
        map.addLayer(new OLTile(new OLMapQuest(OLMapQuest.LAYER_HYB)));
        return map;
    }

    protected OLSource createSource(){
        return new OLMapQuest(OLMapQuest.LAYER_SAT);
    }
}
