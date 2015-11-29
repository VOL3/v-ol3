package org.vaadin.gwtol3.client.interaction;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.vaadin.gwtol3.client.Collection;
import org.vaadin.gwtol3.client.feature.Feature;
import org.vaadin.gwtol3.client.layer.Layer;
import org.vaadin.gwtol3.client.style.Style;

/**
 * Options for the select interaction
 */
public class SelectInteractionOptions extends JavaScriptObject {
    protected SelectInteractionOptions() {
    }

    public static final native SelectInteractionOptions create()/*-{
        return {};
    }-*/;

    /** Sets the list of layers from which features should be selected. If not defined, all visible layers will be considered selectable.
     *
     * @param layers
     */
    public final native void setLayers(JsArray<Layer> layers)/*-{
        this.layers=layers;
    }-*/;

    /** Sets the style used for the selected features
     *
     * @param styles
     */
    public final native void setStyles(JsArray<Style> styles)/*-{
        this.styles=styles;
    }-*/;
    
    public final native void setFeatures(Collection<Feature> features) /*-{
        this.features = features;
    }-*/;

    public final native void setMulti(Boolean multi) /*-{
        this.multi = multi;
    }-*/;
    
    public final native void setActive(boolean active) /*-{
        this.active = active;
    }-*/;
}
