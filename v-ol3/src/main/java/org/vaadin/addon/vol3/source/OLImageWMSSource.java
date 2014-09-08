package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLImageWMSSourceState;

import java.util.Map;

/**
 * Source for WMS servers providing single, untiled images.
 */
public class OLImageWMSSource extends OLSource {

    /** Creates a new instance of the source
     *
     */
    public OLImageWMSSource(){
        super();
    }

    /** Creates a new instance of the source
     *
     * @param options the options for the source
     */
     public OLImageWMSSource(OLImageWMSSourceOptions options){
        this();
        setOptions(options);
    }

    private void setOptions(OLImageWMSSourceOptions options) {
        getState().attributions=options.getAttributions();
        getState().crossOriginPolicy=options.getCrossOriginPolicy();
        getState().projection=options.getProjection();
        getState().hidpi=options.getHidpi();
        getState().serverType=options.getServerType();
        getState().logo=options.getLogo();
        getState().url=options.getUrl();
        getState().params=options.getParams();
        getState().ratio=options.getRatio();
        getState().resolutions=options.getResolutions();
    }

    @Override
    protected OLImageWMSSourceState getState() {
        return (OLImageWMSSourceState) super.getState();
    }

    @Override
    protected OLImageWMSSourceState getState(boolean markAsDirty) {
        return (OLImageWMSSourceState) super.getState(markAsDirty);
    }

    public String[] getAttributions() {
        return getState(false).attributions;
    }

    public String getCrossOriginPolicy() {
        return getState(false).crossOriginPolicy;
    }

    public String getProjection() {
        return getState(false).projection;
    }

    public Boolean getHidpi() {
        return getState(false).hidpi;
    }

    public String getServerType() {
        return getState(false).serverType;
    }

    public String getLogo() {
        return getState(false).logo;
    }

    public Double getRatio() {
        return getState(false).ratio;
    }

    public double[] getResolutions() {
        return getState(false).resolutions;
    }

    public String getUrl() {
        return getState(false).url;
    }

    /** Gets WMS request parameters. The modifications to the parameters are applied automatically
     *
     * @return WMS request parameter map
     */
    public Map<String, String> getParams() {
        return getState().params;
    }

    /** Updates WMS request parameters
     *
     * @param params WMS request parameters
     */
    public void setParams(Map<String,String> params){
        getState().params=params;
    }
}
