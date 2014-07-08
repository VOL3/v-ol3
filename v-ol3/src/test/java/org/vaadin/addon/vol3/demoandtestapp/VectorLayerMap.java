package org.vaadin.addon.vol3.demoandtestapp;

import org.geojson.LineString;
import org.geojson.LngLatAlt;
import org.geojson.Point;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.addon.vol3.source.OLVectorSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mjhosio on 08/07/14.
 */
public class VectorLayerMap extends BasicMap{
    @Override
    protected OLMap createMap() {
        OLMap map=super.createMap();
        OLVectorSource vectorSource=new OLVectorSource();
        for(int i=0;i<500;i++){
            vectorSource.addFeature(createPointFeature("feature-a-"+i,i*1000,i*1000));
            vectorSource.addFeature(createPointFeature("feature-b-"+i,i*-1000,i*1000));
        }
        vectorSource.addFeature(createRectangleFeature("rect",-500000,0,1000000,500000));
        OLVectorLayer vectorLayer=new OLVectorLayer(vectorSource);
        map.addLayer(vectorLayer);
        return map;
    }

    private OLFeature createPointFeature(String id, double x, double y){
        OLFeature testFeature=new OLFeature(id);
        testFeature.setGeometry(new Point(x,y));
        return testFeature;
    }

    private OLFeature createRectangleFeature(String id, double x, double y, double width, double height){
        OLFeature testFeature=new OLFeature(id);
        List<LngLatAlt> coordinates=new ArrayList<LngLatAlt>();
        coordinates.add(new LngLatAlt(x,y));
        coordinates.add(new LngLatAlt(x+width,y));
        coordinates.add(new LngLatAlt(x+width,y+height));
        coordinates.add(new LngLatAlt(x,y+height));
        coordinates.add(new LngLatAlt(x,y));
        LineString lineString=new LineString();
        lineString.setCoordinates(coordinates);
        testFeature.setGeometry(lineString);
        return testFeature;
    }
}
