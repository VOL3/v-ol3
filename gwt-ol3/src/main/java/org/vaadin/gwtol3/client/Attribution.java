package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Attribution for a layer source
 * Created by mjhosio on 02/07/14.
 */
public class Attribution extends JavaScriptObject{
    protected Attribution() {
    }

    public static final native Attribution create(String html) /*-{
        return new $wnd.ol.Attribution({html: html});
    }-*/;
}
