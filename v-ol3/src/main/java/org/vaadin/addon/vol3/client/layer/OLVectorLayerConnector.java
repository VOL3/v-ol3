package org.vaadin.addon.vol3.client.layer;

import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.client.style.OLStyleConverter;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.gwtol3.client.layer.Layer;
import org.vaadin.gwtol3.client.layer.VectorLayer;
import org.vaadin.gwtol3.client.source.Source;
import org.vaadin.gwtol3.client.source.VectorSource;

/**
 * Client-side connector for the vector layer
 */
@Connect(OLVectorLayer.class)
public class OLVectorLayerConnector extends OLLayerConnector {

    @Override
    public OLVectorLayerState getState() {
        return (OLVectorLayerState) super.getState();
    }

    @Override
    protected Layer createLayer(Source source) {
        return VectorLayer.create((VectorSource) source);
    }

    @Override
    public VectorLayer getLayer() {
        return (VectorLayer) super.getLayer();
    }

    @OnStateChange("featureStyles")
    void updateStyles(){
        getLayer().setStyles(OLStyleConverter.convert(getState().featureStyles));
    }
}
