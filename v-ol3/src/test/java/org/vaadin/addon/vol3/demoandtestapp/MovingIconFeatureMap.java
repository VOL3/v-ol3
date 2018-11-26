package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.event.UIEvents;
import com.vaadin.server.ClientConnector;
import com.vaadin.shared.Registration;
import com.vaadin.ui.UI;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.feature.OLPoint;

public class MovingIconFeatureMap extends IconFeatureMap {
    private Registration pollListenerRegistration;

    @Override
    protected OLMap createMap() {
        UI.getCurrent().setPollInterval(1000);
        this.pollListenerRegistration = UI.getCurrent().addPollListener(new UIEvents.PollListener() {
            @Override
            public void poll(UIEvents.PollEvent pollEvent) {
                for(OLFeature feature : vectorSource.getFeatures()){
                    if(feature.getGeometry() instanceof OLPoint){
                        OLPoint point = (OLPoint)feature.getGeometry();
                        point.setX(point.getX()+Math.random()*2-1d);
                        point.setY(point.getY()+Math.random()*2-1d);
                        vectorSource.updateFeature(feature);
                    }
                }
            }
        });
        addDetachListener(new DetachListener() {
            @Override
            public void detach(DetachEvent detachEvent) {
                UI.getCurrent().setPollInterval(-1);
                pollListenerRegistration.remove();
            }
        });
        return super.createMap();
    }


}
