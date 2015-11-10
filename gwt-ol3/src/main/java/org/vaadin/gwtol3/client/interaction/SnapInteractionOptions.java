/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.interaction;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Collection;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.source.VectorSource;

/**
 *
 * @author iserge
 */
public class SnapInteractionOptions extends JavaScriptObject {
    protected SnapInteractionOptions() {
        //
    }
    
    public final native void setFeatures(Collection<Feature> features) /*-{
        this.features = features;
    }-*/;
    
    public final native void setPixelTolerance(Integer pixelTolerance) /*-{
        this.pixelTolerance = pixelTolerance;
    }-*/;
    
    public final native void setVectorSource(VectorSource source) /*-{
        this.source = source;
    }-*/;
}
