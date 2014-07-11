package org.vaadin.addon.vol3;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;
import org.vaadin.addon.vol3.client.OLDeviceOptions;
import org.vaadin.addon.vol3.client.OLMapState;
import org.vaadin.addon.vol3.client.OLRendererType;
import org.vaadin.addon.vol3.client.control.*;
import org.vaadin.addon.vol3.layer.OLLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The core of the wrapper. Interact with this one to add OpenLayers 3 maps to your Vaadin application
 *
 * Created by mjhosio on 24/06/14.
 */
public class OLMap extends AbstractComponentContainer{
    private List<Component> components=new ArrayList<Component>();
    private OLView view;

    public OLMap(){
        this(null,null);
    }

    public OLMap(OLView view){
        this(view, null);
    }

    public OLMap(OLMapOptions options){
        this(null, options);
    }

    public OLMap(OLView view, OLMapOptions options){
        setView(view);
        if(options != null){
            setOptions(options);
        }
        addDefaultControls();
    }

    /** Adds a new layer to the map
     *
     * @param layer the layer to be added
     */
    public void addLayer(OLLayer layer){
        addComponent(layer);
    }

    /** Removes the specified layer from the map
     *
     * @param layer the layer to be removed
     */
    public void removeLayer(OLLayer layer){
        removeComponent(layer);
    }

    public List<OLLayer> getLayers(){
        List<OLLayer> layers=new LinkedList<OLLayer>();
        for(Component c : components){
            if(c instanceof OLLayer){
                layers.add((OLLayer) c);
            }
        }
        return layers;
    }

    /** Sets the view of the map.
     *
     * @param view the view
     */
    public void setView(OLView view){
        doSetView(view);
    }

    /** Gets the view associated with the map
     *
     * @return the view associated with the map
     */
    public OLView getView(){
        return view;
    }

    @Override
    public int getComponentCount() {
        return components.size();
    }

    @Override
    public Iterator<Component> iterator() {
        return components.iterator();
    }

    @Override
    protected OLMapState getState() {
        return (OLMapState) super.getState();
    }

    @Override
    protected OLMapState getState(boolean markAsDirty) {
        return (OLMapState) super.getState(markAsDirty);
    }

    @Override
    public void addComponent(Component c) {
        if(c instanceof OLLayer){
            super.addComponent(c);
            components.add(c);
        } else{
            throw new UnsupportedOperationException("Only instances of OLLayer can be added");
        }
    }

    @Override
    public void removeComponent(Component c) {
        if(c instanceof OLLayer){
            components.remove(c);
            super.removeComponent(c);
        }
    }

    private void doSetView(OLView olView) {
        if(olView==this.view){
            return;
        }
        if(this.view!=null){
            // remove old view
            components.remove(this.view);
            super.removeComponent(this.view);
        }
        // add new view
        this.view=olView;
        if(olView!=null){
            components.add(olView);
            super.addComponent(olView);
        }
    }

    @Override
    public void replaceComponent(Component component, Component component2) {
        throw new UnsupportedOperationException("Replace component not implemented");
    }

    /** Returns true if the ol3 logo is shown
     *
     * @return
     */
    public Boolean getShowOl3Logo() {
        return getState(false).showOl3Logo;
    }

    /** Gets the renderer type used by the map
     *
     * @return
     */
    public OLRendererType getRenderer() {
        return getState(false).renderer;
    }

    /** Gets the device pixel ratio used by the map
     *
     * @return
     */
    public Double getPixelRatio() {
        return getState(false).pixelRatio;
    }

    /** Gets the device options used by the map
     *
     * @return
     */
    public OLDeviceOptions getDeviceOptions() {
        return getState(false).deviceOptions;
    }

    public OLAttributionControl getAttributionControl() {
        return getState().attributionControl;
    }

    public void setAttributionControl(OLAttributionControl attributionControl) {
        getState().attributionControl = attributionControl;
    }

    public OLFullScreenControl getFullScreenControl() {
        return getState().fullScreenControl;
    }

    public void setFullScreenControl(OLFullScreenControl fullScreenControl) {
        getState().fullScreenControl = fullScreenControl;
    }

    public OLLogoControl getLogoControl() {
        return getState().logoControl;
    }

    public void setLogoControl(OLLogoControl logoControl) {
        getState().logoControl = logoControl;
    }

    public OLMousePositionControl getMousePositionControl() {
        return getState().mousePositionControl;
    }

    public void setMousePositionControl(OLMousePositionControl mousePositionControl) {
        getState().mousePositionControl = mousePositionControl;
    }

    public OLRotateControl getRotateControl() {
        return getState().rotateControl;
    }

    public void setRotateControl(OLRotateControl rotateControl) {
        getState().rotateControl = rotateControl;
    }

    public OLScaleLineControl getScaleLineControl() {
        return getState().scaleLineControl;
    }

    public void setScaleLineControl(OLScaleLineControl scaleLineControl) {
        getState().scaleLineControl = scaleLineControl;
    }

    public OLZoomControl getZoomControl() {
        return getState().zoomControl;
    }

    public void setZoomControl(OLZoomControl zoomControl) {
        getState().zoomControl = zoomControl;
    }

    public OLZoomSliderControl getZoomSliderControl() {
        return getState().zoomSliderControl;
    }

    public void setZoomSliderControl(OLZoomSliderControl zoomSliderControl) {
        getState().zoomSliderControl = zoomSliderControl;
    }

    public OLZoomToExtentControl getZoomToExtentControl() {
        return getState().zoomToExtentControl;
    }

    public void setZoomToExtentControl(OLZoomToExtentControl zoomToExtentControl) {
        getState().zoomToExtentControl = zoomToExtentControl;
    }

    private void setOptions(OLMapOptions options) {
        getState().showOl3Logo=options.getShowOl3Logo();
        getState().renderer=options.getRenderer();
        getState().pixelRatio=options.getPixelRatio();
        getState().deviceOptions=options.getDeviceOptions();
    }

    private void addDefaultControls() {
        getState().zoomControl=new OLZoomControl();
        getState().logoControl=new OLLogoControl();
        getState().attributionControl=new OLAttributionControl();
        getState().rotateControl=new OLRotateControl();
    }
}
