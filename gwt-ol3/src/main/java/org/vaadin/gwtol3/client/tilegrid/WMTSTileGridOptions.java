package org.vaadin.gwtol3.client.tilegrid;

import com.google.gwt.core.client.JsArrayString;

/**
 * Options passed to WMTSTileGrid instance on creation
 */
public class WMTSTileGridOptions extends TileGridOptions{
    protected WMTSTileGridOptions() {
    }

    public static final native WMTSTileGridOptions create()/*-{
        return {};
    }-*/;

    public final native void setMatrixIds(JsArrayString matrixIds)/*-{
        this.matrixIds=matrixIds;
    }-*/;


}
