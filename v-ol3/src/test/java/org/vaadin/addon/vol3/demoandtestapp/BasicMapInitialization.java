package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.layer.OLTile;
import org.vaadin.addon.vol3.source.OLMapQuest;

/**
 * Created by mjhosio on 01/07/14.
 */
public class BasicMapInitialization extends VerticalLayout implements View {

    public BasicMapInitialization(){
        this.setSizeFull();
        this.addComponent(createMap());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    private OLMap createMap(){
        OLMap map=new OLMap();
        OLTile tileLayer=new OLTile(new OLMapQuest(OLMapQuest.LAYER_OSM));
        map.addLayer(tileLayer);
        map.setView(createView());
        map.setSizeFull();
        return map;
    }

    private OLView createView(){
        OLView view=new OLView();
        view.setZoom(1);
        view.setCenter(0,0);
        return view;
    }

}
