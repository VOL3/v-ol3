/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.geom;

import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.Extent;

/**
 *
 * @author iserge
 */
public class Point extends SimpleGeometry {
    protected Point() {
        //
    }
    
    public static final native Point create(Coordinate coordinate) /*-{
        return new $wnd.ol.geom.Point(coordinate);
    }-*/;
    
    public final native Coordinate getCoordinates() /*-{
        return this.getCoordinates();
    }-*/;
    
    public final native void setCoordinates(Coordinate coordinate) /*-{
        this.setCoordinates(coordinate);
    }-*/;
    
    public final native Boolean intersectsExtent(Extent extent) /*-{
        return this.intersectsExtent(extent);
    }-*/;
}
