package org.vaadin.gwtol3.client.map;

import org.vaadin.gwtol3.client.Coordinate;

/**
 * Client side listener for mouse events
 * @author Martin Stypinski
 */
public interface OnClickListener {

    /**
     * @param coordinate the coordinates in EPSG:3857 ( Google Mercator Projection )
     */
    void onClick(Coordinate coordinate);

}
