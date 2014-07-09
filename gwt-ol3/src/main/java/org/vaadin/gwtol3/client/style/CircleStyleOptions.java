package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 09/07/14.
 */
public class CircleStyleOptions extends JavaScriptObject{
    protected CircleStyleOptions() {
    }

    /**
     * Initializes FillStyle
     */
    public static final native CircleStyleOptions create()
    /*-{
        return {};
    }-*/;

    public final native void setFill(FillStyle fill) /*-{
        this.fill=fill;
    }-*/;

    public final native void setRadius(double radius) /*-{
        this.radius=radius;
    }-*/;

    /** If true integral numbers of pixels are used as the X and Y pixel coordinate when drawing the circle in the output canvas. If false fractional numbers may be used. Using true allows for "sharp" rendering (no blur), while using false allows for "accurate" rendering. Note that accuracy is important if the circle's position is animated. Without it, the circle may jitter noticeably. Default value is true.
     *
     * @param snapToPixel
     */
    public final native void setSnapToPixel(boolean snapToPixel) /*-{
        this.snapToPixel=snapToPixel;
    }-*/;

    public final native void setStroke(StrokeStyle stroke) /*-{
        this.stroke=stroke;
    }-*/;

}
