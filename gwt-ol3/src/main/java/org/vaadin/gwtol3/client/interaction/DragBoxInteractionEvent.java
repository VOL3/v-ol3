/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.interaction;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Coordinate;

/**
 *
 * @author iserge
 */
public class DragBoxInteractionEvent extends JavaScriptObject {
    public static enum Type {BOX_START, BOX_END, UNKNOWN};
    
    protected DragBoxInteractionEvent() {
        //
    }
    
    public final Type getType() {
        String type = getTypeNative();
        if (type.equals("boxend")) {
            return Type.BOX_END;
        }
        else if (type.equals("boxstart")) {
            return Type.BOX_START;
        } else {
            return Type.UNKNOWN;
        }
    }
    
    public native final Coordinate getCoordinate() /*-{
        return this.coordinate;
    }-*/;
    
    private native final String getTypeNative()/*-{
        return this.type;
    }-*/;
}
