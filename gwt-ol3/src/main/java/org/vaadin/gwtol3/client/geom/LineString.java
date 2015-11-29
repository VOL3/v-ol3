/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.geom;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.Extent;

/**
 *
 * @author iserge
 */
public class LineString extends SimpleGeometry {
    protected LineString() {
        //
    }
    
    public static final native LineString create(JsArray<Coordinate> coordinates) /*-{
        return $wnd.ol.geom.LineString(coordinates);
    }-*/;
    
    public final native void setCoordinates(JsArray<Coordinate> coordinates) /*-{
        this.setCoordinates(coordinates);
    }-*/;
    
    public final native JsArray<Coordinate> getCoordinates() /*-{
        return this.getCoordinates();
    }-*/;
    
    public final native void appendCoordinate(Coordinate coordinate) /*-{
        return this.appendCoordinate(coordinate);
    }-*/;
    
    public final native Double getLength() /*-{
        return this.getLength();
    }-*/;
    
    public final native boolean intersectsExtent(Extent extent) /*-{
        return this.intersectsExtent(extent);
    }-*/;
}
