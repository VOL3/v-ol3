package org.vaadin.addon.vol3.client.layer;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.ui.AbstractSingleComponentContainerConnector;
import org.vaadin.addon.vol3.client.source.OLSourceConnector;
import org.vaadin.gwtol3.client.layer.Layer;
import org.vaadin.gwtol3.client.source.Source;

import java.util.List;

/**
 * Created by mjhosio on 27/06/14.
 */
public abstract class OLLayerConnector extends AbstractSingleComponentContainerConnector {

    // we create a dummy widget since this connector is used
    // only to handle layer state serialization
    private static final Widget dummyWidget=new Label();

    public OLLayerConnector(){
        super();
    }

    @Override
    public Widget getWidget() {
        return dummyWidget;
    }

    protected OLSourceConnector getSourceConnector(){
        List<ComponentConnector> childComponents = this.getChildComponents();
        if(!childComponents.isEmpty()){
            return ((OLSourceConnector)childComponents.get(0));
        }
        return null;
    }

    @Override
    public void updateCaption(ComponentConnector connector) {
        // no-op
    }

    /** Returns the underlying wrapped javascript source implementation
     *
     * @return the source implementation
     */
    public Source getSource(){
        return getSourceConnector().getSource();
    }

    /** Returns the underlying wrapped javascript layer implementation
     *
     * @return layer implementation
     */
    public abstract Layer getLayer();

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
        // no-op
    }
}
