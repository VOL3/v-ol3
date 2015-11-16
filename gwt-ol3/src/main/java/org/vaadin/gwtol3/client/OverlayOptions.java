/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.dom.client.Element;

/**
 *
 * @author iserge
 */
public class OverlayOptions extends JavaScriptObject {
    protected OverlayOptions() {
        //
    }
    
    public static final native OverlayOptions create() /*-{
        return {};
    }-*/;
    
    /**
     * Not work
     * @param element 
     */
    public final native void setElement(String element) /*-{
        this.element = document.getElementById(element);
    }-*/;
    
    public final native void setElement(Element element) /*-{
        this.element = element;
    }-*/;
    
    public final native void setOffset(JsArrayInteger offset) /*-{
        this.offset = offset;
    }-*/;
    
    public final native void setPosition(Coordinate position) /*-{
        this.position = position;
    }-*/;
    
    public final native void setAutoPan(Boolean autoPan) /*-{
        this.autoPan = autoPan;
    }-*/;
    
    public final native void setAutoPanMargin(Integer autoPanMargin) /*-{
        this.autoPanMargin = autoPanMargin;
    }-*/;
}
