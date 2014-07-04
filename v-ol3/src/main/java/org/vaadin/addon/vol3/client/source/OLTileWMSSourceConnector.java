package org.vaadin.addon.vol3.client.source;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.vaadin.client.FastStringMap;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.source.OLTileWMSSource;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.Extent;
import org.vaadin.gwtol3.client.source.Source;
import org.vaadin.gwtol3.client.source.TileWMSSource;
import org.vaadin.gwtol3.client.source.TileWMSSourceOptions;

import java.util.Map;
import java.util.Set;

/**
 * Created by mjhosio on 03/07/14.
 */
@Connect(OLTileWMSSource.class)
public class OLTileWMSSourceConnector extends OLSourceConnector {

    @Override
    protected Source createSource() {
        TileWMSSourceOptions options=TileWMSSourceOptions.create();
        OLTileWMSSourceState state=getState();
        if(state.hidpi!=null){
            options.setHidpi(state.hidpi);
        }
        if(state.attributions!=null && state.attributions.length>0){
            JsArray jsArray= (JsArray) JsArray.createArray(state.attributions.length);
            for(String attribution : state.attributions){
                jsArray.push(Attribution.create(attribution));
            }
            options.setAttributions(jsArray);
        }
        if(state.crossOriginPolicy!=null){
            options.setCrossOrigin(state.crossOriginPolicy);
        }
        if(state.extent!=null){
            Extent extent=Extent.create(state.extent.minX, state.extent.minY, state.extent.maxX, state.extent.maxY);
            options.setExtent(extent);
        }
        if(state.gutter!=null){
            options.setGutter(state.gutter);
        }
        if(state.logo!=null){
            options.setLogo(state.logo);
        }
        if(state.maxZoom!=null){
            options.setMaxZoom(state.maxZoom);
        }
        if(state.params!=null){
            FastStringMap map = (FastStringMap) FastStringMap.createObject();
            Set<Map.Entry<String, String>> entries = state.params.entrySet();
            for(Map.Entry<String,String> entry : entries){
                map.put(entry.getKey(),entry.getValue());
            }
            options.setParams(map);
        }
        if(state.projection!=null){
            options.setProjection(state.projection);
        }
        if(state.serverType!=null){
            options.setServerType(state.serverType);
        }
        if(state.url!=null){
            options.setUrl(state.url);
        }
        if(state.urls!=null){
            JsArrayString jsArray = (JsArrayString) JsArrayString.createArray(state.urls.length);
            for(String url : state.urls){
                jsArray.push(url);
            }
            options.setUrls(jsArray);
        }
        return TileWMSSource.create(options);
    }

    @Override
    public OLTileWMSSourceState getState() {
        return (OLTileWMSSourceState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        if(!stateChangeEvent.isInitialStateChange()){
            updateParams();
        }
    }

    @Override
    public TileWMSSource getSource() {
        return (TileWMSSource) super.getSource();
    }

    private void updateParams(){
        FastStringMap map = (FastStringMap) FastStringMap.createObject();
        Set<Map.Entry<String, String>> entries = getState().params.entrySet();
        for(Map.Entry<String,String> entry : entries){
            map.put(entry.getKey(),entry.getValue());
        }
        getSource().updateParams(map);
    }
}
