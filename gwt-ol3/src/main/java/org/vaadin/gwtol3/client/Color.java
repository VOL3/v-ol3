/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *
 * @author iserge
 */
public class Color extends JavaScriptObject {
    protected Color() {
        //
    }
    
    public final static native Color create(Integer r, Integer g, Integer b, Float a) /*-{
        return [r, g, b, a];
    }-*/;
    
    public final native void setRed(Integer r) /*-{
        this[0] = r;
    }-*/;
    
    public final native Integer getRed() /*-{
        return this[0];
    }-*/;
    
    public final native void setGreen(Integer g) /*-{
        this[1] = g;
    }-*/;
    
    public final native Integer getGren() /*-{
        return this[1];
    }-*/;
    
    public final native void setBlue(Integer b) /*-{
        this[2] = b;
    }-*/;
    
    public final native Integer getBlue() /*-{
        return this[2];
    }-*/;
    
    public final native void setAlpha(Float a) /*-{
        this[3] = a;
    }-*/;
    
    public final native Float getAlpha() /*-{
        return this[3];
    }-*/;
    
    public final native String asArray() /*-{
        return ol.color.asArray(this);
    }-*/;
    
    public final native String asString() /*-{
        return ol.color.asString(this);
    }-*/;
}
