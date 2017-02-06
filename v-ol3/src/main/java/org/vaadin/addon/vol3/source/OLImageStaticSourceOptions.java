package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.OLExtent;

/**
 * Options passed to OLImageStaticSource on construction
 */
public class OLImageStaticSourceOptions extends OLSourceOptions {
    private String url;
    private OLExtent imageExtent;
    private String projection;

    public String getProjection() {
        return projection;
    }

    /**
     * Sets the csr name of the used projection
     *
     * @param projection
     */
    public OLImageStaticSourceOptions setProjection(String projection) {
        this.projection = projection;
        return this;
    }

    public String getUrl() {
        return url;
    }

    /**
     * WMS service url
     *
     * @param url
     */
    public OLImageStaticSourceOptions setUrl(String url) {
        this.url = url;
        return this;
    }


    public void setImageExtent(OLExtent imageExtent) {
        this.imageExtent = imageExtent;
    }

    public OLExtent getImageExtent() {
        return imageExtent;
    }
}
