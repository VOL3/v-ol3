package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Reader/Writer for OSMXML features
 */
public class OSMXMLFormat extends XMLFeatureFormat {
    protected OSMXMLFormat() {
    }

    public static final native OSMXMLFormat create()/*-{
        return new $wnd.ol.format.OSMXML();
    }-*/;


    public final native Projection readProjection(String OSMXMLString)/*-{
        return this.readProjection(OSMXMLString);
    }-*/;

    public final native JsArray<Feature> readFeatures(String OSMXMLString)/*-{
        return this.readFeatures(OSMXMLString);
    }-*/;

    public final native JsArray<Feature> readFeatures(String OSMXMLString, String dataProjection, String featureProjection)/*-{
        return this.readFeatures(OSMXMLString, {dataProjection: dataProjection, featureProjection: featureProjection});
    }-*/;

}
