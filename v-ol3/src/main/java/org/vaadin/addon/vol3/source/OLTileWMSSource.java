package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLTileWMSSourceState;
import org.vaadin.addon.vol3.client.tilegrid.OLTileGrid;
import org.vaadin.addon.vol3.client.tilegrid.OLWMTSTileGrid;
import org.vaadin.gwtol3.client.tilegrid.TileGrid;
import org.vaadin.gwtol3.client.tilegrid.WMTSTileGrid;
import org.vaadin.gwtol3.client.tilegrid.WMTSTileGridOptions;

import java.util.Map;

/**
 * Data source for tile data from WMS servers
 */
public class OLTileWMSSource extends OLSource {

    /** Creates a new instance of the layer data source
     *
     */
    public OLTileWMSSource(){
        super();
    }

    /** Creates a new instance of the layer data source
     *
     * @param options options for the data source
     */
     public OLTileWMSSource(OLTileWMSSourceOptions options){
        this();
        setOptions(options);
    }

    @Override
    protected OLTileWMSSourceState getState() {
        return (OLTileWMSSourceState) super.getState();
    }

    @Override
    protected OLTileWMSSourceState getState(boolean markAsDirty) {
        return (OLTileWMSSourceState) super.getState(markAsDirty);
    }

    private void setOptions(OLTileWMSSourceOptions options) {
        getState().attributions=options.getAttributions();
        getState().crossOriginPolicy=options.getCrossOriginPolicy();
        getState().projection=options.getProjection();
        getState().hidpi=options.getHidpi();
        getState().serverType=options.getServerType();
        getState().logo=options.getLogo();
        getState().url=options.getUrl();
        getState().urls=options.getUrls();
        getState().gutter=options.getGutter();
        getState().maxZoom=options.getMaxZoom();
        getState().params=options.getParams();
        
        //getState().tileGrid=options.getTileGrid();
        if(options.getTileGrid() instanceof OLWMTSTileGrid){
        	OLWMTSTileGrid olWmtsTileGrid = (OLWMTSTileGrid) options.getTileGrid();
            getState().WMTSTileGridOptionsOriginX = olWmtsTileGrid.options.origin.x;
            getState().WMTSTileGridOptionsOriginY = olWmtsTileGrid.options.origin.y;
            
            getState().WMTSTileGridOptionsresolutions = olWmtsTileGrid.options.resolutions;
            getState().WMTSTileGridOptionsTileSize = olWmtsTileGrid.options.tileSize;
        	
        }
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

    public String getUrl() {
        return getState(false).url;
    }

    public String[] getUrls() {
        return getState(false).urls;
    }

    public Double getGutter() {
        return getState(false).gutter;
    }

    public Double getMaxZoom() {
        return getState(false).maxZoom;
    }
   
    /** Gets WMS request parameters. The modifications to the parameters are applied automatically
     *
     * @return WMS request parameter map
     */
    public Map<String, String> getParams() {
        // mark state as dirty
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
