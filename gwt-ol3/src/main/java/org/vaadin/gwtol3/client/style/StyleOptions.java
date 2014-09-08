package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Options for feature Styles
 */
public class StyleOptions extends JavaScriptObject {
    protected StyleOptions() {
    }

    /**
     * Initializes StyleOptions.
     */
    public static final native StyleOptions create()
    /*-{
        return {};
    }-*/;

    public final native void setFill(FillStyle fill) /*-{
        this.fill=fill;
    }-*/;

    public final native void setImage(ImageStyle image) /*-{
        this.image=image;
    }-*/;

    public final native void setStroke(StrokeStyle stroke) /*-{
        this.stroke=stroke;
    }-*/;

    public final native void setText(TextStyle text) /*-{
        this.text=text;
    }-*/;

    public final native void setZIndex(int zIndex) /*-{
        this.zIndex=zIndex;
    }-*/;
}
