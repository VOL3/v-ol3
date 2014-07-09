package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 09/07/14.
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
