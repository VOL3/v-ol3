package org.vaadin.addon.vol3.client.interaction;

import com.vaadin.shared.communication.ServerRpc;

import java.util.List;

/**
 * Server rpc interface for the select interaction
 */
public interface OLSelectInteractionSRPC extends ServerRpc{
    public void updateSelection(List<String> selectedFeatures);
}
