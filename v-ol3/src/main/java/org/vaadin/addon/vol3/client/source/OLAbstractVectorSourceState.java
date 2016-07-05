package org.vaadin.addon.vol3.client.source;

import org.vaadin.addon.vol3.client.format.OLFeatureFormat;

/**
 * Created by Vaadin Ltd / mjhosio on 05/06/16.
 */
public class OLAbstractVectorSourceState extends OLSourceState {
	public String state;
	public String [] attributions;
	public String logo;
	public Boolean useSpatialIndex;
	public Boolean wrapX;
	public String url;
	public OLFeatureFormat format;
	public String formatOptionsAsJson;
}
