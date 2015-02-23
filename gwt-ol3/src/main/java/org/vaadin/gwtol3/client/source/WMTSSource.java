package org.vaadin.gwtol3.client.source;

/**
 * Created by mjhosio on 23/02/15.
 */
public class WMTSSource extends TileImageSource {
	protected WMTSSource() {
	}


	public static final native WMTSSource create() /*-{
        return new $wnd.ol.source.WMTS();
    }-*/;

	public static final native WMTSSource create(WMTSSourceOptions options) /*-{
        return new $wnd.ol.source.WMTS(options);
    }-*/;
}
