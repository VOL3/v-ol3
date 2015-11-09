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
public class Circle extends SimpleGeometry {
    protected Circle() {
        //
    }
    
    public static final native Circle create(Coordinate center) /*-{
        return $wnd.ol.geom.Circle(center);
    }-*/;
    
    public static final native Circle create(Coordinate center, Double radius) /*-{
        return $wnd.ol.geom.Circle(center, radius);
    }-*/;
    
    public final native Coordinate getCenter() /*-{
        return this.getCenter();
    }-*/;
    
    public final native Double getRadius() /*-{
        return this.getRadius();
    }-*/;
    
    public final native boolean intersectsExtent(Extent extent) /*-{
        return this.intersectsExtent(extent);
    }-*/;
    
    public native final void setCenter(Coordinate center) /*-{
        this.setCenter(center);
    }-*/;
    
    public native final void setRadius(Double radius) /*-{
        this.setRadius(radius);
    }-*/;
    
    public native final void setCeneterAndRadius(Coordinate center, Double radius) /*-{
        this.setCenterAndRadius(center, radius);
    */;
}
