package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLMapOptions;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.OLDeviceOptions;
import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.Projections;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.layer.OLTileLayer;
import org.vaadin.addon.vol3.layer.OLTileLayerOptions;
import org.vaadin.addon.vol3.source.OLSource;

/**
 * Map with constrained view extent
 */
public class ConstrainedMap extends BasicMap {

    protected OLMap createMap(){
        OLMapOptions mapOpts=new OLMapOptions();
        OLDeviceOptions dopts=new OLDeviceOptions();
        dopts.loadTilesWhileAnimating=false;
        dopts.loadTilesWhileInteracting=false;
        mapOpts.setDeviceOptions(dopts);
        mapOpts.setShowOl3Logo(false);
        OLMap map=new OLMap(mapOpts);
        OLLayer layer=createLayer(createSource());
        map.addLayer(layer);
        map.setView(createView());
        map.setSizeFull();
        return map;
    }

    protected OLLayer createLayer(OLSource source){
        OLTileLayerOptions opts=new OLTileLayerOptions();
        opts.setPreload(4);
        opts.setUseInterimTilesOnError(false);
        return new OLTileLayer(source,opts);
    }

    protected OLView createView(){
        OLViewOptions viewOpts=new OLViewOptions();
        viewOpts.setMinZoom(3);
        viewOpts.setMaxZoom(20);
        viewOpts.setZoomFactor(2d);
        viewOpts.setInputProjection(Projections.EPSG4326);
        OLExtent extent=new OLExtent();
        extent.minX=19.0;
        extent.maxX=32.0;
        extent.minY=60.0;
        extent.maxY=70.0;
        viewOpts.setExtent(extent);
        OLView view=new OLView(viewOpts);
        view.setZoom(8);
        view.setCenter(22.299801, 60.452372);
        return view;
    }
}
