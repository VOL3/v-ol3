package org.vaadin.addon.vol3.demoandtestapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.format.OLFeatureFormat;
import org.vaadin.addon.vol3.format.OLWFSFormatOptions;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.addon.vol3.source.OLVectorSource;
import org.vaadin.addon.vol3.source.OLVectorSourceOptions;

/**
 * Created by Vaadin Ltd / mjhosio on 05/06/16.
 */
public class WFSTestMap extends BasicMap {


	@Override
	protected OLMap createMap() {
		OLMap map=super.createMap();
		// lets add some wfs features
		OLVectorSourceOptions vectorOptions=new OLVectorSourceOptions();
		// this is proxied by the TestServer
		vectorOptions.setUrl("http://localhost:9998/proxyserver_wfs/wfs_vg1000?request=GetFeature&service=WFS&typename=vg1000:vg1000_lan&srsname=EPSG:3857");
		vectorOptions.setFormat(OLFeatureFormat.WFS);
		try {
			vectorOptions.setFormatOptions(new OLWFSFormatOptions());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		OLVectorSource vectorSource=new OLVectorSource(vectorOptions);
		OLVectorLayer vectorLayer=new OLVectorLayer(vectorSource);
		vectorLayer.setLayerVisible(true);
		map.addLayer(vectorLayer);
		return map;
	}
}
