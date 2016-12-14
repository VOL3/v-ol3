package org.vaadin.gwtol3.client.tilegrid;

import com.google.gwt.core.client.JsArrayString;

/**
 * Created by mjhosio on 23/02/15.
 */
public class XYZTileGridOptions extends TileGridOptions {
    protected XYZTileGridOptions() {
    }

    public static final native XYZTileGridOptions create()/*-{
        return {};
    }-*/;

    public final native void setMatrixIds(JsArrayString matrixIds)/*-{
        this.matrixIds = matrixIds;
    }-*/;
}
