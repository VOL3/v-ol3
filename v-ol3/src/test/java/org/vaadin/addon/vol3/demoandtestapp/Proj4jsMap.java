package org.vaadin.addon.vol3.demoandtestapp;

import com.vaadin.annotations.JavaScript;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLMapOptions;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.feature.OLPoint;
import org.vaadin.addon.vol3.layer.OLImageLayer;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.addon.vol3.source.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vaadin Ltd / mjhosio on 29/06/15.
 */
@JavaScript("proj4.js")
public class Proj4jsMap extends BasicMap {

	@Override
	protected OLMap createMap() {
		OLMapOptions opts=new OLMapOptions();
		// proj4js string copied from epsg.io
		opts.defineProjection("EPSG:21781","+proj=somerc +lat_0=46.95240555555556 +lon_0=7.439583333333333 +k_0=1 +x_0=600000 +y_0=200000 +ellps=bessel +towgs84=674.4,15.1,405.3,0,0,0,0 +units=m +no_defs");
		OLMap map=new OLMap(opts);
		OLLayer layer=createLayer(createSource());
		map.addLayer(layer);
		map.setView(createView());
		map.setSizeFull();
		// test also vector layer
		OLVectorLayer vectorLayer=createVectorLayer();
		map.addLayer(vectorLayer);
		return map;
	}

	private OLVectorLayer createVectorLayer(){
		OLVectorSourceOptions vectorOptions=new OLVectorSourceOptions();
		// Since we would use the view projection by default, we change the input projection here to lat/lon
		vectorOptions.setInputProjection("EPSG:4326");
		OLVectorSource vectorSource=new OLVectorSource(vectorOptions);
		vectorSource.addFeature(createPointFeature("feature-a-1",8,45));
		vectorSource.addFeature(createPointFeature("feature-a-2",8,46));
		vectorSource.addFeature(createPointFeature("feature-a-3",8,47));
		OLVectorLayer vectorLayer=new OLVectorLayer(vectorSource);
		return vectorLayer;
	}

	private OLFeature createPointFeature(String id, double x, double y){
		OLFeature testFeature=new OLFeature(id);
		testFeature.setGeometry(new OLPoint(x,y));
		return testFeature;
	}

	@Override
	protected OLLayer createLayer(OLSource source) {
		return new OLImageLayer(source);
	}

	@Override
	protected OLSource createSource() {
		OLImageWMSSourceOptions options =new OLImageWMSSourceOptions();
		options.setUrl("http://wms.geo.admin.ch");
		options.setCrossOriginPolicy("anonymous");
		options.setAttributions(new String[]{"Tiles &copy; <a href=\"http://www.geo.admin.ch/internet/geoportal/en/home.html\">Pixelmap 1:1000000 / geo.admin.ch</a>"});
		Map<String,String> params=new HashMap<String, String>();
		params.put("LAYERS", "ch.swisstopo.pixelkarte-farbe-pk1000.noscale");
		params.put("FORMAT", "image/jpeg");
		options.setParams(params);
		options.setServerType("mapserver");
		return new OLImageWMSSource(options);
	}

	@Override
	protected OLView createView() {
		OLViewOptions opts=new OLViewOptions();
		opts.setMapProjection("EPSG:21781");
		opts.setInputProjection("EPSG:4326");
		opts.setExtent(new OLExtent(new OLCoordinate(0, 40), new OLCoordinate(10, 60)));
		OLView view=new OLView(opts);
		view.setCenter(8.23, 46.86);
		view.setZoom(8);
		return view;
	}

	@Override
	protected void resetView() {
		map.getView().setCenter(8.23, 46.86);
		map.getView().setZoom(8);
	}
}
