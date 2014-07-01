package org.vaadin.addon.vol3;

import com.vaadin.ui.AbstractComponent;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.OLRotationConstraint;
import org.vaadin.addon.vol3.client.OLViewState;

/**
 * The view associated with a map.
 * Created by mjhosio on 30/06/14.
 */
public class OLView extends AbstractComponent {
    public OLView(){
        this(null);
    }

    public OLView(OLViewOptions options){
        if(options!=null){
            setOptions(options);
        }
    }

    /** Zoom to a specific zoom level.
     *
     * @param zoom
     */
    public void setZoom(int zoom){
        getState().zoom=zoom;
    }

    public int getZoom(){
        return getState(false).zoom;
    }

    /** Set the center of the current view.
     *
     * @param center
     */
    public void setCenter(OLCoordinate center){
        getState().center=center;
    }

    public void setCenter(double xCoord, double yCoord){
        getState().center=new OLCoordinate(xCoord, yCoord);
    }

    /** Set the rotation for this view.
     *
     * @param rotation
     */
    public void setRotation(double rotation){
        getState().rotation=rotation;
    }

    public Double getRotation(){
        return getState(false).rotation;
    }

    /** Set the resolution for this view.
     *
     * @param resolution
     */
    public void setResolution(double resolution){
        getState().resolution=resolution;
    }

    public Double getResolution(){
        return getState(false).resolution;
    }

    public OLCoordinate getCenter(){
        return getState(false).center;
    }

    @Override
    protected OLViewState getState() {
        return (OLViewState) super.getState();
    }

    @Override
    protected OLViewState getState(boolean markAsDirty) {
        return (OLViewState) super.getState(markAsDirty);
    }

    public OLRotationConstraint getRotationConstraint() {
        return getState(false).rotationConstraint;
    }

    public Boolean getEnableRotation() {
        return getState(false).enableRotation;
    }

    public OLExtent getExtent() {
        return getState(false).extent;
    }

    public Double getMaxResolution() {
        return getState(false).maxResolution;
    }

    public Double getMinResolution() {
        return getState(false).minResolution;
    }

    public Integer getMaxZoom() {
        return getState(false).maxZoom;
    }

    public Integer getMinZoom() {
        return getState(false).minZoom;
    }

    public Double getZoomFactor() {
        return getState(false).zoomFactor;
    }

    public String getProjection() {
        return getState(false).projection;
    }

    private void setOptions(OLViewOptions options) {
        getState().enableRotation=options.getEnableRotation();
        getState().rotationConstraint=options.getRotationConstraint();
        getState().extent=options.getExtent();
        getState().minResolution=options.getMinResolution();
        getState().maxResolution=options.getMaxResolution();
        getState().minZoom=options.getMinZoom();
        getState().maxZoom=options.getMaxZoom();
        getState().zoomFactor=options.getZoomFactor();
        getState().projection=options.getProjection();
    }
}
