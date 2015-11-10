/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.interaction;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Collection;
import org.vaadin.gwtol3.client.feature.Feature;

/**
 *
 * @author iserge
 */
public class TranslateInteractionOptions extends JavaScriptObject {
    protected TranslateInteractionOptions() {
        //
    }
    
    public static final native TranslateInteractionOptions create() /*-{
        return {};
    }-*/;
    
    public final native void setFeatures(Collection<Feature> features) /*-{
        this.features = features;
    }-*/;
}
