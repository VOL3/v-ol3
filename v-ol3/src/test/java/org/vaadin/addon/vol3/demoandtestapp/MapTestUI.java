package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLView2D;
import org.vaadin.addon.vol3.layer.OLTile;
import org.vaadin.addon.vol3.source.OLMapQuest;

/**
 * Created by mjhosio on 24/06/14.
 */
public class MapTestUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout mapLayout=new VerticalLayout();
        mapLayout.setSizeFull();
        setContent(mapLayout);
        mapLayout.addComponent(createMap());
    }

    private OLMap createMap(){
        OLMap map=new OLMap();
        OLTile tileLayer=new OLTile(new OLMapQuest(OLMapQuest.LAYER_OSM));
        map.addLayer(tileLayer);
        OLView2D view2D=new OLView2D();
        view2D.setZoom(1);
        view2D.setCenter(0,0);
        map.setView(view2D);
        map.setSizeFull();
        return map;
    }
}
