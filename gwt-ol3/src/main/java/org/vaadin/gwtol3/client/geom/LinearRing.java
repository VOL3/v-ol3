/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.geom;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Coordinate;

/**
 *
 * @author iserge
 */
public class LinearRing extends SimpleGeometry {
    protected LinearRing() {
        //
    }
    
    public static final native LinearRing create(JsArray<Coordinate> coordinates) /*-{
        return new $wnd.ol.geom.LinearRing(coordinates);
    }-*/;
    
    public final native JsArray<Coordinate> getCoordinates() /*-{
        return this.getCoordinates();
    }-*/;
    
    public final native void setCoordinates(JsArray<Coordinate> coordinates) /*-{
        this.setCoordinates(coordinates);
    }-*/;
}
