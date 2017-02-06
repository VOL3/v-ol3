package org.vaadin.gwtol3.client.proj;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Extent;

/**
 * Projection object to be passed to underlying ol3.js api
 */
public class Projection extends JavaScriptObject {

    protected Projection() {
    }

    public static final native Projection createCustom(String code, String units, Extent extent)/*-{
        var projection = new $wnd.ol.proj.Projection({
                code: code,
                units: units,
                extent: extent
        });
        $wnd.ol.proj.addProjection(projection);
        return projection;
    }-*/;

    public static final native Projection get(String crsString)/*-{
        return $wnd.ol.proj.get(crsString);
    }-*/;

    public native final String getCode()/*-{
        return this.getCode();
    }-*/;
}
