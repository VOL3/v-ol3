package org.vaadin.gwtol3.client.layer;

import org.vaadin.gwtol3.client.source.Source;
import org.vaadin.gwtol3.client.source.VectorSource;

import com.google.gwt.core.client.JsArrayString;

/**
 * Image layer
 */
public class HeatmapLayer extends Layer {
    protected HeatmapLayer() {
    }

    public static native HeatmapLayer create(Source src)
    /*-{
        return new $wnd.ol.layer.Heatmap({source: src});
    }-*/;

    public static native HeatmapLayer create(HeatmapOptions options)
    /*-{
        return new $wnd.ol.layer.Heatmap(options);
    }-*/;

    public native final VectorSource getVectorSource() /*-{
        return this.getSource();
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

    public final native void setWeight(String weight)/*-{
        this.weight=weight;
    }-*/;

    public final native JsArrayString getGradient()/*-{
        return this.gradient;
    }-*/;

    public final native double getRadius()/*-{
        return this.radius;
    }-*/;

    public final native double getBlur()/*-{
        return this.blur;
    }-*/;

    public final native double getShadow()/*-{
        return this.shadow;
    }-*/;

    public final native String getWeight()/*-{
        return this.weight;
    }-*/;
}
