package org.vaadin.addon.vol3.client;

import java.io.Serializable;

/**
 * Models a coordinate in some projection units
 */
public class OLCoordinate implements Serializable{

    public OLCoordinate(){
        x=0.0;
        y=0.0;
    }

    public Double x;
    public Double y;

    public OLCoordinate(double xCoord, double yCoord){
        x=xCoord;
        y=yCoord;
    }

    @Override
    public String toString() {
        return "OLCoordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
