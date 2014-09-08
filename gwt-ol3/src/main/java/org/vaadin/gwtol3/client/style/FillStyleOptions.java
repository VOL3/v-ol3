package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Options for a FillStyle
 */
public class FillStyleOptions extends JavaScriptObject{
    protected FillStyleOptions() {
    }

    /**
     * Initializes FillStyle
     */
    public static final native FillStyleOptions create(String fillColor)
    /*-{
        return {color: fillColor};
    }-*/;
}
