package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.ui.Notification;
import org.vaadin.addon.vol3.OLMap;

/**
 * Created by Martin Stypinski
 */
public class ClickHandlerTestMap extends BasicMap {

    @Override
    protected OLMap createMap() {
        OLMap map=super.createMap();

        map.addClickListener(new OLMap.ClickListener() {
            @Override
            public void onClick(OLMap.OLClickEvent event) {
               Notification.show(event.getEventType()+" "+event.getCoordinate().toString());
            }
        });

        return map;
    }
}
