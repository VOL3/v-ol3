package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.Projections;
import org.vaadin.addon.vol3.client.control.*;

/**
 * Created by mjhosio on 11/07/14.
 */
public class ControlTestMap extends BasicMap {
    @Override
    protected OLMap createMap() {
        OLMap map=super.createMap();
        map.setFullScreenControl(new OLFullScreenControl());
        OLMousePositionControl mousePos=new OLMousePositionControl();
        mousePos.projection = Projections.EPSG4326;
        map.setMousePositionControl(mousePos);
        map.setScaleLineControl(new OLScaleLineControl());
        map.setZoomSliderControl(new OLZoomSliderControl());
        map.setZoomToExtentControl(new OLZoomToExtentControl());
        return map;
    }
}
