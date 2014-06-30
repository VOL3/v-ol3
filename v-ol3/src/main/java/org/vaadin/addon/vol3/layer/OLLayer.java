package org.vaadin.addon.vol3.layer;

import com.vaadin.ui.AbstractSingleComponentContainer;
import com.vaadin.ui.Component;
import org.vaadin.addon.vol3.source.OLSource;

/**
 * Created by mjhosio on 27/06/14.
 */
public abstract class OLLayer extends AbstractSingleComponentContainer{

    protected OLLayer(OLSource source){
        super.setContent(source);
    }

    @Override
    public void setContent(Component content) {
        throw new UnsupportedOperationException("The source of the layer can not be changed after instantiation");
    }
}
