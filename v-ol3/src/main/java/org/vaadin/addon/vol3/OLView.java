package org.vaadin.addon.vol3;

import com.vaadin.ui.AbstractComponent;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLViewState;

/**
 * Created by mjhosio on 30/06/14.
 */
public class OLView extends AbstractComponent {
    public OLView(){
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

    public void setRotation(double rotation){
        getState().rotation=rotation;
    }

    public Double getRotation(){
        return getState(false).rotation;
    }

    public void setResolution(double resolution){
        getState().resolution=resolution;
    }

    public Double getResolution(){
        return getState(false).resolution;
    }

    public OLCoordinate getCenter(){
        return getState(false).center;
    }

    public void setProjection(String crsName){
        getState().projection=crsName;
    }

    public String getProjection(){
        return getState(false).projection;
    }

    @Override
    protected OLViewState getState() {
        return (OLViewState) super.getState();
    }

    @Override
    protected OLViewState getState(boolean markAsDirty) {
        return (OLViewState) super.getState(markAsDirty);
    }

}
