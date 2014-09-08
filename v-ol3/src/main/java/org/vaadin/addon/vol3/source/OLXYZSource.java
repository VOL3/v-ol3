package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLXYZSourceState;

/**
 * Layer source for tile data with URLs in a set XYZ format.
 */
public abstract class OLXYZSource extends OLSource {

    /** Sets the url template used by the source. Must include {x}, {y} or {-y}, and {z} placeholders.
     *
     * @param url the template
     */
    public void setUrlTemplate(String url){
        getState().urlTemplate=url;
    }

    public String getUrlTemplate(){
        return getState(false).urlTemplate;
    }

    @Override
    protected OLXYZSourceState getState() {
        return (OLXYZSourceState) super.getState();
    }

    @Override
    protected OLXYZSourceState getState(boolean markAsDirty) {
        return (OLXYZSourceState) super.getState(markAsDirty);
    }
}
