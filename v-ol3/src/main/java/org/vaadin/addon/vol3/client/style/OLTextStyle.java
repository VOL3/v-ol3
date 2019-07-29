package org.vaadin.addon.vol3.client.style;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Text style for features
 */
public class OLTextStyle implements Serializable{
    public String font;
    public Double offsetX;
    public Double offsetY;
    public Double scale;
    public Double rotation;
    public Double maxAngle;
    public Boolean overflow;
    public Boolean rotateWithView;
    public String placement;
    public String text;
    public String textAlign;
    public String textBaseline;
    public OLFillStyle fill;
    public OLFillStyle backgroundFill;
    public OLStrokeStyle stroke;
    public OLStrokeStyle backgroundStroke;
    public double [] padding;


    @Override
    public String toString() {
        return "OLTextStyle{" +
                "font='" + font + '\'' +
                ", offsetX=" + offsetX +
                ", offsetY=" + offsetY +
                ", scale=" + scale +
                ", rotation=" + rotation +
                ", maxAngle=" + maxAngle +
                ", overflow=" + overflow +
                ", rotateWithView=" + rotateWithView +
                ", placement='" + placement + '\'' +
                ", text='" + text + '\'' +
                ", textAlign='" + textAlign + '\'' +
                ", textBaseline='" + textBaseline + '\'' +
                ", fill=" + fill +
                ", backgroundFill=" + backgroundFill +
                ", stroke=" + stroke +
                ", backgroundStroke=" + backgroundStroke +
                ", padding=" + Arrays.toString(padding) +
                '}';
    }
}
