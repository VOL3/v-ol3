package org.vaadin.addon.vol3.source;

/**
 * Base class for all the source options
 */
public class OLSourceOptions {
    private String [] attributions;
    private String logo;

    public String[] getAttributions() {
        return attributions;
    }

    public OLSourceOptions setAttributions(String[] attributions) {
        this.attributions = attributions;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public OLSourceOptions setLogo(String logo) {
        this.logo = logo;
        return this;
    }
}
