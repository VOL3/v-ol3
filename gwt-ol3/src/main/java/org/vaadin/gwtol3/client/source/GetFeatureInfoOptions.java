package org.vaadin.gwtol3.client.source;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by Vaadin Ltd / mjhosio on 22/09/15.
 */
public class GetFeatureInfoOptions extends JavaScriptObject {
	protected GetFeatureInfoOptions() {
	}

	public static native GetFeatureInfoOptions create()/*-{
		return {};
	}-*/;

	public native final void set(String key, String value)/*-{
		this[key]=value;
	}-*/;
}
