package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.addon.vol3.feature.*;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.addon.vol3.source.OLVectorSource;
import org.vaadin.addon.vol3.source.OLVectorSourceOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Map for testing vector layer
 */
public class VectorLayerMap extends BasicMap{

    protected OLVectorLayer vectorLayer;
    protected OLVectorSource vectorSource;

    @Override
    protected OLMap createMap() {
        OLMap map=super.createMap();
        OLVectorSourceOptions vectorOptions=new OLVectorSourceOptions();
        vectorSource=new OLVectorSource(vectorOptions);
        for(int i=0;i<=5;i++){
            int coordinate=i*10;
            vectorSource.addFeature(createPointFeature("feature-a-"+i,coordinate,coordinate));
            vectorSource.addFeature(createPointFeature("feature-b-"+i,-coordinate,coordinate));
        }
        vectorSource.addFeature(createRectangleFeature("rect",-150,-50,200,100));
        vectorSource.addFeature(createMultipolygon("mpolygon",-50,0));
        vectorLayer=new OLVectorLayer(vectorSource);
        vectorLayer.setLayerVisible(true);
        map.addLayer(vectorLayer);
        return map;
    }

    protected OLFeature createPointFeature(String id, double x, double y){
        OLFeature testFeature=new OLFeature(id);
        testFeature.setStyle(new OLStyle());
        testFeature.setGeometry(new OLPoint(x,y));
        return testFeature;
    }

    protected OLFeature createRectangleFeature(String id, double x, double y, double width, double height){
        OLFeature testFeature=new OLFeature(id);
        OLLineString lineString=new OLLineString();
        lineString.add(new OLCoordinate(x,y));
        lineString.add(new OLCoordinate(x+width,y));
        lineString.add(new OLCoordinate(x+width,y+height));
        lineString.add(new OLCoordinate(x,y+height));
        lineString.add(new OLCoordinate(x,y));
        testFeature.setGeometry(lineString);
        return testFeature;
    }

    protected OLFeature createMultipolygon(String id, double x, double y){
        OLFeature testFeature=new OLFeature(id);
        OLMultiPolygon mpolygon=new OLMultiPolygon();
        OLPolygon polygon = new OLPolygon();
        List points = new ArrayList<OLCoordinate>();
        points.add(new OLCoordinate(x+100d,y));
        points.add(new OLCoordinate(x+100d,y+50d));
        points.add(new OLCoordinate(x,y+50d));
        points.add(new OLCoordinate(x,y));
        polygon.add(points);
        mpolygon.add(polygon);
        OLPolygon polygon2 = new OLPolygon();
        List points2 = new ArrayList<OLCoordinate>();
        points2.add(new OLCoordinate(x-100d,y));
        points2.add(new OLCoordinate(x-100d,y-50d));
        points2.add(new OLCoordinate(x,y-50d));
        points2.add(new OLCoordinate(x,y));
        polygon2.add(points2);
        mpolygon.add(polygon2);
        testFeature.setGeometry(mpolygon);
        return testFeature;
    }

    @Override
    protected AbstractLayout createControls() {
        AbstractLayout controls= super.createControls();
        Button toggleVectorLayerVisibility=new Button("Toggle vector layer");
        toggleVectorLayerVisibility.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                vectorLayer.setLayerVisible(!vectorLayer.isLayerVisible().booleanValue());
            }
        });
        controls.addComponent(toggleVectorLayerVisibility);
        Button swapLayerOrdering=new Button("Swap layer order");
        swapLayerOrdering.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                List<OLLayer> layers = map.getLayers();
                for(OLLayer layer : layers){
                    map.removeLayer(layer);
                }
                Collections.reverse(layers);
                for(OLLayer layer : layers){
                    map.addLayer(layer);
                }
            }
        });
        controls.addComponent(swapLayerOrdering);
        return controls;
    }
}
