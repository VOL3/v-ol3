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

    public final native double getMinX()/*-{
        return this[0];
    }-*/;

    public final native double getMinY()/*-{
        return this[1];
    }-*/;

    public final native double getMaxX()/*-{
        return this[2];
    }-*/;

    public final native double getMaxY()/*-{
        return this[3];
    }-*/;

    public final native Coordinate getCenter() /*-{
        return $wnd.ol.extent.getCenter(this);
    }-*/;
    
    public static final native Coordinate getCenter(Extent extent) /*-{
        return $wnd.ol.extent.getCenter(extent);
    }-*/;
}
