package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.Projections;
import org.vaadin.addon.vol3.client.source.OLTileGrid;
import org.vaadin.addon.vol3.source.OLSource;
import org.vaadin.addon.vol3.source.OLWMTSSource;
import org.vaadin.addon.vol3.source.OLWMTSSourceOptions;

/**
 * Created by Vaadin Ltd / mjhosio on 21/04/15.
 */
public class WMTSMap extends BasicMap {
	@Override
	protected OLSource createSource() {
		OLWMTSSourceOptions options =new OLWMTSSourceOptions();
		// WebMapService of World http://www.osm-wms.de/
		options.setUrl("http://services.arcgisonline.com/arcgis/rest/services/Demographics/USA_Population_Density/MapServer/WMTS/");
		options.setLayer("0");
		options.setMatrixSet("EPSG:3857");
		options.setFormat("image/png");
		options.setProjection(Projections.EPSG3857);
		options.setStyle("default");
		options.setAttributions(new String[]{"Tiles &copy; <a href=\"http://services.arcgisonline.com/arcgis/rest/services/Demographics/USA_Population_Density/MapServer/\">ArcGIS</a>"});

		OLTileGrid tileGrid=new OLTileGrid();
		double [] resolutions=new double[14];
		String [] matrixIds=new String[14];
		double maxResolution=156543.0339;
		for(int i=0;i<14;i++){
			resolutions[i]=maxResolution/Math.pow(2,i);
			matrixIds[i]=""+i;
		}
		tileGrid.origin=new OLCoordinate(-20037508.342789244, 20037508.342789244);
		tileGrid.resolutions=resolutions;
		tileGrid.matrixIds=matrixIds;
		options.setTileGrid(tileGrid);
		return new OLWMTSSource(options);
	}

	@Override
	protected OLView createView() {
		OLViewOptions opts=new OLViewOptions();
		opts.setMapProjection("EPSG:3857");
		OLView view=new OLView(opts);
		view.setCenter(-11158582,4813697);
		view.setZoom(4);
		return view;
	}
}
