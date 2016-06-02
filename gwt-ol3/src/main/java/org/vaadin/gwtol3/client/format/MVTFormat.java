package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 *
 * Feature format for reading data in the Mapbox MVT format.
 * Created by Vaadin Ltd / mjhosio on 02/06/16.
 */
public class MVTFormat extends FeatureFormat{
	protected MVTFormat() {
	}

	public static final native MVTFormat create()/*-{
        return new $wnd.ol.format.MVT();
    }-*/;

	public static final native MVTFormat create(boolean editable)/*-{
		if(editable){
			return new $wnd.ol.format.MVT({featureClass: $wnd.ol.Feature});
		} else{
	        return new $wnd.ol.format.MVT();
		}
    }-*/;

	public static final native MVTFormat create(String geometryName)/*-{
        return new $wnd.ol.format.MVT({geometryName: geometryName});
    }-*/;

	public static final native MVTFormat create(String geometryName, String layerName, JsArrayString layers)/*-{
        return new $wnd.ol.format.MVT({geometryName: geometryName, layerName: layerName, layers: layers});
    }-*/;

	public static final native MVTFormat create(String geometryName, String layerName, JsArrayString layers, boolean editable)/*-{
		if(editable){
            return new $wnd.ol.format.MVT({geometryName: geometryName, layerName: layerName, layers: layers, featureClass: $wnd.ol.Feature});
		} else {
	        return new $wnd.ol.format.MVT({geometryName: geometryName, layerName: layerName, layers: layers});
		}
    }-*/;

	public final native JsArray<Feature> readFeatures(String MVTString)/*-{
        return this.readFeatures(MVTString);
    }-*/;

	public final native Projection readProjection(String MVTString)/*-{
        return this.readProjection(MVTString);
    }-*/;

	public final native void setLayers(JsArrayString layers)/*-{
        return this.setLayers(layers);
    }-*/;

}
