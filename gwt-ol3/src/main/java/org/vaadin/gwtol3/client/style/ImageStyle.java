package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Image style for a feature
 */
public abstract class ImageStyle extends JavaScriptObject {
    protected ImageStyle() {
    }

    public final native double getRotation() /*-{
        return this.getRotation();
    }-*/;

    public final native double getScale() /*-{
        return this.getScale();
    }-*/;
}
