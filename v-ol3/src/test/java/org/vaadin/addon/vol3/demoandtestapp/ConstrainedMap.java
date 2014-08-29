package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLMapOptions;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.OLDeviceOptions;
import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.layer.OLTileLayer;
import org.vaadin.addon.vol3.layer.OLTileLayerOptions;
import org.vaadin.addon.vol3.source.OLSource;

/**
 * Created by mjhosio on 01/07/14.
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
        OLExtent extent=new OLExtent();
        extent.minX=0;
        extent.maxX=3000000;
        extent.minY=6000000;
        extent.maxY=10000000;
        viewOpts.setExtent(extent);
// failed to load tiles due to cross-origin policy if this is set
//        viewOpts.setProjection("EPSG:4326");
        OLView view=new OLView(viewOpts);
        view.setZoom(3);
//        view.setCenter(60.452372, 22.299801);
        view.setCenter(2482402.4921113327, 8501149.592492584);
        return view;
    }
}
