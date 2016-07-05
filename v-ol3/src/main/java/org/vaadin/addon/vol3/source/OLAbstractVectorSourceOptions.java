package org.vaadin.addon.vol3.source;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.vaadin.addon.vol3.client.format.OLFeatureFormat;
import org.vaadin.addon.vol3.format.OLFeatureFormatOptions;

/**
 * Created by Vaadin Ltd / mjhosio on 03/06/16.
 */
public class OLAbstractVectorSourceOptions extends OLSourceOptions {

	private Boolean wrapX;
	private Boolean useSpatialIndex;
	private String url;
	private OLFeatureFormat format;
	private String formatOptionsAsJson;

	public Boolean getWrapX() {
		return wrapX;
	}

	public OLAbstractVectorSourceOptions setWrapX(Boolean wrapX) {
		this.wrapX = wrapX;
		return this;
	}

	public Boolean getUseSpatialIndex() {
		return useSpatialIndex;
	}

	public OLAbstractVectorSourceOptions setUseSpatialIndex(Boolean useSpatialIndex) {
		this.useSpatialIndex = useSpatialIndex;
		return this;
	}

	public OLAbstractVectorSourceOptions setFormat(OLFeatureFormat format){
		this.format=format;
		return this;
	}

	public OLAbstractVectorSourceOptions setFormatOptions(OLFeatureFormatOptions options) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		formatOptionsAsJson=mapper.writeValueAsString(options);
		return this;
	}

	public OLAbstractVectorSourceOptions setUrl(String url){
		this.url=url;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public OLFeatureFormat getFormat() {
		return format;
	}

	public String getFormatOptionsAsJson() {
		return formatOptionsAsJson;
	}
}
