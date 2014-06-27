package org.vaadin.addon.vol3.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.ui.AbstractSingleComponentContainerConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.OLLayer;
import org.vaadin.gwtol3.client.layer.Layer;

/**
 * Created by mjhosio on 27/06/14.
 */
@Connect(OLLayer.class)
public class OLLayerConnector extends AbstractSingleComponentContainerConnector {

    private Layer layer;

    // we create a dummy widget since this connector is used
    // only to handle layer state serialization
    private static final Widget dummyWidget=new Label();

    public OLLayerConnector(){
        super();
    }

    private Layer getLayer(){
        return layer;
    }

    @Override
    public Widget getWidget() {
        return dummyWidget;
    }

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
        for(ComponentConnector c : this.getChildComponents()){
            if(c instanceof OLSourceConnector){
                OLSourceConnector sourceConnector = (OLSourceConnector) c;

            }
        }
        // set layer data source
    }

    @Override
    public void updateCaption(ComponentConnector connector) {
        // no-op
    }
}
