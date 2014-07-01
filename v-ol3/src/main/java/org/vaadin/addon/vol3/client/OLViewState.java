package org.vaadin.addon.vol3.client;

import com.vaadin.shared.AbstractComponentState;

/**
 * Created by mjhosio on 30/06/14.
 */
public class OLViewState extends AbstractComponentState {
    public Integer zoom;
    public OLCoordinate center;
    public Double resolution;
    public Double rotation;
    // crs name of the projection (e.g. EPSG4326")
    public String projection;
}
