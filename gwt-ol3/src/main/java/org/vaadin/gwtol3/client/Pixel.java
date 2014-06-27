package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 25/06/14.
 */
public class Pixel extends JavaScriptObject {
    protected Pixel(){
    }

    public static native Pixel create(double x, double y)/*-{
        return [x,y];
    }-*/;
}
