package org.vaadin.gwtol3.client;

/**
 * Created by Vaadin Ltd / mjhosio on 29/06/15.
 */
public class Proj4js {
	public static native void define(String crs, String proj4jsString)/*-{
		if(typeof $wnd.proj4 != 'undefined'){
			$wnd.proj4.defs(crs, proj4jsString);
		} else{
			console.error("Proj4j not available, please include it before trying to define projections");
		}
	}-*/;
}
