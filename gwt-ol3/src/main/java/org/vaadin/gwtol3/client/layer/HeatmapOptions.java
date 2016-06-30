package org.vaadin.gwtol3.client.layer;

import com.google.gwt.core.client.JsArrayString;

/**
 * Options for the heatmap layer
 */
public class HeatmapOptions extends LayerOptions {
    protected HeatmapOptions() {
    }

    /**
     * Initializes heatmap options.
     */
    public static native HeatmapOptions create()
    /*-{
        return {};
    }-*/;

    public final native void setGradient(JsArrayString gradient)/*-{
        this.gradient=gradient;
    }-*/;

    public final native void setRadius(double radius)/*-{
        this.radius=radius;
    }-*/;

    public final native void setBlur(double blur)/*-{
        this.blur=blur;
    }-*/;
    
    public final native void setShadow(double shadow)/*-{
        this.shadow=shadow;
    }-*/;
    
    public final native void setWeight(double weight)/*-{
        this.weight=weight;
    }-*/;
}
