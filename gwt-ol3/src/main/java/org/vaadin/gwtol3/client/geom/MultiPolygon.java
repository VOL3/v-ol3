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
public class MultiPolygon extends SimpleGeometry {
    protected MultiPolygon() {
        //
    }
    
    public static final native MultiPolygon create(JsArray<JsArray<JsArray<Coordinate>>> coordinates) /*-{
        return new $wnd.ol.geom.MultiPolygon(coordinates);
    }-*/;
    
    public final native void appendPolygon(Polygon polygon) /*-{
        this.appendPolygon(polygon);
    }-*/;
    
    public final native JsArray<JsArray<JsArray<Coordinate>>> getCoordinates(Boolean right) /*-{
        return this.getCoordinates(right);
    }-*/;
    
    public final native MultiPoint getInteriorPoints() /*-{
        return this.getInteriorPoints();
    }-*/;
    
    public final native Polygon getPolygon(Integer index) /*-{
        return this.getPolygon(index);
    }-*/;
    
    public final native JsArray<Polygon> getPolygons() /*-{
        return this.getPolygons();
    }-*/;
    
    public final native Boolean intersectsExtent(Extent extent) /*-{
        return this.intersectsExtent(extent);
    }-*/;
    
    public final native void setCoordinates(JsArray<JsArray<JsArray<Coordinate>>> coordinates) /*-{
        this.setCoordinates(coordinates);
    }-*/;
}
