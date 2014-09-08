package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.dom.client.ImageElement;
import org.vaadin.gwtol3.client.Size;

/**
 * Options for IconStyle
 */
public class IconStyleOptions extends JavaScriptObject {
    protected IconStyleOptions() {
    }

    public static final native IconStyleOptions create()
    /*-{
        return {};
    }-*/;

    public final native void setAnchor(JsArrayNumber anchor) /*-{
        this.anchor=anchor;
    }-*/;

    /** Sets the anchor origin bottom-left, bottom-right, top-left or top-right. Default is top-left
     *
     * @param anchorOrigin
     */
    public final native void setAnchorOrigin(String anchorOrigin) /*-{
        this.anchorOrigin=anchorOrigin;
    }-*/;

    /** Units in which the anchor x value is specified. A value of 'fraction' indicates the x value is a fraction of the icon. A value of 'pixels' indicates the x value in pixels. Default is 'fraction'.
     *
     * @param anchorXUnits
     */
    public final native void setAnchorXUnits(String anchorXUnits) /*-{
        this.anchorXUnits=anchorXUnits;
    }-*/;

    /** Units in which the anchor y value is specified. A value of 'fraction' indicates the y value is a fraction of the icon. A value of 'pixels' indicates the y value in pixels. Default is 'fraction'.
     *
     * @param anchorYUnits
     */
    public final native void setAnchorYUnits(String anchorYUnits) /*-{
        this.anchorYUnits=anchorYUnits;
    }-*/;

    public final native void setCrossOrigin(String crossOrigin) /*-{
        this.crossOrigin=crossOrigin;
    }-*/;

    /** Image object for the icon. If the src option is not provided then the provided image must already be loaded.
     *
     * @param img
     */
    public final native void setImg(ImageElement img) /*-{
        this.img=img;
    }-*/;

    /** Offset, which, together with the size and the offset origin, define the sub-rectangle to use from the original icon image. Default value is [0, 0].
     *
     * @param offset
     */
    public final native void setOffset(JsArrayNumber offset) /*-{
        this.offset=offset;
    }-*/;

    /** Origin of the offset: bottom-left, bottom-right, top-left or top-right. Default is top-left.
     *
     * @param offsetOrigin
     */
    public final native void setOffsetOrigin(String offsetOrigin) /*-{
        this.offsetOrigin=offsetOrigin;
    }-*/;

    public final native void setScale(double scale) /*-{
        this.scale=scale;
    }-*/;

    /** If true integral numbers of pixels are used as the X and Y pixel coordinate when drawing the icon in the output canvas. If false fractional numbers may be used. Using true allows for "sharp" rendering (no blur), while using false allows for "accurate" rendering. Note that accuracy is important if the icon's position is animated. Without it, the icon may jitter noticeably. Default value is true.
     *
     * @param snapToPixel
     */
    public final native void setSnapToPixel(boolean snapToPixel) /*-{
        this.snapToPixel=snapToPixel;
    }-*/;

    public final native void setRotateWithView(boolean rotateWithView) /*-{
        this.rotateWithView=rotateWithView;
    }-*/;

    public final native void setRotation(double rotation) /*-{
        this.rotation=rotation;
    }-*/;

    /** Sets icon size in pixels
     *
     * @param size
     */
    public final native void setSize(Size size) /*-{
        this.size=size;
    }-*/;

    /** Image source url
     *
     * @param src
     */
    public final native void setSrc(String src) /*-{
        this.src=src;
    }-*/;


}
