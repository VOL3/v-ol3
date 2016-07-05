package org.vaadin.addon.vol3.client.format;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import org.vaadin.gwtol3.client.format.*;

/**
 * Created by Vaadin Ltd / mjhosio on 05/06/16.
 */
public class OLFeatureFormatFactory {

	public static FeatureFormat create(OLFeatureFormat format){
		return create(format, null);
	}

	public static FeatureFormat create(OLFeatureFormat format, String optionsAsJson){

		JavaScriptObject params = null;
		if(optionsAsJson!=null){
			params = JsonUtils.safeEval(optionsAsJson);
		} else{
			params=JavaScriptObject.createObject();
		}
		FeatureFormat result=null;
		switch(format){
			case ESRI: result = EsriJSONFormat.create(params); break;
			case GEOJSON: result = GeoJSONFormat.create(params); break;
			case GML: result = GMLFormat.create(params); break;
			case GML2: result = GML2Format.create(params); break;
			case GML3: result = GML3Format.create(params); break;
			case GPX: result = GPXFormat.create(params); break;
			case IGC: result = IGCFormat.create(params); break;
			case KML: result = KMLFormat.create(params); break;
			case MVT: result = MVTFormat.create(params); break;
			case OSMXML: result = OSMXMLFormat.create(params); break;
			case POLYLINE: result = PolylineFormat.create(params); break;
			case TOPOJSON: result = TopoJSONFormat.create(params); break;
			case WFS: result = WFSFormat.create(params); break;
			case WKT: result = WKTFormat.create(params); break;
			default: result = null;
 		};
		return result;
	}
}
