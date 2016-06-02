package org.vaadin.gwtol3.client.format;

/**
 * Created by Vaadin Ltd / mjhosio on 02/06/16.
 */
public class GML3Format extends GMLBaseFormat {
	protected GML3Format() {
	}

	public static final native GML3Format create()/*-{
        return new $wnd.ol.format.GML3();
    }-*/;

	public static final native GML3Format create(GMLFormatOptions options)/*-{
        return new $wnd.ol.format.GML3(options);
    }-*/;
}
