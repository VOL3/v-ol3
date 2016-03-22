package org.vaadin.addon.vol3.demoandtestapp;


import org.vaadin.addon.vol3.source.*;

/**
 * Bing Map view
 * Created by Martin Stypinski 20/03/2016
 */
public class BingMap extends BasicMap {

    // Culture parameter to choose rendering...
    // https://msdn.microsoft.com/en-us/library/hh441729.aspx

    protected OLSource createSource() {
        OLBingSourceOptions olBingSourceOptions = new OLBingSourceOptions();

        // Please provide your own Key!
        olBingSourceOptions.setKey("");
        olBingSourceOptions.setImageryType("Road");
        olBingSourceOptions.setCulture("en-us");

        return new OLBingSource(olBingSourceOptions);

    }

}
