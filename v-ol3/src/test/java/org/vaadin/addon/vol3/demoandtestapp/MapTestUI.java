package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.addon.vol3.OLMap;

/**
 * Created by mjhosio on 24/06/14.
 */
public class MapTestUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout mapLayout=new VerticalLayout();
        setContent(mapLayout);
        mapLayout.addComponent(createMap());
    }

    private OLMap createMap(){
        OLMap map=new OLMap();
        map.setSizeFull();
        return map;
    }
}
