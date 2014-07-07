package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;

/**
 * Abstract base class for vector sources in one of the supported formats
 * Created by mjhosio on 07/07/14.
 */
public abstract class FormatVectorSource extends VectorSource{
    protected FormatVectorSource() {
    }

    /** Reads the features from given source
     *
     * @param featureSource the source for features (ArrayBuffer | Document | node | object | string)
     * @return
     */
    public final native JsArray<Feature> readFeatures(JavaScriptObject featureSource)/*-{
        return this.readFeatures(featureSource);
    }-*/;

}
