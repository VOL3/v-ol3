package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 09/07/14.
 */
public class TextStyleOptions extends JavaScriptObject {
    protected TextStyleOptions() {
    }

    /**
     * Initializes TextStyleOptions.
     */
    public static final native TextStyleOptions create()
    /*-{
        return {};
    }-*/;

    public final native void setFont(String font) /*-{
        this.font=font;
    }-*/;

    public final native void setOffsetX(double offsetX) /*-{
        this.offsetX=offsetX;
    }-*/;

    public final native void setOffsetY(double offsetY) /*-{
        this.offsetY=offsetY;
    }-*/;

    public final native void setScale(double scale) /*-{
        this.scale=scale;
    }-*/;

    public final native void setRotation(double rotation) /*-{
        this.rotation=rotation;
    }-*/;

    public final native void setText(String text) /*-{
        this.text=text;
    }-*/;

    public final native void setTextAlign(String textAlign) /*-{
        this.textAlign=textAlign;
    }-*/;

    public final native void setTextBaseline(String textBaseline) /*-{
        this.textBaseline=textBaseline;
    }-*/;

    public final native void setFill(FillStyle fill) /*-{
        this.fill=fill;
    }-*/;

    public final native void setStroke(StrokeStyle stroke) /*-{
        this.stroke=stroke;
    }-*/;
}
