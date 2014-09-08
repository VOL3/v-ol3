package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wrapper for a pixel
 */
public class Pixel extends JavaScriptObject {
    protected Pixel(){
    }

    public static native Pixel create(double x, double y)/*-{
        return [x,y];
    }-*/;
}
