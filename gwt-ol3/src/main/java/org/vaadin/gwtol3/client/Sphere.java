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
public class Sphere extends JavaScriptObject {
    protected Sphere() {
        //
    }
    
    public native final Sphere create(Double radius) /*-{
        return $wnd.ol.Sphere(radius);
    }-*/;
}
