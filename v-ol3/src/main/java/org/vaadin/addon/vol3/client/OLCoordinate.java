package org.vaadin.addon.vol3.client;

import java.io.Serializable;

/**
 * Created by mjhosio on 30/06/14.
 */
public class OLCoordinate implements Serializable{

    public OLCoordinate(){}

    public Double x;
    public Double y;

    public OLCoordinate(double xCoord, double yCoord){
        x=xCoord;
        y=yCoord;
    }
}
