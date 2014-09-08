package org.vaadin.addon.vol3.client.source;

import com.vaadin.shared.communication.ServerRpc;

/**
 * Server rpc interface for the OLVectorSource
 */
public interface OLVectorSourceServerRpc extends ServerRpc {
    public void featureModified(String id, String serializedGeometry);

    public void featureDeleted(String id);

    public void featureAdded(String serializedGeometry);
}
