package org.vaadin.addon.vol3.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.ui.AbstractHasComponentsConnector;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.MapWidget;
import org.vaadin.gwtol3.client.View2D;
import org.vaadin.gwtol3.client.layer.Tile;
import org.vaadin.gwtol3.client.resources.ResourceInjector;
import org.vaadin.gwtol3.client.source.MapQuest;

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
    protected Widget createWidget() {
        MapWidget widget=GWT.create(MapWidget.class);
        // DEMO code, will get rid of this in next commit
        MapQuest source=MapQuest.create(MapQuest.LAYER_OSM);
        Tile tile= Tile.create(source);
        widget.getMap().addLayer(tile);
        View2D view=View2D.create();
        view.setZoom(1);
        view.setCenter(Coordinate.create(0,0));
        widget.getMap().setView(view);
        // END OF DEMO
        return widget;
    }

    @Override
    public AbstractComponentState getState() {
        return super.getState();
    }

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
        // TODO: handle children
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
