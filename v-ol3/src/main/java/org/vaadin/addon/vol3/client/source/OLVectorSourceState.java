package org.vaadin.addon.vol3.client.source;

import org.vaadin.addon.vol3.client.OLExtent;

/**
 * Created by mjhosio on 07/07/14.
 */
public class OLVectorSourceState extends OLSourceState{
    public String state;
    public String [] attributions;
    public OLExtent extent;
    public String logo;
    // crs name of the projection
    public String projection;
}
