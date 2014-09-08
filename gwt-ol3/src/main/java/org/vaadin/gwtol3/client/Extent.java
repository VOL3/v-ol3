package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Map extent
 */
public class Extent extends JavaScriptObject{

    public static native Extent create(double minX, double minY, double maxX, double maxY)/*-{
        return [minX, minY, maxX, maxY];
    }-*/;

    protected Extent() {
    }
}
