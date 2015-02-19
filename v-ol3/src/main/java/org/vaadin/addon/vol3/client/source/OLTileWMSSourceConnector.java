package org.vaadin.addon.vol3.client.source;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.logging.client.ConsoleLogHandler;
import com.google.gwt.user.client.Window;
import com.vaadin.client.FastStringMap;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;

import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.tilegrid.OLTileGrid;
import org.vaadin.addon.vol3.client.tilegrid.OLWMTSTileGrid;
import org.vaadin.addon.vol3.client.tilegrid.OLWMTSTileGridOptions;
import org.vaadin.addon.vol3.client.tilegrid.OLXYZTileGrid;
import org.vaadin.addon.vol3.client.tilegrid.OLZoomifiyTileGrid;
import org.vaadin.addon.vol3.source.OLTileWMSSource;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.source.Source;
import org.vaadin.gwtol3.client.source.TileWMSSource;
import org.vaadin.gwtol3.client.source.TileWMSSourceOptions;
import org.vaadin.gwtol3.client.tilegrid.TileGrid;
import org.vaadin.gwtol3.client.tilegrid.WMTSTileGrid;
import org.vaadin.gwtol3.client.tilegrid.WMTSTileGridOptions;
import org.vaadin.gwtol3.client.tilegrid.XYZTileGrid;
import org.vaadin.gwtol3.client.tilegrid.ZoomifyTileGrid;

import java.util.Map;
import java.util.Set;

/**
 * Client-side connector for the OLTileWMSSource
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
        
        if(state.WMTSTileGridOptionsOriginX!=null && state.WMTSTileGridOptionsOriginY!=null){
        	TileGrid tileGrid = createTileGridForWMTS(state);
        	options.setTileGrid(tileGrid);
        }
        
        return TileWMSSource.create(options);
    }

    private TileGrid createTileGridForWMTS(OLTileWMSSourceState state) {
		WMTSTileGridOptions wmtsTileGridOptions = WMTSTileGridOptions.create();
		wmtsTileGridOptions.setOrigin(Coordinate.create(state.WMTSTileGridOptionsOriginX, state.WMTSTileGridOptionsOriginY));
		wmtsTileGridOptions.setTileSize(state.WMTSTileGridOptionsTileSize);
		
		
		JsArrayNumber jsResolutionsArray= (JsArrayNumber) JsArrayNumber.createArray(state.WMTSTileGridOptionsresolutions.length);
        for(double resolutionValue : state.WMTSTileGridOptionsresolutions){
        	jsResolutionsArray.push(resolutionValue);
        }
		wmtsTileGridOptions.setResolutions(jsResolutionsArray);
		
		
//		JsArray<Coordinate> jsOriginsArray= (JsArray<Coordinate>) JsArray.createArray(state..origins.length);
//        for(OLCoordinate resolutionValue : state.options.origins){
//        	jsOriginsArray.push(Coordinate.create(resolutionValue.x, resolutionValue.y));
//        	GWT.log(resolutionValue.x + " " + resolutionValue.y);
//        }
        
		//wmtsTileGridOptions.setOrigins(jsOriginsArray);
		return WMTSTileGrid.create(wmtsTileGridOptions);
	}

	private TileGrid createTileGridForZoomify(OLZoomifiyTileGrid tileGrid) {
    	if(tileGrid.resolutions != null){
    		JsArrayNumber jsResolutionsArray= (JsArrayNumber) JsArrayNumber.createArray(tileGrid.resolutions.length);
            for(double resolutionValue : tileGrid.resolutions){
            	jsResolutionsArray.push(resolutionValue);
            }
            return ZoomifyTileGrid.create(jsResolutionsArray);
    	}
		return ZoomifyTileGrid.create();
	}
    
    private TileGrid createTileGridForXYZ(OLXYZTileGrid tileGrid){
    	return XYZTileGrid.create(tileGrid.maxZoom);
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
