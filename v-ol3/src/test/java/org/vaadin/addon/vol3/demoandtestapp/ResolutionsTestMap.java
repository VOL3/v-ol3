package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.Projections;

/**
 * Created by Vaadin Ltd / mjhosio on 09/11/15.
 */
public class ResolutionsTestMap extends BasicMap{

	@Override
	protected OLView createView() {
		OLViewOptions opts=new OLViewOptions();
		opts.setInputProjection(Projections.EPSG4326);
		opts.setResolutions(new double [] {10000, 1000, 100, 10, 1});
		OLView view=new OLView(opts);
		view.setZoom(1);
		view.setCenter(12.48858697773736,41.87520491303505);
		return view;
	}
}
