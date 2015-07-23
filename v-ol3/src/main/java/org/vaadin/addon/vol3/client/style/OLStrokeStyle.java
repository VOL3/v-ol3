package org.vaadin.addon.vol3.client.style;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Stroke style for features
 */
public class OLStrokeStyle implements Serializable{
    public String color;
    public String lineCap;
    public String lineJoin;
    public double [] lineDash;
    public Double miterLimit;
    public Double width;

    @Override
    public String toString() {
        return "OLStrokeStyle{" +
                "color='" + color + '\'' +
                ", lineCap='" + lineCap + '\'' +
                ", lineJoin='" + lineJoin + '\'' +
                ", lineDash=" + Arrays.toString(lineDash) +
                ", miterLimit=" + miterLimit +
                ", width=" + width +
                '}';
    }
}
