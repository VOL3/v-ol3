package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLMapOptions;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.Projections;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.layer.OLTileLayer;
import org.vaadin.addon.vol3.layer.OLTileLayerOptions;
import org.vaadin.addon.vol3.source.OLSource;

import java.util.logging.Logger;

/**
 * Map with constrained view extent
 */
public class ConstrainedMap extends BasicMap {

    private static final Logger logger= Logger.getLogger(ConstrainedMap.class.getName());


    protected OLMap createMap(){
        OLMapOptions mapOpts=new OLMapOptions();
        mapOpts.setLoadTilesWhileAnimating(false);
        mapOpts.setLoadTilesWhileInteracting(false);
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
        opts.setInputProjection(Projections.EPSG4326);
        opts.setExtent(createExtent());
        return new OLTileLayer(source,opts);
    }

    protected OLView createView(){
        OLViewOptions viewOpts=new OLViewOptions();
        viewOpts.setMinZoom(5);
        viewOpts.setMaxZoom(20);
        viewOpts.setZoomFactor(2d);
        viewOpts.setInputProjection(Projections.EPSG4326);
        viewOpts.setExtent(createExtent());
        OLView view=new OLView(viewOpts);
        view.fitExtent(createExtent());
        return view;
    }

}
