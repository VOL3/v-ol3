package org.vaadin.addon.vol3.client;

import com.vaadin.shared.communication.ClientRpc;

/**
 * Client-side rpc impl for the view
 */
public interface OLViewClientRpc extends ClientRpc{

    public void setZoom(int zoom);

    public void setCenter(OLCoordinate center);

    public void setResolution(double resolution);

    public void setRotation(double rotation);

	public void fitExtent(OLExtent extent);
}
