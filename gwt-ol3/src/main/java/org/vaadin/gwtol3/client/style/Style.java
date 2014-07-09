package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 30/06/14.
 */
public class Style extends JavaScriptObject{
    protected Style() {
    }

    /** Creates an instance of style
     *
     * @return
     */
    public static final native Style create(StyleOptions options) /*-{
        return new $wnd.ol.style.Style(options);
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
