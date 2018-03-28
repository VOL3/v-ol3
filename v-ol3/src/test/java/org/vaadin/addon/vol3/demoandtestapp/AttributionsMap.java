package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.control.OLAttributionControl;
import org.vaadin.addon.vol3.source.OLOSMSource;
import org.vaadin.addon.vol3.source.OLOSMSourceOptions;
import org.vaadin.addon.vol3.source.OLSource;

public class AttributionsMap extends BasicMap {
    @Override
    public OLMap createMap() {
        OLMap map = super.createMap();
        OLAttributionControl control = new OLAttributionControl();
        control.className = "ol-attribution custom";
        control.collapsible = new Boolean(false);
        map.setAttributionControl(control);

        return map;
    }

    @Override
    protected OLSource createSource() {
        OLOSMSourceOptions opts=new OLOSMSourceOptions();
        opts.setCustomAttributions(new String []{
                "<span><a target=\"_blank\" href=\""
                + "https://github.com/VOL3/v-ol3/tree/master/v-ol3/src/test/java/org/vaadin/addon/vol3/demoandtestapp\">"
                + "Custom attribution example</a></span>" });
        opts.setShowAttributions(true);
        opts.setMaxZoom(18);
        return new OLOSMSource(opts);
    }
}
