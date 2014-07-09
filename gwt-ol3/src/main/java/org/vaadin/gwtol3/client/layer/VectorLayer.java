package org.vaadin.gwtol3.client.layer;

import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.source.VectorSource;
import org.vaadin.gwtol3.client.style.Style;

/**
 * Basic implementation for the ol3 vector layer
 * Created by mjhosio on 30/06/14.
 */
public class VectorLayer extends Layer {

    protected VectorLayer() {}

    public static native VectorLayer create(VectorSource src)
    /*-{
        return new $wnd.ol.layer.Vector({source: src});
    }-*/;

    /**
     * Set the style for features. Taking a shortcut here for simplicity. The javascript api would allow also single style instance and generator function
     * @param styles
     */
    public native final void setStyles(JsArray<Style> styles)/*-{
        this.setStyle(styles);
    }-*/;

    public native final JsArray<Style> getStyles()/*-{
        return this.getStyle();
    }-*/;
}
