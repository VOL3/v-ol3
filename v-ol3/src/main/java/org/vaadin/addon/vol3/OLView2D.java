package org.vaadin.addon.vol3;

import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLView2DState;

/**
 * Created by mjhosio on 30/06/14.
 */
public class OLView2D extends OLView {

    public OLView2D(){
        this(1);
    }

    public OLView2D(int zoom){
        this(1,0,0);
    }

    public OLView2D(double centerX, double centerY, int zoom){
        setCenter(centerX, centerY);
        setZoom(zoom);
    }

    public void setZoom(int zoom){
        getState().zoom=zoom;
    }

    public int getZoom(){
        return getState(false).zoom;
    }

    public void setCenter(OLCoordinate center){
        getState().center=center;
    }

    public void setCenter(double xCoord, double yCoord){
        getState().center=new OLCoordinate(xCoord, yCoord);
    }

    public OLCoordinate getCenter(){
        return getState(false).center;
    }

    @Override
    public OLView2DState getState() {
        return (OLView2DState) super.getState();
    }

    @Override
    protected OLView2DState getState(boolean markAsDirty) {
        return (OLView2DState) super.getState(markAsDirty);
    }
}
