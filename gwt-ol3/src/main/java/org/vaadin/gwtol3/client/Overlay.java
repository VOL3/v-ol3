package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.dom.client.Element;

/**
 * Wrapper for an overlay displayed on a map
 */
public class Overlay extends JavaScriptObject {

    public static final String POSITION_BOTTOM_LEFT="bottom-left";
    public static final String POSITION_BOTTOM_CENTER="bottom-center";
    public static final String POSITION_BOTTOM_RIGHT="bottom-right";
    public static final String POSITION_CENTER_LEFT="center-left";
    public static final String POSITION_CENTER_CENTER="center-center";
    public static final String POSITION_CENTER_RIGHT="center-right";
    public static final String POSITION_TOP_LEFT="top-left";
    public static final String POSITION_TOP_CENTER="top-center";
    public static final String POSITION_TOP_RIGHT="top-right";

    protected Overlay(){
        //
    }

    public static native Overlay create()
    /*-{
        return new $wnd.ol.Overlay();
    }-*/;

    public static native Overlay create(OverlayOptions options)
    /*-{
        return new $wnd.ol.Overlay(options);
    }-*/;


    public native final void setElement(Element element)
    /*-{
        this.setEelement(element);
    }-*/;

    public native final Element getElement()
    /*-{
        return this.getElement();
    }-*/;

    public native final void setMap(Map map)
    /*-{
        this.setMap(map);
    }-*/;

    public native final Map getMap()
    /*-{
        return this.getMap();
    }-*/;

    public native final void setOffset(JsArrayInteger offset)
    /*-{
        this.setOffset(offset);
    }-*/;

    public native final JsArrayInteger getOffset()
    /*-{
        return this.getOffset();
    }-*/;

    /**
     * Do not use this if you want automatic coordinate system conversion. Instead provide the position when adding the overlay to the map
     * @param position the position. Note: the position is not converted to the maps input projection
     */
    @Deprecated
    public native final void setPosition(Coordinate position)
    /*-{
        this.setPosition(position);
    }-*/;

    public native final Coordinate getPosition()
    /*-{
        return this.getPosition();
    }-*/;

    public native final void setPositioning(String positioning)
    /*-{
        this.setPositioning(positioning);
    }-*/;

    public native final String getPositioning()
    /*-{
        return this.getPositioning();
    }-*/;
}
