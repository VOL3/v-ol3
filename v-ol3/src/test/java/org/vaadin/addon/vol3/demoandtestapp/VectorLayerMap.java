package org.vaadin.addon.vol3.demoandtestapp;

import org.geojson.Point;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.addon.vol3.source.OLVectorSource;

/**
 * Created by mjhosio on 08/07/14.
 */
public class VectorLayerMap extends BasicMap{
    @Override
    protected OLMap createMap() {
        OLMap map=super.createMap();
        OLVectorSource vectorSource=new OLVectorSource();
        for(int i=0;i<1000;i++){
            vectorSource.addFeature(createPointFeature("feature-"+i,i*1000,i*1000));
        }
        OLVectorLayer vectorLayer=new OLVectorLayer(vectorSource);
        map.addLayer(vectorLayer);
        return map;
    }

    private OLFeature createPointFeature(String id, double x, double y){
        OLFeature testFeature=new OLFeature(id);
        testFeature.setGeometry(new Point(x,y));
        return testFeature;
    }
}
