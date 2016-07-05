package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Reader/Writer for TopoJSON features
 */
public class TopoJSONFormat extends JSONFeatureFormat{
    protected TopoJSONFormat() {
    }

    public static final native TopoJSONFormat create()/*-{
        return new $wnd.ol.format.TopoJSON();
    }-*/;

    public static final native TopoJSONFormat create(JavaScriptObject opts)/*-{
        return new $wnd.ol.format.TopoJSON(opts);
    }-*/;

    public static final native TopoJSONFormat create(String defaultDataProjection)/*-{
        return new $wnd.ol.format.TopoJSON({defaultDataProjection: defaultDataProjection});
    }-*/;


    public final native JsArray<Feature> readFeatures(String topoJSONString)/*-{
        return this.readFeatures(topoJSONString);
    }-*/;

    public final native Projection readProjection(String topoJSONString)/*-{
        return this.readProjection(topoJSONString);
    }-*/;

}
