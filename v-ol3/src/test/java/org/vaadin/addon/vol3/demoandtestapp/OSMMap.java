package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.source.OLOSMSource;
import org.vaadin.addon.vol3.source.OLOSMSourceOptions;
import org.vaadin.addon.vol3.source.OLSource;

/**
 * OpenStreetMap source test
 */
public class OSMMap extends BasicMap {
    @Override
    protected OLSource createSource() {
        OLOSMSourceOptions opts=new OLOSMSourceOptions();
        opts.setCustomAttributions(new String []{"custom attribution"});
        opts.setMaxZoom(18);
        opts.setShowAttributions(true);
        return new OLOSMSource(opts);
    }
}
