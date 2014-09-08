package org.vaadin.gwtol3.client.layer;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Base class for the layers
 */
public abstract class LayerBase extends JavaScriptObject {

    protected LayerBase(){

    }

    public native final double getBrightness()/*-{
        return this.getBrightness();
    }-*/;

    public native final double getContrast()/*-{
        return this.getContrast();
    }-*/;

    public native final double getHue()/*-{
        return this.getHue();
    }-*/;

    public native final double getMaxResolution()/*-{
        return this.getMaxResolution();
    }-*/;

    public native final double getMinResolution()/*-{
        return this.getMinResolution();
    }-*/;

    public native final double getOpacity()/*-{
        return this.getOpacity();
    }-*/;

    public native final double getSaturation()/*-{
        return this.getSaturation();
    }-*/;

    public native final boolean getVisible()/*-{
        return this.getVisible();
    }-*/;

    public native final void setBrightness(double brightness)/*-{
        this.setBrightness(brightness);
    }-*/;

    public native final void setContrast(double contrast)/*-{
        this.setContrast(contrast);
    }-*/;

    public native final void setHue(double hue)/*-{
        this.setHue(hue);
    }-*/;

    public native final void setMaxResolution(double maxResolution)/*-{
        this.setMaxResolution(maxResolution);
    }-*/;

    public native final void setMinResolution(double minResolution)/*-{
        this.setMinResolution(minResolution);
    }-*/;

    public native final void setOpacity(double opacity)/*-{
        this.setOpacity(opacity);
    }-*/;

    public native final void setSaturation(double saturation)/*-{
        this.setSaturation(saturation);
    }-*/;

    public native final void setVisible(boolean visible)/*-{
        this.setVisible(visible);
    }-*/;


}
