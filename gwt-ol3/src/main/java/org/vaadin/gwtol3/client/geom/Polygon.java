/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.geom;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.Extent;
import org.vaadin.gwtol3.client.Sphere;

/**
 *
 * @author iserge
 */
public class Polygon extends SimpleGeometry {
    protected Polygon() {
        //
    }
    
    public static final native Polygon create(JsArray<JsArray<Coordinate>> coordinates) /*-{
        return new $wnd.ol.geom.Polygon(coordinates);
    }-*/;
    
    public static final native Polygon circular(Sphere sphere, Coordinate center, Double radius) /*-{
        return new $wnd.ol.geo,Polygon.circular(sphere, center, radius);
    }-*/;
    
    public static final native Polygon fromCircle(Circle circle, Integer sides, Double angle) /*-{
        if (sides == undefined) {
            sides = 32;
        }
        if (angle == undefined) {
            angle = 0;
        }
        return new $wnd.ol.geom.Polygon.fromCircle(circle, sides, angle);
    }-*/;
    
    public static final native Polygon fromExtent(Extent extent) /*-{
        return new $wnd.ol.geom.Polygon.fromExtent(extent);
    }-*/;
    
    public final native void appendLinearRing(LinearRing linearRing) /*-{
        this.appendLinearRing(linearRing);
    }-*/;
    
    public final native void setCoordinates(JsArray<JsArray<Coordinate>> coordinates) /*-{
        this.setCoordinates(coordinates);
    }-*/;
    
    public final native JsArray<JsArray<Coordinate>> getCoordinates() /*-{
        return this.getCoordinates();
    }-*/;
    
    public final native Point getInteriorPoint() /*-{
        return this.getInteriorPoint();
    }-*/;
    
    public final native LinearRing getLinearRing(Integer index) /*-{
        return this.getLinearRing(index);
    }-*/;
    
    public final native Integer getLinearRingCount() /*-{
        return this.getLinearRingCount();
    }-*/;
    
    public final native JsArray<LinearRing> getLinearRings() /*-{
        return this.getLinearRings();
    }-*/;
    
    public final native Boolean intersectsExtent(Extent extent) /*-{
        return this.intersectsExtent(extent);
    }-*/;
    
    public final native Double getArea() /*-{
        return this.getArea();
    }-*/;
}
