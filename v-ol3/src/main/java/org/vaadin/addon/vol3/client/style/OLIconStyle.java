package org.vaadin.addon.vol3.client.style;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Icon style for features
 */
public class OLIconStyle implements Serializable {
    public double [] anchor;
    public String anchorOrigin;
    public String anchorXUnits;
    public String anchorYUnits;
    public String color;
    public String crossOrigin;
    public double [] offset;
    public String offsetOrigin;
    public Double scale;
    public Boolean snapToPixel;
    public Boolean rotateWithView;
    public Double rotation;
    public double [] size;
    public String src;

    @Override
    public String toString() {
        return "OLIconStyle{" +
                "anchor=" + Arrays.toString(anchor) +
                ", anchorOrigin='" + anchorOrigin + '\'' +
                ", anchorXUnits='" + anchorXUnits + '\'' +
                ", anchorYUnits='" + anchorYUnits + '\'' +
                ", color='" + color + '\'' +
                ", crossOrigin='" + crossOrigin + '\'' +
                ", offset=" + Arrays.toString(offset) +
                ", offsetOrigin='" + offsetOrigin + '\'' +
                ", scale=" + scale +
                ", snapToPixel=" + snapToPixel +
                ", rotateWithView=" + rotateWithView +
                ", rotation=" + rotation +
                ", size=" + Arrays.toString(size) +
                ", src='" + src + '\'' +
                '}';
    }
}
