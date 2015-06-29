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

    public void setAttributions(String[] attributions) {
        this.attributions = attributions;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
