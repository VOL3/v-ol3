package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 24/06/14.
 */
public class Coordinate extends JavaScriptObject{

    protected Coordinate(){

    }

    public static native Coordinate create(double x, double y)/*-{
        return [x,y];
    }-*/;
}
