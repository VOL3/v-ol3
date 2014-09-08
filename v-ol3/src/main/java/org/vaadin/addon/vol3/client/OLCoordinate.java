package org.vaadin.addon.vol3.client;

import java.io.Serializable;

/**
 * Models a coordinate in some projection units
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
