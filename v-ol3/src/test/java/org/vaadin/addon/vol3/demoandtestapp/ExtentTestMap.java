package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.Projections;
import org.vaadin.addon.vol3.client.control.*;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.layer.OLTileLayer;
import org.vaadin.addon.vol3.layer.OLTileLayerOptions;
import org.vaadin.addon.vol3.source.OLSource;

/** Map for testing Extents
 *
 */
public class ExtentTestMap extends BasicMap {

    protected OLMap createMap(){
        map = super.createMap();

        map.setFullScreenControl(new OLFullScreenControl());
        OLMousePositionControl mousePos=new OLMousePositionControl();
        mousePos.projection = Projections.EPSG3857;// .EPSG4326;
        map.setMousePositionControl(mousePos);
        map.setScaleLineControl(new OLScaleLineControl());
        map.setZoomSliderControl(new OLZoomSliderControl());
        map.setZoomToExtentControl(new OLZoomToExtentControl());

        OLLayer layer=createLayer(createSource());
        map.addLayer(layer);
        map.setView(createView());
        map.setSizeFull();
        return map;
    }

    protected OLLayer createLayer(OLSource source){
        OLTileLayerOptions opts=new OLTileLayerOptions();
        opts.setPreload(4);
        opts.setUseInterimTilesOnError(false);
        opts.setVisible(true);
        return new OLTileLayer(source,opts);
    }

    protected OLView createView(){
        OLViewOptions viewOpts=new OLViewOptions();
        viewOpts.setMinZoom(3);
        viewOpts.setMaxZoom(20);
        viewOpts.setZoomFactor(2d);
        //viewOpts.setProjection("EPSG:4326");
        viewOpts.setExtent(createExtent());
        viewOpts.setInputProjection(Projections.EPSG4326);
        OLView view=new OLView(viewOpts);
        view.setZoom(10);
        view.setCenter(12.48858697773736,41.87520491303505); // EPSG:4326
        //view.setCenter(1389679.0894, 5145161.7486);  // EPSG:3857

        return view;
    }

    @Override
    protected OLExtent createExtent() {
        return new OLExtent(GRAcoordinateList);
    }

    /*
         * Note that we intentionally place overlays 10 meter above ground. This
         * way above base layers in google earth.
         */
        // ROME GRA "EPSG:4326"
    private static OLCoordinate [] GRAcoordinateList = new OLCoordinate[] {
                new OLCoordinate(12.380218505365, 41.885921026773),
                new OLCoordinate(12.387084960443, 41.916585114853),
                new OLCoordinate(12.384338378412, 41.958979493725),
                new OLCoordinate(12.423477172355, 41.975827259649),
                new OLCoordinate(12.439270019035, 41.983483862127),
                new OLCoordinate(12.459869384268, 41.981442191482),
                new OLCoordinate(12.469482421377, 41.98603585837),
                new OLCoordinate(12.492828368642, 41.986546245344),
                new OLCoordinate(12.506561278797, 41.992160232),
                new OLCoordinate(12.581405639146, 41.95846888581),
                new OLCoordinate(12.611618041488, 41.920161632571),
                new OLCoordinate(12.615737914536, 41.896655132614),
                new OLCoordinate(12.602691649887, 41.865981473335),
                new OLCoordinate(12.596511840318, 41.852684981749),
                new OLCoordinate(12.589645385239, 41.834781492781),
                new OLCoordinate(12.581405639146, 41.819943378401),
                new OLCoordinate(12.573165893052, 41.813290693541),
                new OLCoordinate(12.551193236803, 41.801006998284),
                new OLCoordinate(12.527160644031, 41.795376184184),
                new OLCoordinate(12.510681151844, 41.795376184184),
                new OLCoordinate(12.455749511221, 41.800495126537),
                new OLCoordinate(12.39120483349, 41.81840820477),
                new OLCoordinate(12.372665404779, 41.864958764445),
                new OLCoordinate(12.372665404779, 41.865470120935),
                new OLCoordinate(12.380218505365, 41.885921026773)};
}
