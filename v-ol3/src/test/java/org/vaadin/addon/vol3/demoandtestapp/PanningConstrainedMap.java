package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.Projections;

/**
 * Created by Vaadin Ltd / mjhosio on 30/12/15.
 */
public class PanningConstrainedMap extends ConstrainedMap {

	@Override
	protected OLView createView() {
		OLViewOptions viewOpts=new OLViewOptions();
		viewOpts.setMinZoom(5);
		viewOpts.setMaxZoom(20);
		viewOpts.setZoomFactor(2d);
		viewOpts.setInputProjection(Projections.EPSG4326);
		// THE FEATURE IS BROKEN, FIX OR GET RID OF IT
//		viewOpts.setRestrictedExtent(createExtent());
		OLView view=new OLView(viewOpts);
		view.fitExtent(createExtent());
		return view;
	}
}
