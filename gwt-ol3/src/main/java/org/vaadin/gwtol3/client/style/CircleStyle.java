package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.dom.client.ImageElement;
import org.vaadin.gwtol3.client.Size;

/**
 * Created by mjhosio on 09/07/14.
 */
public class CircleStyle extends ImageStyle{
    protected CircleStyle() {
    }

    /**
     * Initializes CircleStyle
     */
    public static final native CircleStyle create(CircleStyleOptions options)
    /*-{
        return new ol.style.Circle(options);
    }-*/;

    public final native JsArrayNumber getAnchor() /*-{
        return this.getAnchor;
    }-*/;

    public final native FillStyle getFill() /*-{
        return this.getFill();
    }-*/;


    public final native ImageElement getImage(double pixelRatio) /*-{
        return this.getImage(pixelRatio);
    }-*/;

    public final native JsArrayNumber getOrigin() /*-{
        return this.getOrigin();
    }-*/;

    public final native double getRadius() /*-{
        return this.getRadius();
    }-*/;


    public final native double getRotation() /*-{
        return this.getRotation();
    }-*/;

    public final native double getScale() /*-{
        return this.getScale();
    }-*/;

    public final native Size getSize() /*-{
        return this.getSize();
    }-*/;

    public final native StrokeStyle getStroke() /*-{
        return this.getStroke();
    }-*/;
}
