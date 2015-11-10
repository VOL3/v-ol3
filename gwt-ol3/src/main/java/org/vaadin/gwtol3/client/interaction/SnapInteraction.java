/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.interaction;

import org.vaadin.gwtol3.client.feature.Feature;

/**
 *
 * @author iserge
 */
public class SnapInteraction extends PointerInteraction {
    protected SnapInteraction() {
        //
    }
    
    public static final native SnapInteraction create(SnapInteractionOptions options) /*-{
        return new $wnd.ol.interaction.Snap(options);
    }-*/;
    
    public final native void addFeature(Feature feature, Boolean listen) /*-{
        if (listen == undefined) {
            listen = true;
        }
        this.addFeature(feature);
    }-*/;
    
    public final native void removeFeature(Feature feature, Boolean listen) /*-{
        if (listen == undefined) {
            listen = true;
        }
        this.removeFeature(feature);
    }-*/;
}
