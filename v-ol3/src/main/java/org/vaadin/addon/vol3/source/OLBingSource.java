package org.vaadin.addon.vol3.source;


import org.vaadin.addon.vol3.client.source.OLBingSourceState;

/**
 * Layer source for Bing Maps
 * Created by Martin Stypinski 20/03/2016
 */
public class OLBingSource extends OLSource {
    /** Creates a new instance of the layer data source
     *
     */
    public OLBingSource(){
        super();
    }

    public OLBingSource(OLBingSourceOptions options){
        this();
        setOptions(options);
    }

    private void setOptions(OLBingSourceOptions options) {
        getState().key = options.getKey();
        getState().imagerySet = options.getImageryType();
        getState().culture = options.getCulture();
    }

    public OLBingSourceState getState(){
        return (OLBingSourceState) super.getState();
    }



}
