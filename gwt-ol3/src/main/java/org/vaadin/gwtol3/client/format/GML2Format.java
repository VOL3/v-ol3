package org.vaadin.gwtol3.client.format;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by Vaadin Ltd / mjhosio on 02/06/16.
 */
public class GML2Format extends GMLBaseFormat {
	protected GML2Format() {
	}

	public static final native GML2Format create()/*-{
        return new $wnd.ol.format.GML2();
    }-*/;

	public static final native GML2Format create(JavaScriptObject opts)/*-{
        return new $wnd.ol.format.GML2(opts);
    }-*/;

	public static final native GML2Format create(GMLFormatOptions options)/*-{
        return new $wnd.ol.format.GML2(options);
    }-*/;
}
