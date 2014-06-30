package org.vaadin.addon.vol3.client.layer;

import com.vaadin.client.annotations.OnStateChange;
import org.vaadin.gwtol3.client.layer.Vector;

/**
 * Created by mjhosio on 30/06/14.
 */
public class OLVectorConnector extends OLLayerConnector {

    private Vector layer;

    @Override
    public Vector getLayer() {
        if(layer==null){
            layer=Vector.create(super.getSource());
        }
        return layer;
    }

    @Override
    public OLVectorState getState() {
        return (OLVectorState) super.getState();
    }

    @OnStateChange("styles")
    void updateStyles(){
        //TODO: apply styles
    }
}
