package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Fill style for a feature
 */
public class FillStyle extends JavaScriptObject {
    protected FillStyle() {
    }

    /**
     * Initializes FillStyle
     */
    public static final native FillStyle create(FillStyleOptions options)
    /*-{
        return new $wnd.ol.style.Fill(options);
    }-*/;

    /**
     * Initializes FillStyle with specified color
     */
    public static final native FillStyle create(String color)
    /*-{
        return new $wnd.ol.style.Fill({color: color});
    }-*/;

    public final native String getColor() /*-{
        return this.getColor();
    }-*/;
}
