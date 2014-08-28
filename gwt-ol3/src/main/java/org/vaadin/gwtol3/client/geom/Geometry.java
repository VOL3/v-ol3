package org.vaadin.gwtol3.client.geom;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 25/06/14.
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

}
