package org.vaadin.addon.vol3.client;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.DOM;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.ui.AbstractHasComponentsConnector;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.control.*;
import org.vaadin.addon.vol3.client.interaction.OLInteractionConnector;
import org.vaadin.addon.vol3.client.layer.OLLayerConnector;
import org.vaadin.addon.vol3.client.map.OLOnClickListenerRpc;
import org.vaadin.addon.vol3.client.source.HasFeatureInfoUrl;
import org.vaadin.addon.vol3.client.util.DataConversionUtils;
import org.vaadin.gwtol3.client.*;
import org.vaadin.gwtol3.client.control.*;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.layer.Layer;
import org.vaadin.gwtol3.client.map.ClickEvent;
import org.vaadin.gwtol3.client.map.OnClickListener;
import org.vaadin.gwtol3.client.resources.ResourceInjector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Client side connector for the map
 */
@Connect(OLMap.class)
public class OLMapConnector extends AbstractHasComponentsConnector implements ElementResizeListener{

    static{
        ResourceInjector.ensureInjected();
    }

    private static final Logger logger= Logger.getLogger(OLMapConnector.class.getName());

    // references to controls added to the map
    // makes it easier to handle removal
    private AttributionControl attributionControl;
    private FullScreenControl fullScreenControl;
    private MousePositionControl mousePositionControl;
    private RotateControl rotateControl;
    private ScaleLineControl scaleLineControl;
    private ZoomControl zoomControl;
    private ZoomSliderControl zoomSliderControl;
    private ZoomToExtentControl zoomToExtentControl;
    private List<MapInitializedListener> mapInitializedListeners;

    @Override
    protected void init() {
        super.init();
        getLayoutManager().addElementResizeListener(getWidget().getElement(), this);
    }

    @Override
    public void onUnregister() {
        getLayoutManager().removeElementResizeListener(getWidget().getElement(), this);
    }

    @Override
    public MapWidget getWidget() {
        return (MapWidget) super.getWidget();
    }

