package org.vaadin.addon.vol3.client.layer;

import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.layer.OLImageLayer;
import org.vaadin.gwtol3.client.layer.ImageLayer;
import org.vaadin.gwtol3.client.layer.Layer;
import org.vaadin.gwtol3.client.source.Source;

/**
 * Created by mjhosio on 04/07/14.
 */
@Connect(OLImageLayer.class)
public class OLImageLayerConnector extends OLLayerConnector {

    @Override
    protected Layer createLayer(Source source) {
        return ImageLayer.create(source);
    }
}
