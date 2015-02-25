package org.vaadin.addon.vol3.client;

import com.google.gwt.core.client.Scheduler;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.ui.AbstractHasComponentsConnector;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.control.*;
import org.vaadin.addon.vol3.client.interaction.OLInteractionConnector;
import org.vaadin.addon.vol3.client.layer.OLLayerConnector;
import org.vaadin.gwtol3.client.Collection;
import org.vaadin.gwtol3.client.DeviceOptions;
import org.vaadin.gwtol3.client.MapOptions;
import org.vaadin.gwtol3.client.MapWidget;
import org.vaadin.gwtol3.client.control.*;
import org.vaadin.gwtol3.client.resources.ResourceInjector;

import java.util.List;

/**
 * Client side connector for the map
 */
@Connect(OLMap.class)
public class OLMapConnector extends AbstractHasComponentsConnector implements ElementResizeListener{

    static{
        ResourceInjector.ensureInjected();
    }

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
        if(getState().deviceOptions!=null){
            DeviceOptions opts=DeviceOptions.create(getState().deviceOptions.loadTilesWhileAnimating, getState().deviceOptions.loadTilesWhileInteracting);
            options.setDeviceOptions(opts);
        }
        // clear default controls
        options.setControls(Collection.create());
        getWidget().initMap(options);
    }

    @Override
    public void updateCaption(ComponentConnector connector) {
        // no-op
    }

    @Override
    public void onElementResize(ElementResizeEvent e) {
        getWidget().getMap().updateSize();
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
}
