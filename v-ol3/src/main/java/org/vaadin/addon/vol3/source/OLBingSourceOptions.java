package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLBingImageryType;
import org.vaadin.addon.vol3.client.source.OLBingImageryType;

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

    public void setImageryType(OLBingImageryType type){
        switch (type) {
            case ROAD:
                this.imageryType = "Road";
                break;

            case AERIAL:
                this.imageryType = "Aerial";
                break;

            case AERIAL_WITH_LABELS:
                this.imageryType = "AerialWithLabels";
                break;

            case COLLINS_BART:
                this.imageryType = "collinsBart";
                break;

            case ORDONANCE_SURVEY:
                this.imageryType = "ordnanceSurvey";
                break;

            default:
                this.imageryType = "Road";
                break;
        }
    }

    public String getImageryType(){
        return imageryType;
    }

    public String getCulture(){
        return culture;
    }

    public void setCulture(String culture){
        this.culture = culture;
    }

}
