/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.interaction;

/**
 *
 * @author iserge
 */
public class DragBoxInteractionOptions extends PointerInteraction {
    protected DragBoxInteractionOptions() {
        //
    }
    
    public final static native DragBoxInteractionOptions create() /*-{
        return {};
    }-*/;
    
    public final native void setClassName(String className) /*-{
        this.className = className;
    }-*/;
}
