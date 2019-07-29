package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.style.*;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.feature.OLMultiPolygon;
import org.vaadin.addon.vol3.feature.OLPoint;
import org.vaadin.addon.vol3.feature.OLPolygon;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.addon.vol3.source.OLVectorSource;
import org.vaadin.addon.vol3.util.StyleUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Map for testing styles on vector layer
 */
public class StyleTestMap extends VectorLayerMap {

    @Override
    protected OLMap createMap() {
        OLMap map=super.createMap();
        OLVectorLayer vectorLayer=(OLVectorLayer) map.getLayers().get(1);
        OLStyle style= StyleUtils.createDefaultStyle();
        style.circleStyle.fill=new OLFillStyle("magenta");
        style.circleStyle.stroke.color="green";
        vectorLayer.setStyle(style);
        OLFeature feature=createPointFeatureWithLabel("label", 0, 30);
        feature.setStyle(createMyStyle("my point with label"));
        ((OLVectorSource) vectorLayer.getSource()).addFeature(feature);
        OLFeature feature2=createPolygon("polygon", -30, -35, 50, 30);
        feature2.setStyle(createMyStyle("my polygon"));
        ((OLVectorSource) vectorLayer.getSource()).addFeature(feature2);
        return map;
    }

    protected OLFeature createPolygon(String id, double x, double y, double width, double height){
        OLFeature testFeature=new OLFeature(id);
        OLPolygon polygon = new OLPolygon();
        List points = new ArrayList<OLCoordinate>();
        points.add(new OLCoordinate(x+width,y));
        points.add(new OLCoordinate(x+width,y+height));
        points.add(new OLCoordinate(x,y+height));
        points.add(new OLCoordinate(x,y));
        polygon.add(points);
        testFeature.setGeometry(polygon);
        return testFeature;
    }

    private OLFeature createPointFeatureWithLabel(String id, double x, double y){
        OLFeature testFeature=new OLFeature(id);
        testFeature.setGeometry(new OLPoint(x,y));
        // create a feature specific style.
        OLStyle style= StyleUtils.createDefaultStyle();
        style.textStyle=new OLTextStyle();
        style.textStyle.text="Testing label";
        style.textStyle.font="12px Calibri,sans-serif";
        style.textStyle.fill=new OLFillStyle("black");
        style.textStyle.stroke=StyleUtils.createDefaultStrokeStyle();
        style.textStyle.stroke.color="black";
        style.textStyle.stroke.width=2.0;
        style.circleStyle.stroke.color="black";
        testFeature.setStyle(style);
        return testFeature;
    }

    private static OLStyle createMyStyle(String libelle)
    {
        OLStyle style = org.vaadin.addon.vol3.util.StyleUtils.createDefaultStyle();
        style.fillStyle = new OLFillStyle();
        style.fillStyle.color = "FF000000";
        style.strokeStyle = new OLStrokeStyle();
        style.strokeStyle.width = 1.25;
        style.strokeStyle.color = "#FF0000";
        style.circleStyle = new OLCircleStyle();
        style.circleStyle.fill = style.fillStyle;
        style.circleStyle.stroke = style.strokeStyle;
        style.circleStyle.radius = 5.0;

        style.textStyle = new OLTextStyle();
        style.textStyle.text = libelle;
        style.textStyle.font = "12px Arial";
        style.textStyle.textAlign="center";
        style.textStyle.textBaseline="middle";
        style.textStyle.overflow=true;
        style.textStyle.fill = new OLFillStyle("black");
        style.textStyle.rotation = 0.0;
        style.textStyle.stroke =  org.vaadin.addon.vol3.util.StyleUtils.createDefaultStrokeStyle();
        style.textStyle.stroke.color = "#FFFFFF";
        style.textStyle.stroke.width = 3.0;
        return style;
    }
}
