package org.vaadin.addon.vol3.client;

import java.io.Serializable;

/** Used for setting constraints on the scrolling of the map. The boundaries are in units used by the current projection
 */
public class OLExtent implements Serializable {
    public double minX;
    public double minY;
    public double maxX;
    public double maxY;

    private boolean empty = true;

    public OLExtent() {

    }

    public OLExtent(OLCoordinate ... coordinates) {
        if (coordinates.length == 0) {
            return;
        }

        OLCoordinate first = coordinates[0];
        init(first);

        for (OLCoordinate coordinate : coordinates) {
            extend(coordinate);
        }
    }

    private void init(OLCoordinate first) {
        minX = first.x;
        minY = first.y;
        maxX = first.x;
        minY = first.y;
        empty = false;
    }

    /**
     * extend(OLCoordinate... points) will be useful in case of multiple vector on the
     * same map to compute the bounds that surround all the vectors
     *
     * Notes : there is no check of the starting bounds values the method will
     * fail if bounds values are not correctly initialized
     */
    public void extend(OLCoordinate... coordinates) {
        for (OLCoordinate coordinate : coordinates) {
            extend(coordinate);
        }
    }

    public void extend(OLCoordinate p) {
        if (empty) {
            init(p);
        } else {
            double x = p.x;
            if (x > maxX) {
                maxX = x;
            }
            if (x < minX) {
                minX = x;
            }
            double y = p.y;
            if (y < minY) {
                minY = y;
            }
            if (y > maxY) {
                maxY = y;
            }
        }
    }

    public void extend(OLExtent extent) {
        if (extent.empty)
            return;
        extend(new OLCoordinate(extent.minX, extent.minY), new OLCoordinate(extent.maxX, extent.maxY));
    }

    @Override
    public String toString() {
        return "OLExtent{" +
                "minX=" + minX +
                ", minY=" + minY +
                ", maxX=" + maxX +
                ", maxY=" + maxY +
                ", empty=" + empty +
                '}';
    }
}
