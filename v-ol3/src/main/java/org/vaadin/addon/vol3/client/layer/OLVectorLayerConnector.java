package org.vaadin.addon.vol3.client.layer;

import com.vaadin.client.annotations.OnStateChange;
import org.vaadin.gwtol3.client.layer.VectorLayer;
import org.vaadin.gwtol3.client.source.VectorSource;

/**
 * Created by mjhosio on 30/06/14.
 */
public class OLVectorLayerConnector extends OLLayerConnector {

    private VectorLayer layer;

    @Override
    public VectorLayer getLayer() {
        if(layer==null){
            layer = VectorLayer.create((VectorSource) super.getSource());
        }
        return layer;
    }

    @Override
    public OLVectorLayerState getState() {
        return (OLVectorLayerState) super.getState();
    }

    @OnStateChange("styles")
    void updateStyles(){
        //TODO: apply styles
    }
}
