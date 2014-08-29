package org.vaadin.addon.vol3.client.source;

import org.vaadin.addon.vol3.client.OLExtent;

import javax.print.attribute.standard.Destination;

/**
 * Created by mjhosio on 07/07/14.
 */
public class OLVectorSourceState extends OLSourceState{
    public String state;
    public String [] attributions;
    public String logo;
    //destination projection. If provided, features will be transformed to this projection.
    public String projection;
}
