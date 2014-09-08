package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.style.OLFillStyle;
import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.addon.vol3.client.style.OLTextStyle;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.feature.OLPoint;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.addon.vol3.source.OLVectorSource;
import org.vaadin.addon.vol3.util.StyleUtils;

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
        ((OLVectorSource) vectorLayer.getSource()).addFeature(feature);
        return map;
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
        style.textStyle.stroke.width=3.0;
        style.circleStyle.stroke.color="black";
        testFeature.setStyle(style);
        return testFeature;
    }
}
