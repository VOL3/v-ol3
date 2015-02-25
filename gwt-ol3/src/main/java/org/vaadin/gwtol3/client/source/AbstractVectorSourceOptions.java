package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Attribution;

/**
 * Options for the vector source
 */
public class AbstractVectorSourceOptions extends JavaScriptObject {

    protected AbstractVectorSourceOptions() {
    }

    public final native void setAttributions(JsArray<Attribution> attributions)/*-{
        this.attributions=attributions;
    }-*/;

    public final native void setLogo(String logo)/*-{
        this.logo=logo;
    }-*/;
}
