package org.vaadin.gwtol3.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by mjhosio on 23/02/15.
 */
public class Logo extends JavaScriptObject {
	protected Logo() {
	}

	/** Link url for the logo. Will be followed when the logo is clicked
	 *
	 * @return the link url for the logo
	 */
	public native final String getHref()/*-{
		return this.href;
	}-*/;


	/** The image url for the logo
	 *
	 * @return the url for the logo image
	 */
	public native final String getSrc()/*-{
        return this.src;
    }-*/;
}
