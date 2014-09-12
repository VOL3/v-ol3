package org.vaadin.addon.vol3.client;

import java.io.Serializable;

import org.vaadin.addon.vol3.feature.OLPoint;

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
    
    public OLExtent(OLPoint... points) {
        if (points.length == 0) {
            return;
        }

        OLPoint first = points[0];
        init(first);

        for (OLPoint point : points) {
            extend(point);
        }
    }

    private void init(OLPoint first) {
        minX = first.getX();
        minY = first.getY();
        maxX = first.getX();
        minY = first.getY();
        empty = false;
    }

    /**
     * extend(Point... points) will be useful in case of multiple vector on the
     * same map to compute the bounds that surround all the vectors
     * 
     * Notes : there is no check of the starting bounds values the method will
     * fail if bounds values are not correctly initialized
     */
    public void extend(OLPoint... points) {
        for (int i = 0; i < points.length; i++) {
            OLPoint p = points[i];
            extend(p);
        }
    }

    public void extend(OLPoint p) {
        if (empty) {
            init(p);
        } else {
            double x = p.getX();
            if (x > maxX) {
                maxX = x;
            }
            if (x < minX) {
                minX = x;
            }
            double y = p.getY();
            if (y < minY) {
                minY = y;
            }
            if (y > maxY) {
                maxY = y;
            }
        }
    }
}
