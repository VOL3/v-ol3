package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 24/06/14.
 */
public class View2D extends JavaScriptObject implements View{

    protected View2D(){

    }

    public static final native View2D create()/*-{
        return new $wnd.ol.View2D({});
    }-*/;

    public native final void setCenter(double [] coordinate)/*-{
        this.setCenter(coordinate);
    }-*/;

    public native final void setZoom(int zoom)/*-{
        this.setZoom(zoom);
    }-*/;


}
