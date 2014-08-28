package org.vaadin.gwtol3.client.feature;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.geom.Geometry;
import org.vaadin.gwtol3.client.style.Style;

/**
 * A vector object for geographical features with a geometry and other attribute properties, similar to the features in vector file formats like GeoJSON. Features can be styled individually or use the style of their vector layer.
 * Created by mjhosio on 07/07/14.
 */
public class Feature extends JavaScriptObject {

    public static final String TEMP_ID="TEMP_ID";

    protected Feature() {
    }

    public static final native Feature create()/*-{
        return new $wnd.ol.Feature();
    }-*/;

    public final native String getId()/*-{
        return this.getId();
    }-*/;

    public final native void setId(String id)/*-{
        this.setId(id);
    }-*/;

    public final native void setGeometry(Geometry geometry)/*-{
        this.setGeometry(geometry);
    }-*/;

    public final native Geometry getGeometry()/*-{
        return this.getGeometry();
    }-*/;

    public final native void setStyles(JsArray<Style> styles)/*-{
        this.setStyle(styles);
    }-*/;

    public final native JsArray<Style> getStyles()/*-{
        return this.getStyle();
    }-*/;

    public final native Feature clone()/*-{
        return this.clone();
    }-*/;

    public native final void addFeatureChangeListener(FeatureChangeListener listener)/*-{
        var that=this;
        var callback=function(){
            $entry(listener.@org.vaadin.gwtol3.client.feature.FeatureChangeListener::featureChanged(Lorg/vaadin/gwtol3/client/feature/Feature;)(that));
        };
        this.on("change",callback,this);
    }-*/;
}

