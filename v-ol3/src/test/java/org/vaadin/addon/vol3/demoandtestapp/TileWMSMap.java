package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.Projections;
import org.vaadin.addon.vol3.source.OLSource;
import org.vaadin.addon.vol3.source.OLTileWMSSource;
import org.vaadin.addon.vol3.source.OLTileWMSSourceOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * Map for testing TileWMS sources
 */
public class TileWMSMap extends BasicMap{
    @Override
    protected OLSource createSource() {
        OLTileWMSSourceOptions options =new OLTileWMSSourceOptions();
        // WebMapService of World http://www.osm-wms.de/
        options.setUrl("http://129.206.228.72/cached/osm");
        Map<String,String> params=new HashMap<String,String>();
        params.put("LAYERS","osm_auto:all");
        params.put("FORMAT","image/png");
        options.setParams(params);
        options.setGutter(2.0);
        return new OLTileWMSSource(options);
    }

    @Override
    protected OLView createView() {
        OLViewOptions opts=new OLViewOptions();
        // this is the projection this map server expects
        // same as EPSG: 3857 but the map server does not recognize that...
        opts.setMapProjection("EPSG:900913");
        opts.setInputProjection(Projections.EPSG4326);
        OLView view=new OLView(opts);
        view.setZoom(1);
        view.setCenter(0,0);
        return view;
    }
}
