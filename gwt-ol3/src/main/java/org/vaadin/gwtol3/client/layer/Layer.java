package org.vaadin.gwtol3.client.layer;

import org.vaadin.gwtol3.client.source.Source;

/**
 * Base class for the layers
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
