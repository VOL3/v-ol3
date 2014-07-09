package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 30/06/14.
 */
public class Style extends JavaScriptObject{
    protected Style() {
    }

    private static final Style defaultStyle=createDefaultStyle();

    /** Creates an instance of style
     *
     * @return
     */
    public static final native Style create(StyleOptions options) /*-{
        return new $wnd.ol.style.Style(options);
    }-*/;

    public static final Style getDefaultStyle(){
        return defaultStyle;
    }

    private static final native Style createDefaultStyle() /*-{
        var fill = new $wnd.ol.style.Fill({color:"rgba(255,255,255,0.4)"});
        var stroke = new $wnd.ol.style.Stroke({color:"#3399CC", width:1.25});
        var image = new $wnd.ol.style.Circle({fill:fill, stroke:stroke, radius:5});
        return new $wnd.ol.style.Style({image:image, fill:fill, stroke:stroke});
    }-*/;

    public final native FillStyle getFill() /*-{
        return this.getFill();
    }-*/;

    public final native ImageStyle getImage() /*-{
        return this.getImage();
    }-*/;

    public final native StrokeStyle getStroke() /*-{
        return this.getStroke();
    }-*/;

    public final native TextStyle getText() /*-{
        return this.getText();
    }-*/;

    public final native int getZIndex() /*-{
        return this.getZIndex();
    }-*/;


}
