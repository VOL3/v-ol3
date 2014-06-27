package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 25/06/14.
 */
public class Overlay extends JavaScriptObject {

    protected Overlay(){

    }

    public static native Overlay create()
    /*-{
        return new $wnd.ol.Overlay();
    }-*/;
}
