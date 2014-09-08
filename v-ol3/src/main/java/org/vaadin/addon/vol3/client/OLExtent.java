package org.vaadin.addon.vol3.client;

import java.io.Serializable;

/** Used for setting constraints on the scrolling of the map. The boundaries are in units used by the current projection
 */
public class OLExtent implements Serializable {
    public double minX;
    public double minY;
    public double maxX;
    public double maxY;
}
