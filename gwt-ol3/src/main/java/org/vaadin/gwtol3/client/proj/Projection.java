package org.vaadin.gwtol3.client.proj;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 25/06/14.
 */
public class Projection extends JavaScriptObject {

    protected Projection() {
    }

    public static final native Projection get(String crsString)/*-{
        $wnd.ol.proj.get(crsString);
    }-*/;
}
