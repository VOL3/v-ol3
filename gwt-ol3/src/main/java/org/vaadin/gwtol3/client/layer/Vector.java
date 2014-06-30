package org.vaadin.gwtol3.client.layer;

import org.vaadin.gwtol3.client.source.Source;
import org.vaadin.gwtol3.client.style.Style;

/**
 * Basic implementation for the ol3 vector layer
 * Created by mjhosio on 30/06/14.
 */
public class Vector extends Layer {

    protected Vector() {}

    public static native Vector create(Source src)
    /*-{
        return new $wnd.ol.layer.Vector({source: src});
    }-*/;

    /**
     * Taking a shortcut here for simplicity. The javascript api would allow also single style instance and generator function
     * @param styles
     */
    public native final void setStyles(Style [] styles)/*-{
        this.setStyle(styles);
    }-*/;

    public native final Style [] getStyles()/*-{
        return this.getStyle();
    }-*/;
}
