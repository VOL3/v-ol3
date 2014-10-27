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

	public native final double getX()/*-{
		return this[0];
	}-*/;

	public native final double getY()/*-{
        return this[1];
    }-*/;

}
