package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.control.OLLayerSwitcherControl;
import org.vaadin.addon.vol3.client.source.OLMapQuestLayerName;
import org.vaadin.addon.vol3.layer.OLLayer;
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
        OLLayer layer = new OLTileLayer(new OLMapQuestSource(OLMapQuestLayerName.HYB));
        layer.setTitle("MapQuest HYB");
        map.addLayer(layer);
        map.setLayerSwitcherControl(new OLLayerSwitcherControl());
        return map;
    }

    protected OLSource createSource(){
        return new OLMapQuestSource(OLMapQuestLayerName.SAT);
    }
}
