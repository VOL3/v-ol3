package org.vaadin.gwtol3.client.layer;

import org.vaadin.gwtol3.client.source.Source;

/**
 * Created by mjhosio on 24/06/14.
 */
public abstract class Layer extends LayerBase {

    protected Layer() {
    }

    /** Gets the source for the layer data
     *
     * @return
     */
    public native final Source getSource()/*-{
        return this.getSource();
    }-*/;
}
