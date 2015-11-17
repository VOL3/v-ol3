package org.vaadin.addon.vol3.demoandtestapp;


import com.vaadin.ui.*;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.style.OLFillStyle;
import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.feature.OLPoint;
import org.vaadin.addon.vol3.feature.OLPolygon;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.addon.vol3.source.OLVectorSource;
import org.vaadin.addon.vol3.source.OLVectorSourceOptions;
import org.vaadin.addon.vol3.util.StyleUtils;

import java.util.logging.Logger;

/**
 * Example how to change properties of vector objects and update them...
 */
public class VectorModifyingMap extends BasicMap{

    private static final Logger logger= Logger.getLogger(VectorModifyingMap.class.getName());

    private OLFeature featurePoly;
    private static final OLCoordinate[] COORDINATES = new OLCoordinate[]{new OLCoordinate(7, 47),new OLCoordinate(7.5, 47),new OLCoordinate(7.5, 47.5),new OLCoordinate(7, 47)};
    protected OLMap map;
    protected OLVectorLayer vectorLayer;


    protected OLMap createMap() {
        OLMap map = super.createMap();

        OLVectorSourceOptions vectorOptions=new OLVectorSourceOptions();
        vectorLayer = new OLVectorLayer(new OLVectorSource(vectorOptions));
        vectorLayer.setLayerVisible(true);
        map.addLayer(vectorLayer);

        OLPoint point = new OLPoint(new OLCoordinate(7, 47));
        OLFeature p2=new OLFeature("p1");
        p2.setGeometry(point);
        ((OLVectorSource)vectorLayer.getSource()).addFeature(p2);

        return map;
    }

    protected OLView createView() {

        OLViewOptions viewOpts = new OLViewOptions();
        viewOpts.setMapProjection("EPSG:900913");
        viewOpts.setInputProjection("EPSG:900913");

        OLView view = new OLView(viewOpts);

        // Coordinates for switzerland
        view.setZoom(9);
        view.setCenter(new OLCoordinate(939253.66, 5948629.66));

        return view;
    }

    // This demo shows how to change attributes of vector feature objects
    protected AbstractLayout createControls() {
        HorizontalLayout controls = new HorizontalLayout();
        controls.setSpacing(true);
        controls.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Button createPolyButton = new Button("create poly");
        createPolyButton.addClickListener(new Button.ClickListener() {


            @Override
            public void buttonClick(Button.ClickEvent event) {


                OLPolygon poly=new OLPolygon(COORDINATES);
                featurePoly = new OLFeature("r1");
                featurePoly.setGeometry(poly);

                OLVectorSource source = (OLVectorSource)vectorLayer.getSource();
                source.addFeature(featurePoly);

            }
        });
        controls.addComponent(createPolyButton);

        Button modifyPolyButton = new Button("modify poly");
        modifyPolyButton.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                if(featurePoly==null){
                    Notification.show("Please create the poly first");
                } else{
                    OLPolygon newPoly=new OLPolygon(new OLCoordinate[]{new OLCoordinate(7.1, 46.9),new OLCoordinate(7.5, 47),new OLCoordinate(7.5, 47.5),new OLCoordinate(7.1, 46.9)});
                    featurePoly.setGeometry(newPoly);
                    ((OLVectorSource)vectorLayer.getSource()).updateAllFeatures();
                }

            }
        });
        controls.addComponent(modifyPolyButton);

        Button colorizePolyButton = new Button("colorize poly");
        colorizePolyButton.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                if(featurePoly==null){
                    Notification.show("Please create the poly first");
                }
                else{
                    OLStyle olStyle =StyleUtils.createDefaultStyle();
                    olStyle.fillStyle=new OLFillStyle("red");
                    featurePoly.setStyle(olStyle);
                    ((OLVectorSource)vectorLayer.getSource()).updateAllFeatures();
                }
            }
        });
        controls.addComponent(colorizePolyButton);

        return controls;
    }


}
