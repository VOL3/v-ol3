package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.layer.OLTile;
import org.vaadin.addon.vol3.source.OLMapQuest;
import org.vaadin.addon.vol3.source.OLSource;

/**
 * Created by mjhosio on 01/07/14.
 */
public class BasicMapInitialization extends VerticalLayout implements View {

    public BasicMapInitialization() {
        this.setSizeFull();
        this.addComponent(createMap());
        this.addComponent(createControls());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    protected OLMap createMap(){
        OLMap map=new OLMap();
        OLLayer layer=createLayer(createSource());
        map.addLayer(layer);
        map.setView(createView());
        map.setSizeFull();
        return map;
    }

    protected OLSource createSource(){
        return new OLMapQuest(OLMapQuest.LAYER_OSM);
    }

    protected OLLayer createLayer(OLSource source){
        return new OLTile(source);
    }

    protected OLView createView(){
        OLView view=new OLView();
        view.setZoom(1);
        view.setCenter(0,0);
        return view;
    }

    protected Component createControls() {
        CssLayout controls=new CssLayout();
        controls.setWidth("100%");
        return controls;
    }

}
