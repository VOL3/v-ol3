package org.vaadin.addon.vol3.client.style;

import java.io.Serializable;

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
}
