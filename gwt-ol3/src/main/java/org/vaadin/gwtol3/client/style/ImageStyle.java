package org.vaadin.gwtol3.client.style;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 09/07/14.
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
