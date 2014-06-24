package org.vaadin.gwtol3.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.TextResource;

/**
 * Created by mjhosio on 24/06/14.
 */
public interface OL3ClientBundle extends ClientBundle {

    @Source ("ol-whitespace.js")
//    @Source ("ol.js")
    TextResource javaScript();

    @Source ("ol.css")
    @CssResource.NotStrict
    CssResource css();

}