    @Override
    public OLMapState getState() {
        return (OLMapState) super.getState();
    }

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
        if(!getWidget().isAttached()){
            // ignore the hierarchy change event when we are removing the map all together
            return;
        }
        if(!getWidget().isMapInitialized()){
            initMap();
        }
        List<ComponentConnector> oldChildren=connectorHierarchyChangeEvent.getOldChildren();
        List<ComponentConnector> currentChildren=getChildComponents();
        for(ComponentConnector oldConnector : oldChildren){
            if(!currentChildren.contains(oldConnector)){
                // remove old layers
                if(oldConnector instanceof OLLayerConnector){
                    OLLayerConnector layer=(OLLayerConnector) oldConnector;
                    getWidget().getMap().removeLayer(layer.getLayer());
                }
                // remove old interactions
                if(oldConnector instanceof OLInteractionConnector){
                    OLInteractionConnector interaction= (OLInteractionConnector) oldConnector;
                    getWidget().getMap().removeInteraction(interaction.getInteraction());
                }
            }
        }
        // add new layers, interactions and view
        for(ComponentConnector connector : this.getChildComponents()) {
            if (!oldChildren.contains(connector)) {
                if (connector instanceof OLLayerConnector) {
                    OLLayerConnector layer = (OLLayerConnector) connector;
                    getWidget().getMap().addLayer(layer.getLayer());
                } else if(connector instanceof OLViewConnector){
                    OLViewConnector view = (OLViewConnector) connector;
                    view.setMap(this.getWidget().getMap());
                    getWidget().getMap().setView(view.getView());
                } else if (connector instanceof OLInteractionConnector){
                    OLInteractionConnector interaction= (OLInteractionConnector) connector;
                    // defer interaction creation since they may need layer state information
                    // on initialization
                    deferredAddInteraction(interaction);
                }
            }
        }
        // ensure layer ordering
        int layerIndex=0;
        Collection<Layer> layers = getWidget().getMap().getLayers();
        for(ComponentConnector connector : this.getChildComponents()){
            if(connector instanceof OLLayerConnector){
                OLLayerConnector layerConnector= (OLLayerConnector) connector;
                if(layers.item(layerIndex) != layerConnector.getLayer()){
                    logger.info("setting layer to index "+layerIndex);
                    layers.setAt(layerIndex, layerConnector.getLayer());
                }
                layerIndex++;
            }
        }
        fireMapInitialized();
    }

    private void deferredAddInteraction(final OLInteractionConnector interaction){
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                getWidget().getMap().addInteraction(interaction.getInteraction());
            }
        });
    }

    /** Initializes the map object
     *
     */
    private void initMap() {
        // register projections
        this.updateCoordinateSystemDefinitions();
        MapOptions options=MapOptions.create();
        if(getState().showOl3Logo!=null){
            options.setOl3Logo(getState().showOl3Logo);
        }
        if(getState().pixelRatio!=null){
            options.setPixelRatio(getState().pixelRatio);
        }
        if(getState().renderer!=null){
            options.setRenderer(getState().renderer.name().toLowerCase());
        }
        if(getState().loadTilesWhileAnimating!=null){
            options.setLoadTilesWhileAnimating(getState().loadTilesWhileAnimating);
        }
        if(getState().loadTilesWhileInteracting!=null){
            options.setLoadTilesWhileInteracting(getState().loadTilesWhileInteracting);
        }
        if(getState().inputProjection!=null){
            options.setInputProjection(getState().inputProjection);
        }
        // clear default controls
        options.setControls(Collection.create());
        getWidget().initMap(options);
    }

    public List<OLLayerConnector> getLayers(){
        List<OLLayerConnector> layers=new ArrayList<OLLayerConnector>();
        List<ComponentConnector> childComponents = this.getChildComponents();
        for(ComponentConnector c : childComponents){
            if(c instanceof OLLayerConnector){
                layers.add((OLLayerConnector) c);
            }
        }
        return layers;
    }

    @Override
    public void updateCaption(ComponentConnector connector) {
        // no-op
    }

    @Override
    public void onElementResize(ElementResizeEvent e) {
        getWidget().getMap().updateSize();
    }

    void updateCoordinateSystemDefinitions(){
        if(getState().coordinateSystemDefinitions!=null){
            for(Map.Entry<String,String> entry : getState().coordinateSystemDefinitions.entrySet()){
                Proj4js.define(entry.getKey(), entry.getValue());
            }
        }
    }

    @OnStateChange("attributionControl")
    void updateAttributionControl(){
        OLAttributionControl ctrl=getState().attributionControl;
        // remove old control
        getWidget().getMap().removeControl(this.attributionControl);
        this.attributionControl=null;
        if(ctrl!=null){
            this.attributionControl=OLControlUtils.createAttributionControl(ctrl);
            getWidget().getMap().addControl(this.attributionControl);
        }
    }

    @OnStateChange("fullScreenControl")
    void updateFullScreenControl(){
        OLFullScreenControl ctrl=getState().fullScreenControl;
        // remove old control
        getWidget().getMap().removeControl(this.fullScreenControl);
        this.fullScreenControl=null;
        if(ctrl!=null){
            this.fullScreenControl=OLControlUtils.createFullScreenControl(ctrl);
            getWidget().getMap().addControl(this.fullScreenControl);
        }
    }

    @OnStateChange("mousePositionControl")
    void updatemousePositionControl(){
        OLMousePositionControl ctrl=getState().mousePositionControl;
        // remove old control
        getWidget().getMap().removeControl(this.mousePositionControl);
        this.mousePositionControl=null;
        if(ctrl!=null){
            this.mousePositionControl=OLControlUtils.createMousePositionControl(ctrl);
            getWidget().getMap().addControl(this.mousePositionControl);
        }
    }

    @OnStateChange("rotateControl")
    void updateRotateControl(){
        OLRotateControl ctrl=getState().rotateControl;
        // remove old control
        getWidget().getMap().removeControl(this.rotateControl);
        this.rotateControl=null;
        if(ctrl!=null){
            this.rotateControl=OLControlUtils.createRotateControl(ctrl);
            getWidget().getMap().addControl(this.rotateControl);
        }
    }

    @OnStateChange("scaleLineControl")
    void updateScaleLineControl(){
        OLScaleLineControl ctrl=getState().scaleLineControl;
        // remove old control
        getWidget().getMap().removeControl(this.scaleLineControl);
        this.scaleLineControl=null;
        if(ctrl!=null){
            this.scaleLineControl=OLControlUtils.createScaleLineControl(ctrl);
            getWidget().getMap().addControl(this.scaleLineControl);
        }
    }

    @OnStateChange("zoomControl")
    void updateZoomControl(){
        OLZoomControl ctrl=getState().zoomControl;
        // remove old control
        getWidget().getMap().removeControl(this.zoomControl);
        this.zoomControl=null;
        if(ctrl!=null){
            this.zoomControl=OLControlUtils.createZoomControl(ctrl);
            getWidget().getMap().addControl(this.zoomControl);
        }
    }

    @OnStateChange("zoomSliderControl")
    void updateZoomSliderControl(){
        OLZoomSliderControl ctrl=getState().zoomSliderControl;
        // remove old control
        getWidget().getMap().removeControl(this.zoomSliderControl);
        this.zoomSliderControl=null;
        if(ctrl!=null){
            this.zoomSliderControl=OLControlUtils.createZoomSliderControl(ctrl);
            getWidget().getMap().addControl(this.zoomSliderControl);
        }
    }

    @OnStateChange("zoomToExtentControl")
    void updateZoomToExtentControl(){
        OLZoomToExtentControl ctrl=getState().zoomToExtentControl;
        // remove old control
        getWidget().getMap().removeControl(this.zoomToExtentControl);
        this.zoomToExtentControl=null;
        if(ctrl!=null){
            this.zoomToExtentControl=OLControlUtils.createZoomToExtentControl(ctrl);
            getWidget().getMap().addControl(this.zoomToExtentControl);
        }
    }

    @OnStateChange("hasClickListeners")
    void updateEventListener() {
        if (getState().hasClickListeners) {
            getWidget().getMap().addOnClickListener(listener);
        } else {
            getWidget().getMap().removeOnClickListener(listener);
        }
    }

    @OnStateChange("overlays")
    void updateOverlays(){
        if(getWidget().getMap().getOverlays()!=null){
            getWidget().getMap().getOverlays().clear();
        }
        if(getState().overlays!=null){
            for(OLOverlay olOverlay : getState().overlays){
                OverlayOptions options=OverlayOptions.create();
                if(olOverlay.offset!=null){
                    options.setOffset(DataConversionUtils.toJsArrayInteger(olOverlay.offset));
                }
                if(olOverlay.insertFirst!=null){
                    options.setInsertFirst(olOverlay.insertFirst);
                }
                if(olOverlay.stopEvent!=null){
                    options.setStopEvent(olOverlay.stopEvent);
                }
                if(olOverlay.htmlContent!=null){
                    com.google.gwt.dom.client.Element div = DOM.createDiv();
                    div.setInnerHTML(olOverlay.htmlContent);
                    if(olOverlay.classNames!=null){
                        div.setClassName(olOverlay.classNames);
                    }
                    options.setElement(div);
                }
                if(olOverlay.positioning!=null){
                    options.setPositioning(olOverlay.positioning);
                }
                if(olOverlay.position!=null){
                    Coordinate coordinate = Coordinate.create(olOverlay.position.x, olOverlay.position.y);
                    getWidget().getMap().addOverlay(coordinate, Overlay.create(options));
                }
            }
        }
    }


    private OnClickListener listener=new OnClickListener() {
        @Override
        public void onClick(ClickEvent event) {
            OLCoordinate olCoordinate = new OLCoordinate(event.getCoordinate().getX(), event.getCoordinate().getY());
            OLPixel pixel = new OLPixel(event.getPixel().getX().intValue(), event.getPixel().getY().intValue());
            String eventType = event.getType().name();
            String details = MouseEventDetailsBuilder.buildMouseEventDetails(event.getNativeEvent()).serialize();
            // check if there are WMS layer that need the feature info url to be send to the server
            List<String> featureInfoUrls=new ArrayList<String>();
            for (OLLayerConnector c : getLayers()) {
                if (c.getSourceConnector() instanceof HasFeatureInfoUrl) {
                    HasFeatureInfoUrl wmsSource = (HasFeatureInfoUrl) c.getSourceConnector();
                    View view = getWidget().getMap().getView();
                    String featureInfoUrl = wmsSource.getGetFeatureInfoUrl(olCoordinate, view.getResolution(), view.getProjection());
                    featureInfoUrls.add(featureInfoUrl);
                }
            }
            // check if there are features at the clicked point
            List<String> featureIds=new ArrayList<String>();
            Collection<Feature> features = getWidget().getMap().getFeaturesFromPixel(event.getPixel());
            for (int i = 0; i < features.getLength(); i++) {
                featureIds.add(features.item(i).getId());
            }
            getRpcProxy(OLOnClickListenerRpc.class).onClick(olCoordinate, pixel, eventType, featureInfoUrls, featureIds, details);
        }
    };

    private void fireMapInitialized(){
        if(this.mapInitializedListeners!=null){
            for(MapInitializedListener listener : mapInitializedListeners){
                listener.mapInitialized();
            }
        }
        // clean up the listeners since those are not needed anymore
        this.mapInitializedListeners.clear();
        this.mapInitializedListeners=null;
    }

    public void addMapInitializationListener(MapInitializedListener listener){
        if(this.mapInitializedListeners==null){
            this.mapInitializedListeners=new ArrayList<MapInitializedListener>();
        }
        this.mapInitializedListeners.add(listener);
    }

    public void removeMapInitializationListener(MapInitializedListener listener){
        this.mapInitializedListeners.remove(listener);
    }

    /** Interface for listening the map initialization event. The event is fired only once. To be used mainly by extensions.
     *
     */
    public static interface MapInitializedListener{
        /** Called when the map is initialized (after connector hierarchy changes have been processed)
         *
         */
        public void mapInitialized();
    }
}


