/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.layer;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *
 * @author iserge
 */
public class LayerChangeEvent extends JavaScriptObject {
    public static enum Type {OPACITY, VISIBLE, UNKNOWN};
    
    protected LayerChangeEvent() {
        //
    }
    
    public native final Layer getLayer() /*-{
        return this.layer;
    }-*/;
    
    public final Type getType() {
        String type = getTypeNative();
        if (type.equals("opacity")) {
            return Type.OPACITY;
        }
        else if (type.equals("visible")) {
            return Type.VISIBLE;
        } else {
            return Type.UNKNOWN;
        }
    }
    
    private native final String getTypeNative() /*-{
        return this.type;
    }-*/;
}
