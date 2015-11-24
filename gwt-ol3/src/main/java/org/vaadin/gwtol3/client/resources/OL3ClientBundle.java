package org.vaadin.gwtol3.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.TextResource;

/**
 * Client bundle for embedding the wrapper JS api and associated style sheets
 */
public interface OL3ClientBundle extends ClientBundle {

    //@Source ("ol-debug.js")
    @Source ("ol.js")
    TextResource javaScript();

    @Source ("ol.css")
    @CssResource.NotStrict
    CssResource css();

    @Source ("ol3-layerswitcher.js")
    TextResource layerSwitcherJavaScript();

    @Source ("ol3-layerswitcher.css")
    @CssResource.NotStrict
    CssResource layerSwitcherCss();
}

