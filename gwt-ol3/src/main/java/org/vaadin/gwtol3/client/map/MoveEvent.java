/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.Pixel;

/**
 *
 * @author iserge
 */
public class MoveEvent extends JavaScriptObject {
    protected MoveEvent() {
        //
    }
    
    public native final Coordinate getCoordinate() /*-{
        return this.coordinate;
    }-*/;

	public native final Pixel getPixel() /*-{
        return this.pixel;
    }-*/;

    public native final NativeEvent getNativeEvent() /*-{
        return this.nativeEvent;
    }-*/;
}
