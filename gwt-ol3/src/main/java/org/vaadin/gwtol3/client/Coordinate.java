package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Coordinate
 */
public class Coordinate extends JavaScriptObject{

    protected Coordinate(){

    }

    public static native Coordinate create(double x, double y)/*-{
        return [x,y];
    }-*/;
}
