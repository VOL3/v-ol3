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
    
	public native final Double getWidth()/*-{
		return this[0] == null ? null : @java.lang.Double::valueOf(D)(this[0]);
	}-*/;

	public native final Double getHeight()/*-{
	    return this[1] == null ? null : @java.lang.Double::valueOf(D)(this[1]);
	}-*/;
    
}
