package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.client.style.OLIconStyle;
import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.addon.vol3.feature.OLFeature;

/**
 * Created by Vaadin Ltd / mjhosio on 30/10/15.
 */
public class IconFeatureMap extends VectorLayerMap {
	@Override
	protected OLFeature createPointFeature(String id, double x, double y) {
		OLFeature pointFeature = super.createPointFeature(id, x, y);
		OLStyle style= new OLStyle();
		style.iconStyle=new OLIconStyle();
		style.iconStyle.size=new double[]{32.0,32.0};
		style.iconStyle.src = "VAADIN/img/flag.png";
		pointFeature.setStyle(style);
		return pointFeature;
	}
}
