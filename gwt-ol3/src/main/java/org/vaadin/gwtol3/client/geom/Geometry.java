package org.vaadin.gwtol3.client.geom;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Extent;

/**
 * Wrapper for the geometry of a feature
 */
public class Geometry extends JavaScriptObject {
    protected Geometry() {
    }

    public final native void transform(String sourceProjection, String destinationProjection)/*-{
        this.transform(sourceProjection, destinationProjection);
    }-*/;

    public final native Geometry clone()/*-{
        return this.clone();
    }-*/;

    public final native String getType()/*-{
        return this.getType();
    }-*/;

    public final native Extent getExtent() /*-{
        return this.getExtent();
    }-*/;
}
