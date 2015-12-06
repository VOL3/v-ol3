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
public class MultiPoint extends SimpleGeometry {
    protected MultiPoint() {
        //
    }
    
    public static final native MultiPoint create(JsArray<Coordinate> coordinates) /*-{
        return new $wnd.ol.geom.MultiPoint(coordinates);
    }-*/;
    
    public final native void appendPoint(Point point) /*-{
        this.appendPoint(point);
    }-*/;
    
    public final native JsArray<Coordinate> getCoordinates() /*-{
        return this.getCoordinates();
    }-*/;
    
    public final native Point getPoint(Integer index) /*-{
        return this.getPoint(index);
    }-*/;
    
    public final native JsArray<Point> getPoints() /*-{
        return this.getPoints();
    }-*/;
    
    public final native Boolean intersectsExtent(Extent extent) /*-{
        return this.intersectsExtent(extent);
    }-*/;
    
    public final native void setCoordinates(JsArray<Coordinate> coordinates) /*-{
        this.setCoordinates(coordinates);
    }-*/;
}
