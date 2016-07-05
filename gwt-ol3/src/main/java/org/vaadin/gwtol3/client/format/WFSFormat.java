package org.vaadin.gwtol3.client.format;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Reader/Writer for WFS features
 */
public class WFSFormat extends XMLFeatureFormat{

    protected WFSFormat() {
    }

    public static final native WFSFormat create()/*-{
        return new $wnd.ol.format.WFS();
    }-*/;

    public static final native WFSFormat create(JavaScriptObject opts)/*-{
        return new $wnd.ol.format.WFS(opts);
    }-*/;


    public static final native WFSFormat create(WFSFormatOptions options)/*-{
        return new $wnd.ol.format.WFS(options);
    }-*/;


    public final native Projection readProjection(String WFSString)/*-{
        return this.readProjection(WFSString);
    }-*/;


    public final native JsArray<Feature> readFeatures(String WFSString)/*-{
        return this.readFeatures(WFSString);
    }-*/;

    public final native JsArray<Feature> readFeatures(String WFSString, String dataProjection, String featureProjection)/*-{
        return this.readFeatures(WFSString, {dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

}
