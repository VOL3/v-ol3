package org.vaadin.addon.vol3.client.source;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.vaadin.client.FastStringMap;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.source.OLTileWMSSource;
import org.vaadin.addon.vol3.client.util.DataConversionUtils;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.source.Source;
import org.vaadin.gwtol3.client.source.TileWMSSource;
import org.vaadin.gwtol3.client.source.TileWMSSourceOptions;
import org.vaadin.gwtol3.client.tilegrid.TileGrid;
import org.vaadin.gwtol3.client.tilegrid.WMTSTileGrid;
import org.vaadin.gwtol3.client.tilegrid.WMTSTileGridOptions;

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
            JsArray<Attribution> jsArray= JsArray.createArray().cast();
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

        if(state.tileGrid != null){
        	TileGrid tileGrid = createTileGrid(state.tileGrid);
        	options.setTileGrid(tileGrid);
        }

        return TileWMSSource.create(options);
    }

    private TileGrid createTileGrid(OLTileGrid tileGrid) {
		WMTSTileGridOptions options = WMTSTileGridOptions.create();
        if(tileGrid.origin!=null){
            options.setOrigin(Coordinate.create(tileGrid.origin.x, tileGrid.origin.y));
        } else if(tileGrid.origins!=null){
            options.setOrigins(DataConversionUtils.toJsArrayCoordinate(tileGrid.origins));
        }
        if(tileGrid.resolutions!=null){
            options.setResolutions(DataConversionUtils.toJsArrayNumber(tileGrid.resolutions));
        }
        if(tileGrid.tileSize!=null){
            options.setTileSize(tileGrid.tileSize);
        } else if(tileGrid.tileSizes!=null){
            options.setTileSizes(DataConversionUtils.toJsArrayNumber(tileGrid.tileSizes));
        }
        if(tileGrid.minZoom!=null){
            options.setMinZoom(tileGrid.minZoom);
        }
        if(tileGrid.maxZoom!=null){
            options.setMaxZoom(tileGrid.maxZoom);
        }
        if(tileGrid.matrixIds!=null){
            options.setMatrixIds(DataConversionUtils.toJsArrayString(tileGrid.matrixIds));
        }
		return WMTSTileGrid.create(options);
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
