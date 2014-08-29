package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.client.source.OLMapQuestLayerName;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.layer.OLTileLayer;
import org.vaadin.addon.vol3.source.OLMapQuestSource;
import org.vaadin.addon.vol3.source.OLSource;

/**
 * Created by mjhosio on 01/07/14.
 */
public class BasicMap extends VerticalLayout implements View {

    protected OLMap map;

    public BasicMap() {
        this.setSizeFull();
        map=createMap();
        this.addComponent(map);
        this.setExpandRatio(this.iterator().next(),1.0f);
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
        return new OLMapQuestSource(OLMapQuestLayerName.OSM);
    }

    protected OLLayer createLayer(OLSource source){
        return new OLTileLayer(source);
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
        Button button=new Button("Reset view");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                map.getView().setCenter(0,0);
                map.getView().setZoom(1);
            }
        });
        controls.addComponent(button);
        return controls;
    }

}
