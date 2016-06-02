package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.Collection;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.format.FeatureFormat;

/**
 * Vector source options passed to vector sources on construction
 */
public class VectorSourceOptions extends JavaScriptObject{

    protected VectorSourceOptions() {
    }

    public static native final VectorSourceOptions create()/*-{
        return {};
    }-*/;

    public final native void setAttributions(JsArray<Attribution> attributions)/*-{
        this.attributions=attributions;
    }-*/;

    public final native void setFeatures(JsArray<Feature> features)/*-{
        this.features=features;
    }-*/;

    public final native void setFeatures(Collection<Feature> features) /*-{
        this.features = features;
    }-*/;

    public final native void setFormat(FeatureFormat format)/*-{
        this.format=format;
    }-*/;

    public final native void setLogo(String logo)/*-{
        this.logo=logo;
    }-*/;

    public final native void setUrl(String url)/*-{
        this.url = url;
    }-*/;

    public final native void setUseSpatialIndex(boolean useSpatialIndex)/*-{
        this.useSpatialIndex = useSpatialIndex;
    }-*/;

    public final native void setWrapX(boolean wrapX)/*-{
        this.wrapX = wrapX;
    }-*/;
}
