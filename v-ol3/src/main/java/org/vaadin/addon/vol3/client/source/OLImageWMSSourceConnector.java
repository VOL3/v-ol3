package org.vaadin.addon.vol3.client.source;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.vaadin.client.FastStringMap;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.source.OLImageWMSSource;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.proj.Projection;
import org.vaadin.gwtol3.client.source.GetFeatureInfoOptions;
import org.vaadin.gwtol3.client.source.ImageWMSSource;
import org.vaadin.gwtol3.client.source.ImageWMSSourceOptions;
import org.vaadin.gwtol3.client.source.Source;

import java.util.Map;
import java.util.Set;

/**
 * Client-side connector for the ImageWMSSource
 */
@Connect(OLImageWMSSource.class)
public class OLImageWMSSourceConnector extends OLSourceConnector implements HasFeatureInfoUrl{
	private static final long serialVersionUID = 1L;
	//private ImageWMSSource source;

    @Override
    protected Source createSource() {
        ImageWMSSourceOptions options=ImageWMSSourceOptions.create();
        OLImageWMSSourceState state=getState();
        if(state.hidpi!=null){
            options.setHidpi(state.hidpi);
        }
        if(state.attributions!=null && state.attributions.length>0){
            JsArray<Attribution> jsArray= JsArray.createArray().cast();
            for(String attribution : state.attributions){
                jsArray.push(Attribution.create(attribution));
            }
            options.setAttributions(jsArray);
        }
        if(state.crossOriginPolicy!=null){
            options.setCrossOrigin(state.crossOriginPolicy);
        }
        if(state.logo!=null){
            options.setLogo(state.logo);
        }
        if(state.params!=null){
			FastStringMap<String> map = FastStringMap.create();
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
        if(state.ratio!=null){
            options.setRatio(state.ratio);
        }
        if(state.resolutions!=null){
            JsArrayNumber jsArray= (JsArrayNumber) JsArrayNumber.createArray(state.resolutions.length);
            for(Double resolution : state.resolutions){
                jsArray.push(resolution);
            }
            options.setResolutions(jsArray);
        }
        return ImageWMSSource.create(options);
    }

    @Override
    public OLImageWMSSourceState getState() {
        return (OLImageWMSSourceState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        if(!stateChangeEvent.isInitialStateChange()){
            updateParams();
        }
    }

    @Override
    public ImageWMSSource getSource() {
        return (ImageWMSSource) super.getSource();
    }

    private void updateParams(){
        FastStringMap<String> map = FastStringMap.create();
        Set<Map.Entry<String, String>> entries = getState().params.entrySet();
        for(Map.Entry<String,String> entry : entries){
            map.put(entry.getKey(),entry.getValue());
        }
        getSource().updateParams(map);
    }

    @Override
    public String getGetFeatureInfoUrl(OLCoordinate coordinate, double resolution, Projection projection) {
        GetFeatureInfoOptions opts=GetFeatureInfoOptions.create();
        opts.set("INFO_FORMAT", "application/json");
        opts.set("FEATURE_COUNT", "10");
        if(getState().getFeatureInfoParams!=null){
            for(Map.Entry<String,String> entry : getState().getFeatureInfoParams.entrySet()){
                opts.set(entry.getKey(), entry.getValue());
            }
        }
        return getSource().getGetFeatureInfoUrl(Coordinate.create(coordinate.x, coordinate.y), resolution, projection, opts);
    }

}
