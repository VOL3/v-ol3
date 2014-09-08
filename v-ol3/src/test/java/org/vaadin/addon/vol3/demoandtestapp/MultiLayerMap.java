package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.source.OLMapQuestLayerName;
import org.vaadin.addon.vol3.layer.OLTileLayer;
import org.vaadin.addon.vol3.source.OLMapQuestSource;
import org.vaadin.addon.vol3.source.OLSource;

/**
 * Map with multiple layers
 */
public class MultiLayerMap extends BasicMap {
    @Override
    protected OLMap createMap() {
        OLMap map=super.createMap();
        map.addLayer(new OLTileLayer(new OLMapQuestSource(OLMapQuestLayerName.HYB)));
        return map;
    }

    protected OLSource createSource(){
        return new OLMapQuestSource(OLMapQuestLayerName.SAT);
    }
}
