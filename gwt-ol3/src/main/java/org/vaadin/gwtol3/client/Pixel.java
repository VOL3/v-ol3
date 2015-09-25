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

    public native final Double getX()/*-{
        return this[0] == null ? null : @java.lang.Double::valueOf(D)(this[0]);
    }-*/;

    public native final Double getY()/*-{
        return this[1] == null ? null : @java.lang.Double::valueOf(D)(this[1]);
    }-*/;
}
