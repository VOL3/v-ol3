/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.interaction;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.feature.Feature;

/**
 *
 * @author iserge
 */
public class SelectInteractionEvent extends JavaScriptObject {
    protected SelectInteractionEvent() {
        //
    }
    
    public final native JsArray<Feature> getDeSelected() /*-{
        return this.deselected;
    }-*/;
    
    public final native JsArray<Feature> getSelected() /*-{
        return this.selected;
    }-*/;
}
