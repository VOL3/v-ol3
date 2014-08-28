package org.vaadin.addon.vol3.client.source;

import com.vaadin.shared.communication.ServerRpc;

/**
 * Created by mjhosio on 28/08/14.
 */
public interface OLVectorSourceServerRpc extends ServerRpc {
    public void featureModified(String id, String serializedGeometry);

    public void featureDeleted(String id);

    public void featureAdded(String serializedGeometry);
}
