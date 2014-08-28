package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;

/**
 * Vector source options passed to vector sources on construction
 * Created by mjhosio on 07/07/14.
 */
public class VectorSourceOptions extends AbstractVectorSourceOptions{

    protected VectorSourceOptions() {
    }

    public static native final VectorSourceOptions create()/*-{
        return {};
    }-*/;

    public final native void setFeatures(JsArray<Feature> features)/*-{
        this.features=features;
    }-*/;


}
