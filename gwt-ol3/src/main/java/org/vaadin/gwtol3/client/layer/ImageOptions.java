package org.vaadin.gwtol3.client.layer;

/**
 * Created by mjhosio on 04/07/14.
 */
public class ImageOptions extends LayerOptions {
    protected ImageOptions() {
    }

    /**
     * Initializes Image options. Basically a simple map wrapper that can be passed to ImageLayer on initialization
     */
    public static native ImageOptions create()
    /*-{
        return {};
    }-*/;

}
