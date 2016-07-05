package org.vaadin.addon.vol3.client.source;

import com.google.gwt.core.client.JsArray;
import org.vaadin.addon.vol3.client.format.OLFeatureFormatFactory;
import org.vaadin.gwtol3.client.Attribution;
import org.vaadin.gwtol3.client.source.VectorSource;
import org.vaadin.gwtol3.client.source.VectorSourceOptions;

/**
 * Created by Vaadin Ltd / mjhosio on 05/06/16.
 */
public class OLAbstractVectorSourceConnector extends OLSourceConnector{

	@Override
	protected VectorSource createSource() {
		VectorSourceOptions options=VectorSourceOptions.create();
		if(getState().attributions!=null){
			JsArray<Attribution> jsArray= JsArray.createArray().cast();
			for(String attribution : getState().attributions){
				jsArray.push(Attribution.create(attribution));
			}
			options.setAttributions(jsArray);
		}
		if(getState().logo!=null){
			options.setLogo(getState().logo);
		}
		if(getState().useSpatialIndex!=null){
			options.setUseSpatialIndex(getState().useSpatialIndex);
		}
		if(getState().wrapX!=null){
			options.setWrapX(getState().wrapX);
		}
		if(getState().url!=null){
			options.setUrl(getState().url);
		}
		if(getState().format!=null){
			options.setFormat(OLFeatureFormatFactory.create(getState().format, getState().formatOptionsAsJson));
		}
		VectorSource source=VectorSource.create(options);
		return source;
	}


	@Override
	public OLVectorSourceState getState() {
		return (OLVectorSourceState) super.getState();
	}

	@Override
	public VectorSource getSource() {
		return (VectorSource) super.getSource();
	}
}
