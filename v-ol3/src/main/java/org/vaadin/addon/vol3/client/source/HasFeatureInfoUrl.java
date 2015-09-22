package org.vaadin.addon.vol3.client.source;

import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.gwtol3.client.proj.Projection;

/**
 * Maker interface for sources that support feature info (WMS sources)
 * Created by Vaadin Ltd / mjhosio on 22/09/15.
 */
public interface HasFeatureInfoUrl {
	public String getGetFeatureInfoUrl(OLCoordinate coordinate, double resolution, Projection projection);
}
