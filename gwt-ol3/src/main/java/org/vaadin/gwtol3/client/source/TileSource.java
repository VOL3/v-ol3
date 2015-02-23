package org.vaadin.gwtol3.client.source;

import org.vaadin.gwtol3.client.tilegrid.TileGrid;

/**
 * Abstract base class; normally only used for creating subclasses and not instantiated in apps. Base class for sources providing images divided into a tile grid.
 */
public abstract class TileSource extends Source {
    protected TileSource() {
    }

    /** Returns the TileGrid set for the source
     *
     * @return
     */
    public final native TileGrid getTileGrid()/*-{
        return this.getTileGrid();
    }-*/;
}
