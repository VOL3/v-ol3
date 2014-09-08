package org.vaadin.addon.vol3.layer;

import com.vaadin.ui.AbstractSingleComponentContainer;
import com.vaadin.ui.Component;
import org.vaadin.addon.vol3.client.layer.OLLayerState;
import org.vaadin.addon.vol3.source.OLSource;

/**
 * Base class for all layer types
 */
public abstract class OLLayer extends AbstractSingleComponentContainer{

    protected OLLayer(OLSource source, OLLayerOptions options){
        super.setContent(source);
        if(options!=null){
            setOptions(options);
        }
    }

    /** Returns the data source of the layer
     *
     * @return the data source of the layer
     */
    public OLSource getSource(){
        return (OLSource) getContent();
    }

    /** Applies the layer options.
     *
     * @param options the options for the layer
     */
    protected void setOptions(OLLayerOptions options) {
        setBrightness(options.getBrightness());
        setContrast(options.getContrast());
        setHue(options.getHue());
        setMinResolution(options.getMinResolution());
        setMaxResolution(options.getMaxResolution());
        setOpacity(options.getOpacity());
        setSaturation(options.getSaturation());
        setLayerVisible(options.getVisible());
    }

    @Override
    public void setContent(Component content) {
        throw new UnsupportedOperationException("The source of the layer can not be changed after instantiation");
    }

    @Override
    protected OLLayerState getState() {
        return (OLLayerState) super.getState();
    }

    @Override
    protected OLLayerState getState(boolean markAsDirty) {
        return (OLLayerState) super.getState(markAsDirty);
    }

    public Double getBrightness() {
        return getState(false).brightness;
    }

    public void setBrightness(Double brightness) {
        getState().brightness=brightness;
    }

    public Double getContrast() {
        return getState(false).contrast;
    }

    public void setContrast(Double contrast) {
        getState().contrast = contrast;
    }

    public Double getHue() {
        return getState(false).hue;
    }

    public void setHue(Double hue) {
        getState().hue = hue;
    }

    public Double getMaxResolution() {
        return getState(false).maxResolution;
    }

    public void setMaxResolution(Double maxResolution) {
        getState().maxResolution = maxResolution;
    }

    public Double getMinResolution() {
        return getState(false).minResolution;
    }

    public void setMinResolution(Double minResolution) {
        getState().minResolution = minResolution;
    }

    public Double getOpacity() {
        return getState(false).opacity;
    }

    public void setOpacity(Double opacity) {
        getState().opacity = opacity;
    }

    public Double getSaturation() {
        return getState(false).saturation;
    }

    public void setSaturation(Double saturation) {
        getState().saturation = saturation;
    }

    public Boolean isLayerVisible() {
        return getState(false).visible;
    }

    public void setLayerVisible(Boolean visible) {
        getState().visible=visible;
    }
}
