package org.vaadin.gwtol3.client.layer;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Extent;

/**
 * Base class for the layers
 */
public abstract class LayerBase extends JavaScriptObject {

    protected LayerBase(){

    }

    public native final Double getBrightness()/*-{
		var res = this.getBrightness();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);

    }-*/;

    public native final Double getContrast()/*-{
        var res = this.getContrast();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public native final Double getHue()/*-{
		var res = this.getHue();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public native final Double getMaxResolution()/*-{
		var res = this.getMaxResolution();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public native final Double getMinResolution()/*-{
        var res = this.getMinResolution();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public native final Double getOpacity()/*-{
        var res = this.getOpacity();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public native final Double getSaturation()/*-{
		var res =  this.getSaturation();
        return res == null ? null : @java.lang.Double::valueOf(D)(res);
    }-*/;

    public native final Boolean getVisible()/*-{
		var res = this.getVisible();
        return res == null ? null : @java.lang.Boolean::valueOf(Z)(res);
    }-*/;

    public native final Extent getExtent()/*-{
        return this.getExtent();
    }-*/;

    public native final String getTitle(String title)/*-{
        return this.get("title");
    }-*/;

    public native final String getStringProperty(String key)/*-{
        return this.get(key);
    }-*/;

    public native final Double getDoubleProperty(String key)/*-{
        var val = this.get(key);
        return val == null ? null : @java.lang.Double::valueOf(D)(val);
    }-*/;

    public native final Boolean getBooleanProperty(String key)/*-{
        var val = this.get(key);
        return val == null ? null : @java.lang.Boolean::valueOf(Z)(val);
    }-*/;

    public native final void setExtent(Extent extent)/*-{
        this.setExtent(extent);
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

    public native final void setTitle(String title)/*-{
        this.set("title", title);
    }-*/;

    public native final void setStringProperty(String key, String value)/*-{
        this.set(key, value);
    }-*/;

    public native final void setDoubleProperty(String key, double value)/*-{
        this.set(key, value);
    }-*/;

    public native final void setBooleanProperty(String key, boolean value)/*-{
        this.set(key, value);
    }-*/;
}
