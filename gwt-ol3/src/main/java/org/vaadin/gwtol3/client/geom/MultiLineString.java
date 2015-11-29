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
public class MultiLineString extends SimpleGeometry {
    protected MultiLineString() {
        //
    }
    
    public static final native MultiLineString create(JsArray<JsArray<Coordinate>> coordinates) /*-{
        return new $wnd.ol.geom.MultiLineString(coordinates);
    }-*/;
    
    public final native void appendLineString(LineString lineString) /*-{
        this.appendLineString(lineString);
    }-*/;
    
    public final native void setCoordinates(JsArray<JsArray<Coordinate>> coordinates) /*-{
        this.setCoordinates(coordinates);
    }-*/;
    
    public final native JsArray<JsArray<Coordinate>> getCoordinates() /*-{
        return this.getCoordinates();
    }-*/;
    
    public final native LineString getLineString(int index) /*-{
        return this.getLineString(index);
    }-*/;
    
    public final native JsArray<LineString> getLineStrings() /*-{
        return this.getLineStrings();
    }-*/;
    
    public final native boolean intersectsExtent(Extent extent) /*-{
        return this.intersectsExtent(extent);
    }-*/;
}
