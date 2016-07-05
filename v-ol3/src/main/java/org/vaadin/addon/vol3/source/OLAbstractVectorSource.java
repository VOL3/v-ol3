package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.source.OLAbstractVectorSourceState;


/**
 * Created by Vaadin Ltd / mjhosio on 03/06/16.
 */
public abstract class OLAbstractVectorSource extends OLSource{


	protected void setOptions(OLAbstractVectorSourceOptions options) {
		getState().attributions=options.getAttributions();
		getState().logo=options.getLogo();
		getState().useSpatialIndex=options.getUseSpatialIndex();
		getState().wrapX=options.getWrapX();
		getState().url=options.getUrl();
		getState().format=options.getFormat();
		getState().formatOptionsAsJson=options.getFormatOptionsAsJson();
	}

	@Override
	protected OLAbstractVectorSourceState getState() {
		return (OLAbstractVectorSourceState) super.getState();
	}
}
