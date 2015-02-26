package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.Projections;
import org.vaadin.addon.vol3.layer.OLImageLayer;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.source.OLImageWMSSource;
import org.vaadin.addon.vol3.source.OLImageWMSSourceOptions;
import org.vaadin.addon.vol3.source.OLSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Map for testing ImageWMS source
 */
public class ImageWMSMap extends BasicMap {
    @Override
    protected OLSource createSource() {
        OLImageWMSSourceOptions options=new OLImageWMSSourceOptions();
        // WebMapService of World http://www.osm-wms.de/
        options.setUrl("http://129.206.228.72/cached/osm");
        Map<String,String> params=new HashMap<String,String>();
        params.put("LAYERS","osm_auto:all");
        params.put("FORMAT","image/png");
        options.setParams(params);
        return new OLImageWMSSource(options);
    }

    @Override
    protected OLLayer createLayer(OLSource source) {
        return new OLImageLayer(source);
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
