package org.vaadin.addon.vol3.client.layer;

import com.vaadin.client.annotations.OnStateChange;
import org.vaadin.gwtol3.client.layer.Layer;
import org.vaadin.gwtol3.client.layer.VectorLayer;
import org.vaadin.gwtol3.client.source.Source;
import org.vaadin.gwtol3.client.source.VectorSource;

/**
 * Created by mjhosio on 30/06/14.
 */
public class OLVectorLayerConnector extends OLLayerConnector {

    @Override
    public OLVectorLayerState getState() {
        return (OLVectorLayerState) super.getState();
    }

    @Override
    protected Layer createLayer(Source source) {
        return VectorLayer.create((VectorSource) source);
    }

    @OnStateChange("styles")
    void updateStyles(){
        //TODO: apply styles
    }
}
