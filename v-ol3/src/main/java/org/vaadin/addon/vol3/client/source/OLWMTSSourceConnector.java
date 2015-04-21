package org.vaadin.addon.vol3.client.source;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.client.util.DataConversionUtils;
import org.vaadin.addon.vol3.source.OLWMTSSource;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.source.Source;
import org.vaadin.gwtol3.client.source.WMTSSource;
import org.vaadin.gwtol3.client.source.WMTSSourceOptions;
import org.vaadin.gwtol3.client.tilegrid.TileGrid;
import org.vaadin.gwtol3.client.tilegrid.WMTSTileGrid;
import org.vaadin.gwtol3.client.tilegrid.WMTSTileGridOptions;

/**
 * Created by Vaadin Ltd / mjhosio on 21/04/15.
 */
@Connect(OLWMTSSource.class)
public class OLWMTSSourceConnector extends OLSourceConnector {

	@Override
	public WMTSSource getSource() {
		return (WMTSSource) super.getSource();
	}

	@Override
	protected Source createSource() {
		WMTSSourceOptions opts=WMTSSourceOptions.create();
		OLWMTSSourceState state=getState();
		if(state.opaque!=null){
			opts.setOpaque(state.opaque);
		}
		if(getState().wrapX!=null){
			opts.setWrapX(getState().wrapX);
		}
		if(state.attributions!=null && state.attributions.length>0){
			JsArray<Attribution> jsArray= JsArray.createArray().cast();
			for(String attribution : state.attributions){
				jsArray.push(Attribution.create(attribution));
			}
		}
		if(state.crossOriginPolicy!=null){
			opts.setCrossOrigin(state.crossOriginPolicy);
		}
		if(state.logo!=null){
			opts.setLogo(state.logo);
		}
		if(state.maxZoom!=null){
			opts.setMaxZoom(state.maxZoom);
		}
		if(state.projection!=null){
			opts.setProjection(state.projection);
		}
		if(state.url!=null){
			opts.setUrl(state.url);
		}
		if(state.urls!=null){
			JsArrayString jsArray = (JsArrayString) JsArrayString.createArray(state.urls.length);
			for(String url : state.urls){
				jsArray.push(url);
			}
			opts.setUrls(jsArray);
		}
		if(state.tileGrid != null){
			TileGrid tileGrid = createTileGrid(state.tileGrid);
			opts.setTileGrid(tileGrid);
		}
		if(state.format!=null){
			opts.setFormat(state.format);
		}
		if(state.version!=null){
			opts.setVersion(state.version);
		}
		if(state.matrixSet!=null){
			opts.setMatrixSet(state.matrixSet);
		}
		if(state.layer!=null){
			opts.setLayer(state.layer);
		}
		if(state.requestEncoding!=null){
			opts.setRequestEncoding(state.requestEncoding);
		}
		if(state.style!=null){
			opts.setStyle(state.style);
		}
		if(state.tilePixelRatio!=null){
			opts.setTilePixelRation(state.tilePixelRatio);
		}
		WMTSSource source=WMTSSource.create(opts);
		return source;
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
	public OLWMTSSourceState getState() {
		return (OLWMTSSourceState) super.getState();
	}
}
