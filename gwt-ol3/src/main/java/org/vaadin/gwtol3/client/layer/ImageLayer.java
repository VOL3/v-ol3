package org.vaadin.gwtol3.client.layer;

import org.vaadin.gwtol3.client.source.Source;

/**
 * Image layer
 */
public class ImageLayer extends Layer {
    protected ImageLayer() {
    }

    public static native ImageLayer create(Source src)
    /*-{
        return new $wnd.ol.layer.Image({source: src});
    }-*/;

    public static native ImageLayer create(ImageOptions options)
    /*-{
        return new $wnd.ol.layer.Image(options);
    }-*/;
}
