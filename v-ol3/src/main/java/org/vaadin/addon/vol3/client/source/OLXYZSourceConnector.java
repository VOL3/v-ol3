package org.vaadin.addon.vol3.client.source;

import com.vaadin.client.annotations.OnStateChange;
import org.vaadin.gwtol3.client.source.XYZSource;

/**
 * Created by mjhosio on 02/07/14.
 */
public abstract class OLXYZSourceConnector extends OLSourceConnector{

    @OnStateChange("urlTemplate")
    void updateUrlTemplate(){
        if(getState().urlTemplate!=null){
            getSource().setUrl(getState().urlTemplate);
        }
    }

    @Override
    public abstract XYZSource getSource();

    @Override
    public OLXYZSourceState getState() {
        return (OLXYZSourceState) super.getState();
    }
}
