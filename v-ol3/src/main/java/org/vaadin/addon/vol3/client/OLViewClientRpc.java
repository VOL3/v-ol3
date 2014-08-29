package org.vaadin.addon.vol3.client;

import com.vaadin.shared.communication.ClientRpc;

/**
 * Created by mjhosio on 28/08/14.
 */
public interface OLViewClientRpc extends ClientRpc{

    public void setZoom(int zoom);

    public void setCenter(OLCoordinate center);

    public void setResolution(double resolution);

    public void setRotation(double rotation);
}
