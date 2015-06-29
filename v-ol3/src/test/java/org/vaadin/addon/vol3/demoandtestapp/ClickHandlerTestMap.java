package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.ui.Notification;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.OLCoordinate;

/**
 * Created by Martin Stypinski
 */
public class ClickHandlerTestMap extends BasicMap {

    @Override
    protected OLMap createMap() {
        OLMap map=super.createMap();

        map.addListener(new OLMap.OnClickListener() {
            @Override
            public void onClickListener(OLCoordinate centerPoint) {
                System.out.println(centerPoint.toString());
                Notification.show(centerPoint.toText());
            }
        });

        return map;
    }
}
