package org.vaadin.addon.vol3.client.source;

import com.google.gwt.core.client.JsArray;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.source.OLOSMSource;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.source.OSMSource;
import org.vaadin.gwtol3.client.source.OSMSourceOptions;
import org.vaadin.gwtol3.client.source.Source;

/**
 * Created by mjhosio on 02/07/14.
 */
@Connect(OLOSMSource.class)
public class OLOSMSourceConnector extends OLXYZSourceConnector{

    @Override
    protected Source createSource() {
        OSMSourceOptions options=OSMSourceOptions.create();
        JsArray<Attribution> attributions=JsArray.createArray().cast();
        if(getState().showDataAttributions!=null && getState().showDataAttributions){
            attributions.push(OSMSource.createDataAttribution());
        }
        if(getState().showTileAttributions!=null && getState().showTileAttributions){
            attributions.push(OSMSource.createTileAttribution());
        }
        if(getState().customAttributions!=null){
            for(String attribution : getState().customAttributions){
                attributions.push(Attribution.create(attribution));
            }
        }
        if(attributions.length()>0) {
            options.setAttributions(attributions);
        }
        if(getState().crossOriginPolicy!=null){
            options.setCrossOrigin(getState().crossOriginPolicy);
        }
        if(getState().maxZoom!=null){
            options.setMaxZoom(getState().maxZoom);
        }
        return OSMSource.create(options);
    }

    @Override
    public OLOSMSourceState getState() {
        return (OLOSMSourceState) super.getState();
    }
}
