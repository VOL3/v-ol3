package org.vaadin.addon.vol3.source;

/**
 * Options provided to the osm tile source on creation
 * Created by Martin Stypinski 20/03/2016
 */
public class OLBingSourceOptions {
    private String key;
    private String imageryType;
    private String culture;


    public void setKey(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }

    public void setImageryType(String type){ this.imageryType = type; }

    public String getImageryType(){
        return this.imageryType;
    }

    public String getCulture(){
        return this.culture;
    }

    public void setCulture(String culture){
        this.culture = culture;
    }

}
