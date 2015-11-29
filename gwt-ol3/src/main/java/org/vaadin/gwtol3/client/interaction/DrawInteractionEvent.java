/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.interaction;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.feature.Feature;

/**
 *
 * @author iserge
 */
public class DrawInteractionEvent extends JavaScriptObject {
    public static enum Type{DRAW_END, DRAW_START, UNKNOWN};
    
    protected DrawInteractionEvent() {
        //
    }
    
    public final Type getType() {
        String type = getTypeNative();
        if (type.equals("drawend")) {
            return Type.DRAW_END;
        }
        else if (type.equals("drawstart")) {
            return Type.DRAW_START;
        } else {
            return Type.UNKNOWN;
        }
    }
    
    public native final Feature getFeature() /*-{
        return this.feature;
    }-*/;
    
    private native final String getTypeNative()/*-{
        return this.type;
    }-*/;
}
