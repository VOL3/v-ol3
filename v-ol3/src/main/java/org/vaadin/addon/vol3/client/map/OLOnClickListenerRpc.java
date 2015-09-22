package org.vaadin.addon.vol3.client.map;

import com.vaadin.shared.communication.ServerRpc;
import org.vaadin.addon.vol3.client.OLClickEvent;

/**
 * Listener to transform events from client to server
 */
public interface OLOnClickListenerRpc extends ServerRpc {

	void onClick(OLClickEvent event);
}
