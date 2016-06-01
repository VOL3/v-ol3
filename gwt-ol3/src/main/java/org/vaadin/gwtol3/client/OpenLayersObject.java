package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Abstract base class; normally only used for creating subclasses and not
 * instantiated in apps.
 */
public class OpenLayersObject extends JavaScriptObject {

    protected OpenLayersObject() {
    }

    public native final OpenLayersObject get(String propertyId) /*-{
        return this.get(propertyId);
     }-*/;

    public native final void set(String propertyId, OpenLayersObject value) /*-{
        this.set(propertyId, value);
    }-*/;

    public final native JavaScriptObject getProperties()/*-{
        return this.getProperties();
    }-*/;

    public final native void setProperties(JavaScriptObject properties)/*-{
        this.setProperties(properties);
    }-*/;

    public final native JsArrayString getKeys()/*-{
        return this.getKeys();
    }-*/;
}

