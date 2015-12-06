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
public class DragRotateAndZoomInteraction extends PointerInteraction {
    protected DragRotateAndZoomInteraction() {
        //
    }
    
    public final static native DragRotateAndZoomInteraction create() /*-{
        return new $wnd.ol.interaction.DragRotateAndZoom();
    }-*/;
}
