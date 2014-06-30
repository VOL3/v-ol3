package org.vaadin.addon.vol3.client;

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.ui.AbstractHasComponentsConnector;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.layer.OLLayerConnector;
import org.vaadin.gwtol3.client.MapWidget;
import org.vaadin.gwtol3.client.resources.ResourceInjector;

import java.util.List;

/**
 * Created by mjhosio on 24/06/14.
 */
@Connect(OLMap.class)
public class OLMapConnector extends AbstractHasComponentsConnector implements ElementResizeListener{

    static{
        ResourceInjector.ensureInjected();
    }

    @Override
    protected void init() {
        super.init();
        getLayoutManager().addElementResizeListener(getWidget().getElement(), this);
    }

    @Override
    public MapWidget getWidget() {
        return (MapWidget) super.getWidget();
    }

    @Override
    public AbstractComponentState getState() {
        return super.getState();
    }

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
        List<ComponentConnector> oldChildren=connectorHierarchyChangeEvent.getOldChildren();
        List<ComponentConnector> currentChildren=getChildComponents();
        // remove old layers
        for(ComponentConnector oldConnector : oldChildren){
            if(!currentChildren.contains(oldConnector) && oldConnector instanceof OLLayerConnector){
                OLLayerConnector layer=(OLLayerConnector) oldConnector;
                getWidget().getMap().removeLayer(layer.getLayer());
            }
        }
        // add new layers and possibly view
        for(ComponentConnector connector : this.getChildComponents()) {
            if (!oldChildren.contains(connector)) {
                if (connector instanceof OLLayerConnector) {
                    OLLayerConnector layer = (OLLayerConnector) connector;
                    getWidget().getMap().addLayer(layer.getLayer());
                } else if(connector instanceof OLViewConnector){
                    OLViewConnector view = (OLViewConnector) connector;
                    getWidget().getMap().setView(view.getView());
                }
            }
        }
    }

    @Override
    public void updateCaption(ComponentConnector connector) {
        // no-op
    }

    @Override
    public void onElementResize(ElementResizeEvent e) {
        getWidget().getMap().updateSize();
    }
}
