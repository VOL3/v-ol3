package org.vaadin.gwtol3.client.layer;

import com.google.gwt.core.client.JavaScriptObject;
import org.vaadin.gwtol3.client.Extent;

/**
 * Base class for the layers
 */
public abstract class LayerBase extends JavaScriptObject {

    protected LayerBase(){

    }

    public native final String getId() /*-{
        if (this.id === undefined) {
            var d = new Date().getTime();
            this.id = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                var r = (d + Math.random()*16)%16 | 0;
                d = Math.floor(d/16);
                return (c=='x' ? r : (r&0x3|0x8)).toString(16);
            });
        }
        return this.id;
    }-*/;

    public native final void set(String key, String value) /*-{
            this.set(key, value);
    }-*/;

    public native final String get(String key) /*-{
            return this.get(key);
    }-*/;

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

    public native final void addOnLayerChangeListener(OnLayerChangeListener onLayerChangeListener) /*-{
        if(!this.__onChangeRegistered){
            var that = this;
            var visibleCallback = function(event) {
                var visibleEvent = {type: "visible", layer: that, nativeEvent: event};
                that.__notifyChangeListeners(visibleEvent);
            };
            this.on("change:visible", $entry(visibleCallback), this);

            this.__onChangeRegistered=true;
            this.__changeListeners=[];
            this.__notifyChangeListeners = function(changeEvent) {
                var length=this.__changeListeners.length;
                for(var i=0; i<length; i++){
                    var listener = this.__changeListeners[i];
                    listener.@org.vaadin.gwtol3.client.layer.OnLayerChangeListener::onLayerChange(Lorg/vaadin/gwtol3/client/layer/LayerChangeEvent;)(changeEvent);
                }
            };
        }

        this.__changeListeners.push(onLayerChangeListener);
    }-*/;

    public native final void removeOnLayerChangeListener(OnLayerChangeListener onLayerChangeListener) /*-{
        var index = this.__changeListeners.indexOf(onLayerChangeListener);
        if (index > -1) {
            this.__changeListeners.splice(index, 1);
        }
    }-*/;
}
