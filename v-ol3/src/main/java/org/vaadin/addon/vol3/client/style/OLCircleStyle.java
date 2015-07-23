package org.vaadin.addon.vol3.client.style;

import java.io.Serializable;

/**
 * Circle style for features
 */
public class OLCircleStyle implements Serializable {
    public OLFillStyle fill;
    public Double radius;
    public Boolean snapToPixel;
    public OLStrokeStyle stroke;

    @Override
    public String toString() {
        return "OLCircleStyle{" +
                "fill=" + fill +
                ", radius=" + radius +
                ", snapToPixel=" + snapToPixel +
                ", stroke=" + stroke +
                '}';
    }
}
