package org.vaadin.addon.vol3.demoandtestapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.format.OLFeatureFormat;
import org.vaadin.addon.vol3.client.style.OLFillStyle;
import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.addon.vol3.client.style.OLTextStyle;
import org.vaadin.addon.vol3.format.OLKMLFormatOptions;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.addon.vol3.source.OLVectorSource;
import org.vaadin.addon.vol3.source.OLVectorSourceOptions;
import org.vaadin.addon.vol3.util.StyleUtils;

/**
 * Created by Vaadin Ltd / mjhosio on 05/07/16.
 */
public class KMLTestMap extends BasicMap {

	@Override
	protected OLMap createMap() {
		OLMap map=super.createMap();
		// lets add some wfs features
		OLVectorSourceOptions vectorOptions=new OLVectorSourceOptions();
		// this is proxied by the TestServer
		vectorOptions.setUrl("VAADIN/samples/sample.kml");
		vectorOptions.setFormat(OLFeatureFormat.KML);
		OLKMLFormatOptions kmlOpts=new OLKMLFormatOptions();
		kmlOpts.setExtractStyles(true);
		kmlOpts.setShowPointNames(true);
		try {
			vectorOptions.setFormatOptions(kmlOpts);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		OLVectorSource vectorSource=new OLVectorSource(vectorOptions);
		OLVectorLayer vectorLayer=new OLVectorLayer(vectorSource);
		OLStyle style= StyleUtils.createDefaultStyle();
		style.textStyle=new OLTextStyle();
		style.textStyle.font="12px Calibri,sans-serif";
		style.textStyle.fill=new OLFillStyle("black");
		style.textStyle.stroke=StyleUtils.createDefaultStrokeStyle();
		style.textStyle.stroke.color="black";
		style.textStyle.stroke.width=3.0;		vectorLayer.setStyle(style);
		vectorLayer.setLayerVisible(true);
		map.addLayer(vectorLayer);
		return map;
	}
}
