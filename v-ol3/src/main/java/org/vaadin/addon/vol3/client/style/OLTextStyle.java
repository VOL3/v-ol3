package org.vaadin.addon.vol3.client.style;

import java.io.Serializable;

/**
 * Text style for features
 */
public class OLTextStyle implements Serializable{
    public String font;
    public Double offsetX;
    public Double offsetY;
    public Double scale;
    public Double rotation;
    public String text;
    public String textAlign;
    public String textBaseline;
    public OLFillStyle fill;
    public OLStrokeStyle stroke;

    @Override
    public String toString() {
        return "OLTextStyle{" +
                "font='" + font + '\'' +
                ", offsetX=" + offsetX +
                ", offsetY=" + offsetY +
                ", scale=" + scale +
                ", rotation=" + rotation +
                ", text='" + text + '\'' +
                ", textAlign='" + textAlign + '\'' +
                ", textBaseline='" + textBaseline + '\'' +
                ", fill=" + fill +
                ", stroke=" + stroke +
                '}';
    }
}
