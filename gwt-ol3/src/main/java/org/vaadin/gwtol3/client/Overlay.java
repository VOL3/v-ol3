package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wrapper for an overlay displayed on a map
 */
public class Overlay extends JavaScriptObject {

    protected Overlay(){

    }

    public static native Overlay create()
    /*-{
        return new $wnd.ol.Overlay();
    }-*/;
}
