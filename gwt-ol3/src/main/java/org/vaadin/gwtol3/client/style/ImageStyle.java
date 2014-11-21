package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Image style for a feature
 */
public abstract class ImageStyle extends JavaScriptObject {
    protected ImageStyle() {
    }

    public final native Double getRotation() /*-{
		var res = this.getRotation();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public final native Double getScale() /*-{
        var res = this.getScale();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;
}
