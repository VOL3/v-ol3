/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vaadin.gwtol3.client.animation;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Coordinate;

/**
 * I cant understand how it works in OL3 may be this not work (see example popup.html)
 * @author iserge
 */
public class PanOptions extends JavaScriptObject {
    protected PanOptions() {
        //
    }
    
    public static final native PanOptions create() /*-{
        return {};
    }-*/;
    
    public final native void setCoordinateSource(Coordinate coordinateSource) /*-{
        this.source = coordinateSource;
    }-*/;
    
    public final native void setStart(int start) /*-{
        this.start = start;
    }-*/;
    
    public final native void setDuration(int duration) /*-{
        this.duration = duration;
    }-*/;
}
