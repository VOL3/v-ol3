/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.map;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Size;

/**
 *
 * @author iserge
 */
public class MapChangeEvent extends JavaScriptObject {
    public static enum Type{LAYER_GROUP, SIZE, TARGET, VIEW, UNKNOWN};
    
    protected MapChangeEvent() {
        //
    }
    
    public final Type getType() {
        String type = getTypeNative();
        if (type.equals("layergroup")) {
            return Type.LAYER_GROUP;
        }
        else if (type.equals("size")) {
            return Type.SIZE;
        }
        else if (type.equals("target")) {
            return Type.TARGET;
        }
        else if (type.equals("view")) {
            return Type.VIEW;
        }
        
        return Type.UNKNOWN;
    }
    
    public native final Size getSize() /*-{
        return this.size;
    }-*/;
    
    private native final String getTypeNative()/*-{
        return this.type;
    }-*/;
}
