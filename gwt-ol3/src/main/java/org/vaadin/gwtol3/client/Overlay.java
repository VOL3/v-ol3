package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Wrapper for an overlay displayed on a map
 */
public class Overlay extends JavaScriptObject {

    protected Overlay(){
        //
    }

    public static native Overlay create()
    /*-{
        return new $wnd.ol.Overlay();
    }-*/;
    
    public static native Overlay create(OverlayOptions options) /*-{    
        return new $wnd.ol.Overlay();
    }-*/;
    
    public final native void setPosition(Coordinate position) /*-{
        this.setPosition(position);
    }-*/;
    
    public final native Coordinate getPosition() /*-{
        return this.getPosition();
    }-*/;
    
    public final native void setElement(Element element) /*-{
        this.setElement(element);
    }-*/;
    
    public final native Element getElement() /*-{
        return this.getElement();
    }-*/;
}
