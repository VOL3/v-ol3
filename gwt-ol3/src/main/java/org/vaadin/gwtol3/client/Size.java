package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Size
 */
public class Size extends JavaScriptObject {

    protected Size(){
    }

    public static native Size create(double width, double height)/*-{
        return [width, height];
    }-*/;
}
