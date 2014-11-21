package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Text style for a feature
 */
public class TextStyle extends JavaScriptObject{
    protected TextStyle() {
    }

    /** creates a new TextStyle instance
     *
     * @param options
     * @return
     */
    public static final native TextStyle create(TextStyleOptions options) /*-{
        return new $wnd.ol.style.Text(options);
    }-*/;

    public final native FillStyle getFill() /*-{
        return this.getFill();
    }-*/;

    public final native String getFont() /*-{
        return this.getFont();
    }-*/;

    public final native Double getRotation() /*-{
		var res = this.getRotation();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public final native Double getScale() /*-{
		var res = this.getScale();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public final native StrokeStyle getStroke() /*-{
        return this.getStroke();
    }-*/;

    public final native String getText() /*-{
        return this.getText();
    }-*/;

    public final native String getTextAlign() /*-{
        return this.getTextAlign();
    }-*/;

    public final native String getTextBaseline() /*-{
        return this.getTextBaseline();
    }-*/;
}
