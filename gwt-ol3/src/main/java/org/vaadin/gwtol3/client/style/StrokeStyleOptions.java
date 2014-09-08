package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * Options for StrokeStyle
 */
public class StrokeStyleOptions extends JavaScriptObject {
    protected StrokeStyleOptions() {
    }

    public static final native StrokeStyleOptions create() /*-{
        return {};
    }-*/;

    public final native void setColor(String color) /*-{
        this.color=color;
    }-*/;

    public final native void setLineCap(String lineCap) /*-{
        this.lineCap=lineCap;
    }-*/;

    public final native void setLineJoin(String lineJoin) /*-{
        this.lineJoin=lineJoin;
    }-*/;

    public final native void setLineDash(JsArrayNumber lineDash) /*-{
        this.lineDash=lineDash;
    }-*/;

    public final native void setMiterLimit(double miterLimit) /*-{
        this.miterLimit=miterLimit;
    }-*/;

    public final native void setWidth(double width) /*-{
        this.width=width;
    }-*/;
}
