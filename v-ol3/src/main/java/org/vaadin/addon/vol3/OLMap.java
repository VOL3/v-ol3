package org.vaadin.addon.vol3;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLMapState;
import org.vaadin.addon.vol3.client.OLPixel;
import org.vaadin.addon.vol3.client.control.*;
import org.vaadin.addon.vol3.client.map.OLOnClickListenerRpc;
import org.vaadin.addon.vol3.interaction.OLInteraction;
import org.vaadin.addon.vol3.layer.OLLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The core of the wrapper. Interact with this one to add OpenLayers 3 maps to your Vaadin application
 *
 */
public class OLMap extends AbstractComponentContainer {
    private List<Component> components=new ArrayList<Component>();
    private OLView view;
    private List<ClickListener> clickListeners = new LinkedList<ClickListener>();

    /** Creates a new instance of the map
     *
     */
    public OLMap(){
        this(null, null);
    }

    /** Creates a new instance of the map with the specified view
     *
     * @param view the view
     */
    public OLMap(OLView view){
        this(view, null);
    }

    /** Creates a new instance of the map with specified options
     *
     * @param options map options
     */
    public OLMap(OLMapOptions options){
        this(null, options);
    }

    /** Creates a new instance of the map with specified view and options
     *
     * @param view the view
     * @param options map options
     */
    public OLMap(OLView view, OLMapOptions options){
        setView(view);
        if(options != null){
            setOptions(options);
        }
        addDefaultControls();
        registerRpc(new OLOnClickListenerRpcImpl(), OLOnClickListenerRpc.class);
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

    /** Adds a new interaction to the map
     *
     * @param interaction interaction to be added
     */
    public void addInteraction(OLInteraction interaction){
        addComponent(interaction);
    }

    /** Removes the specified interaction from the map
     *
     * @param interaction the interaction to be removed
     */
    public void removeInteraction(OLInteraction interaction){
        removeComponent(interaction);
    }

    /** Gets the layers added to the map
     *
     * @return the layers of the map
     */
    public List<OLLayer> getLayers(){
        List<OLLayer> layers=new LinkedList<OLLayer>();
        for(Component c : components){
            if(c instanceof OLLayer){
                layers.add((OLLayer) c);
            }
        }
        return layers;
    }

    /** Gets the interactions added to the map
     *
     * @return the interactions
     */
    public List<OLInteraction> getInteractions(){
        List<OLInteraction> interactions=new LinkedList<OLInteraction>();
        for(Component c : components){
            if(c instanceof OLInteraction){
                interactions.add((OLInteraction) c);
            }
        }
        return interactions;
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
        if(c instanceof OLLayer || c instanceof OLInteraction){
            components.add(c);
            super.addComponent(c);
            this.markAsDirty();
        } else{
            throw new UnsupportedOperationException("Only instances of OLLayer and OLInteraction can be added");
        }
    }

    @Override
    public void removeComponent(Component c) {
        if(c instanceof OLLayer || c instanceof OLInteraction){
            super.removeComponent(c);
            components.remove(c);
            this.markAsDirty();
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
        this.markAsDirty();
    }

    @Override
    public void replaceComponent(Component component, Component component2) {
        throw new UnsupportedOperationException("Replace component not implemented");
    }

    public OLAttributionControl getAttributionControl() {
        return getState().attributionControl;
    }

    /** Sets the control to the map that shows map data attributions
     *
     * @param attributionControl
     */
    public void setAttributionControl(OLAttributionControl attributionControl) {
        getState().attributionControl = attributionControl;
    }

    public OLFullScreenControl getFullScreenControl() {
        return getState().fullScreenControl;
    }

    /** Sets the control to the map that allows entering full screen state
     *
     * @param fullScreenControl
     */
    public void setFullScreenControl(OLFullScreenControl fullScreenControl) {
        getState().fullScreenControl = fullScreenControl;
    }

    public OLMousePositionControl getMousePositionControl() {
        return getState().mousePositionControl;
    }

    /** Sets the control to the map that shows current mouse position in map coordinates
     *
     * @param mousePositionControl
     */
    public void setMousePositionControl(OLMousePositionControl mousePositionControl) {
        getState().mousePositionControl = mousePositionControl;
    }

    public OLRotateControl getRotateControl() {
        return getState().rotateControl;
    }

    /** Sets rotation control to the map
     *
     * @param rotateControl
     */
    public void setRotateControl(OLRotateControl rotateControl) {
        getState().rotateControl = rotateControl;
    }

    public OLScaleLineControl getScaleLineControl() {
        return getState().scaleLineControl;
    }

    /** Sets the control to the map that shows current map scale
     *
     * @param scaleLineControl
     */
    public void setScaleLineControl(OLScaleLineControl scaleLineControl) {
        getState().scaleLineControl = scaleLineControl;
    }

    public OLZoomControl getZoomControl() {
        return getState().zoomControl;
    }

    /** Sets the control for the map that allows zooming of the map by clicking zoom buttons
     *
     * @param zoomControl
     */
    public void setZoomControl(OLZoomControl zoomControl) {
        getState().zoomControl = zoomControl;
    }

    public OLZoomSliderControl getZoomSliderControl() {
        return getState().zoomSliderControl;
    }

    /** Sets slider type zoom control to the map
     *
     * @param zoomSliderControl
     */
    public void setZoomSliderControl(OLZoomSliderControl zoomSliderControl) {
        getState().zoomSliderControl = zoomSliderControl;
    }

    public OLZoomToExtentControl getZoomToExtentControl() {
        return getState().zoomToExtentControl;
    }

    /** Sets control to the map that allows instant zooming to given extent
     *
     * @param zoomToExtentControl
     */
    public void setZoomToExtentControl(OLZoomToExtentControl zoomToExtentControl) {
        getState().zoomToExtentControl = zoomToExtentControl;
    }

    /**
     * Adds a click listener that will be notified when the user clicks on the map
     * @param clickListener
     */
    public void addClickListener(ClickListener clickListener){
        this.clickListeners.add(clickListener);
        updateClickListenerState();
    }

    /** Remove the specified click listener from the map
     *
     * @param clickListener
     */
    public void removeClickListener(ClickListener clickListener){
        this.clickListeners.remove(clickListener);
        updateClickListenerState();
    }

    /** Remove all click listeners from the map
     *
     */
    public void removeAllClickListeners(){
        this.clickListeners.clear();
        updateClickListenerState();
    }



    private void updateClickListenerState() {
        this.getState().hasClickListeners=this.clickListeners.size()>0;
    }

    private void setOptions(OLMapOptions options) {
        getState().showOl3Logo=options.getShowOl3Logo();
        getState().renderer=options.getRenderer();
        getState().pixelRatio=options.getPixelRatio();
        getState().deviceOptions=options.getDeviceOptions();
        getState().coordinateSystemDefinitions=options.getProjectionDefinitions();
    }

    private void addDefaultControls() {
        getState().zoomControl=new OLZoomControl();
        getState().attributionControl=new OLAttributionControl();
        getState().rotateControl=new OLRotateControl();
    }

    /**
     * Click listener interface for map click clickListeners
     */
    public interface ClickListener {
        /** Called when user clicks on a map
         *
         * @param clickEvent
         */
        void onClick(OLClickEvent clickEvent);
    }

    private class OLOnClickListenerRpcImpl implements OLOnClickListenerRpc {

        @Override
        public void onClick(OLCoordinate coordinate, OLPixel pixel, String eventType, List<String> featureInfoUrls, List<String> featureIds, String details) {
            OLClickEvent event=new OLClickEvent(coordinate, OLClickEvent.EventType.valueOf(eventType));
            event.setPixel(pixel);
            event.setFeatureInfoUrls(featureInfoUrls);
            event.setFeatureIds(featureIds);
            event.setDetails(MouseEventDetails.deSerialize(details));
            for (ClickListener listener : clickListeners) {
                listener.onClick(event);
            }
        }
    }

    public static class OLClickEvent {

        public static enum EventType{
            LEFT_CLICK, RIGHT_CLICK, DOUBLE_CLICK;
        }

        private OLCoordinate coordinate;
        private OLPixel pixel;
        private EventType eventType;
        // List of feature info urls in case there are visible WMS layers displayed on the map
        private List<String> featureInfoUrls;
        // List of feature ids in case there are features displayed on the click point
        private List<String> featureIds;
        // Native mouse event details
        private MouseEventDetails details;

        public OLClickEvent(){

        }

        public OLClickEvent(OLCoordinate coordinate, EventType type){
            this.coordinate=coordinate;
            this.eventType=type;
        }

        public OLCoordinate getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(OLCoordinate coordinate) {
            this.coordinate = coordinate;
        }

        public OLPixel getPixel() {
            return pixel;
        }

        public void setPixel(OLPixel pixel) {
            this.pixel = pixel;
        }

        public EventType getEventType() {
            return eventType;
        }

        public void setEventType(EventType eventType) {
            this.eventType = eventType;
        }

        public List<String> getFeatureInfoUrls() {
            return featureInfoUrls;
        }

        public void setFeatureInfoUrls(List<String> featureInfoUrls) {
            this.featureInfoUrls = featureInfoUrls;
        }

        public void addFeatureInfoUrl(String url){
            if(this.featureInfoUrls==null){
                this.featureInfoUrls=new ArrayList<String>();
            }
            this.featureInfoUrls.add(url);
        }

        public void addFeatureId(String id){
            if(this.featureIds==null){
                this.featureIds=new ArrayList<String>();
            }
            this.featureIds.add(id);
        }

        public List<String> getFeatureIds() {
            return featureIds;
        }

        public void setFeatureIds(List<String> featureIds) {
            this.featureIds = featureIds;
        }

        public MouseEventDetails getDetails() {
            return this.details;
        }

        public void setDetails(MouseEventDetails details) {
            this.details = details;
        }

        public boolean isLeftClick(){
            return this.eventType.equals(EventType.LEFT_CLICK);
        }

        public boolean isRightClick(){
            return this.eventType.equals(EventType.RIGHT_CLICK);
        }

        public boolean isDoubleClick(){
            return this.eventType.equals(EventType.DOUBLE_CLICK);
        }

        public String toString(){
            String representation=this.eventType+" "+pixel.toString()+" "+coordinate.toString();
            if(featureInfoUrls!=null && featureInfoUrls.size()>0){
                representation+=" featureInfoUrls: "+featureInfoUrls;
            }
            if(featureIds!=null && featureIds.size()>0){
                representation+=" featureIds: "+featureIds;
            }
            return representation;
        }
    }
}
