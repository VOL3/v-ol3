package org.vaadin.gwtol3.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.TextResource;

/**
 * Client bundle for embedding the wrapper JS api and associated style sheets
 */
public interface OL3ClientBundle extends ClientBundle {

//    @Source ("ol-debug.js")
    @Source ("ol-debug.js")
    TextResource javaScript();

    @Source ("ol.css")
    @CssResource.NotStrict
    CssResource css();

}

