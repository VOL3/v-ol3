package org.vaadin.addon.vol3.client.source;

import com.google.gwt.core.client.JsArray;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.shared.ui.Connect;
import org.vaadin.addon.vol3.client.util.DataConversionUtils;
import org.vaadin.addon.vol3.source.OLTileXYZSource;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.Coordinate;
import org.vaadin.gwtol3.client.source.Source;
import org.vaadin.gwtol3.client.source.XYZTileSource;
import org.vaadin.gwtol3.client.source.XYZTileSourceOptions;
import org.vaadin.gwtol3.client.tilegrid.TileGrid;
import org.vaadin.gwtol3.client.tilegrid.XYZTileGrid;
import org.vaadin.gwtol3.client.tilegrid.XYZTileGridOptions;

/**
 * Client-side connector for the OLOSMSource
 */
@Connect(OLTileXYZSource.class)
public class OLTileXYZSourceConnector extends OLXYZSourceConnector {

    @Override
    protected Source createSource() {
        XYZTileSourceOptions options = XYZTileSourceOptions.create();
        JsArray<Attribution> attributions = JsArray.createArray().cast();
        if (getState().showOSMAttributions != null && getState().showOSMAttributions) {
            attributions.push(XYZTileSource.createTileOSMAttribution());
        }
        if (getState().customAttributions != null) {
            for (String attribution : getState().customAttributions) {
                attributions.push(Attribution.create(attribution));
            }
        }
        options.setAttributions(attributions);
        if (getState().crossOriginPolicy != null) {
            options.setCrossOrigin(getState().crossOriginPolicy);
        }
        if (getState().maxZoom != null) {
            options.setMaxZoom(getState().maxZoom);
        }
        if (getState().tileGrid != null) {
            options.setTileGrid(createTileGrid(getState().tileGrid));
        }
        if (getState().projection != null) {
            options.setProjection(getState().projection);
        }
        if (getState().urlTemplate != null) {
            options.setUrl(getState().urlTemplate);
        }
        return XYZTileSource.create(options);
    }

    @Override
    public XYZTileSource getSource() {
        return (XYZTileSource) super.getSource();
    }

    @OnStateChange("urlTemplate")
    void updateUrlTemplate() {
        if (getState().urlTemplate != null) {
            getSource().setUrl(getState().urlTemplate);
        }
    }

    private TileGrid createTileGrid(OLTileGrid tileGrid) {
        XYZTileGridOptions options = XYZTileGridOptions.create();

        if (tileGrid.origin != null) {
            options.setOrigin(Coordinate.create(tileGrid.origin.x, tileGrid.origin.y));
        } else if (tileGrid.origins != null) {
            options.setOrigins(DataConversionUtils.toJsArrayCoordinate(tileGrid.origins));
        }
        if (tileGrid.resolutions != null) {
            options.setResolutions(DataConversionUtils.toJsArrayNumber(tileGrid.resolutions));
        }
        if (tileGrid.tileSize != null) {
            options.setTileSize(tileGrid.tileSize);
        } else if (tileGrid.tileSizes != null) {
            options.setTileSizes(DataConversionUtils.toJsArrayNumber(tileGrid.tileSizes));
        }
        if (tileGrid.minZoom != null) {
            options.setMinZoom(tileGrid.minZoom);
        }
        if (tileGrid.maxZoom != null) {
            options.setMaxZoom(tileGrid.maxZoom);
        }
        if (tileGrid.matrixIds != null) {
            options.setMatrixIds(DataConversionUtils.toJsArrayString(tileGrid.matrixIds));
        }
        return XYZTileGrid.create(options);
    }

    @Override
    public OLTileXYZSourceState getState() {
        return (OLTileXYZSourceState) super.getState();
    }
}
