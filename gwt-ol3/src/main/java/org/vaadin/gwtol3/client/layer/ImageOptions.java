package org.vaadin.gwtol3.client.layer;

/**
 * Options for the ImageLayer
 */
public class ImageOptions extends LayerOptions {
    protected ImageOptions() {
    }

    /**
     * Initializes Image options. Basically a simple map wrapper that can be passed to ImageLayer on initialization
     */
    public static final native ImageOptions create()
    /*-{
        return {};
    }-*/;

}
