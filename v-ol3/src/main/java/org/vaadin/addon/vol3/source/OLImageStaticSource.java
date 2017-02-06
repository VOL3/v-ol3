package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLImageStaticSourceState;

/**
 * Source for WMS servers providing single, untiled images.
 */
public class OLImageStaticSource extends OLSource {

    /**
     * Creates a new instance of the source
     */
    public OLImageStaticSource() {
        super();
    }

    /**
     * Creates a new instance of the source
     *
     * @param options the options for the source
     */
    public OLImageStaticSource(OLImageStaticSourceOptions options) {
        this();
        setOptions(options);
    }

    private void setOptions(OLImageStaticSourceOptions options) {
        getState().attributions = options.getAttributions();
        getState().projection = options.getProjection();
        getState().url = options.getUrl();
        getState().imageExtent = options.getImageExtent();
    }

    @Override
    protected OLImageStaticSourceState getState() {
        return (OLImageStaticSourceState) super.getState();
    }

    @Override
    protected OLImageStaticSourceState getState(boolean markAsDirty) {
        return (OLImageStaticSourceState) super.getState(markAsDirty);
    }

    public String[] getAttributions() {
        return getState(false).attributions;
    }


    public String getProjection() {
        return getState(false).projection;
    }


    public String getUrl() {
        return getState(false).url;
    }

}
