package org.vaadin.addon.vol3.demoandtestapp;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLOverlay;
import org.vaadin.addon.vol3.client.control.OLLayerSwitcherControl;
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

	@Override
	protected OLMap createMap() {
		final OLMap map = super.createMap();
        vectorLayer.setTitle("Feature Layer");
        map.setLayerSwitcherControl(new OLLayerSwitcherControl());
		map.addClickListener(new OLMap.ClickListener() {
			@Override
			public void onClick(OLMap.OLClickEvent clickEvent) {
				if(clickEvent.getFeatureIds()!=null && clickEvent.getFeatureIds().size()>0){
					String featureId=clickEvent.getFeatureIds().get(0);
					map.addOverlay(createOverlay(clickEvent.getCoordinate(), featureId));
				} else{
					map.removeOverlays();
				}
			}
		});
		return map;
	}

	private OLOverlay createOverlay(OLCoordinate coordinate, String featureId) {
		OLOverlay overlay=new OLOverlay();
		overlay.position=coordinate;
		overlay.htmlContent="<h1>You just clicked this flag. My id is: "+featureId+"</h1>";
		return overlay;
	}

}
