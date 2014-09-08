package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLOSMSourceState;

/**
 * Layer source for an open street map tile server
 */
public class OLOSMSource extends OLXYZSource{

    /** Creates a new instance of the Open Street Map source
     *
     */
    public OLOSMSource(){
        super();
    }

    /** Creates a new instance of the Open Street Map source
     *
     * @param options options for the source
     */
    public OLOSMSource(OLOSMSourceOptions options){
        this();
        setOptions(options);
    }

    @Override
    protected OLOSMSourceState getState() {
        return (OLOSMSourceState) super.getState();
    }

    @Override
    protected OLOSMSourceState getState(boolean markAsDirty) {
        return (OLOSMSourceState) super.getState(markAsDirty);
    }

    private void setOptions(OLOSMSourceOptions options) {
        getState().customAttributions=options.getCustomAttributions();
        getState().crossOriginPolicy=options.getCrossOriginPolicy();
        getState().showDataAttributions=options.getShowDataAttributions();
        getState().showTileAttributions=options.getShowTileAttributions();
        getState().maxZoom=options.getMaxZoom();
    }

    public Boolean getShowDataAttributions() {
        return getState(false).showDataAttributions;
    }

    public Boolean getShowTileAttributions() {
        return getState(false).showTileAttributions;
    }

    public String[] getCustomAttributions() {
        return getState(false).customAttributions;
    }

    public Integer getMaxZoom() {
        return getState(false).maxZoom;
    }

    public String getCrossOriginPolicy() {
        return getState(false).crossOriginPolicy;
    }
}
