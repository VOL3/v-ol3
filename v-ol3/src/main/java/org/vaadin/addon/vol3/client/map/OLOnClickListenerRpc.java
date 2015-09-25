package org.vaadin.addon.vol3.client.map;

import com.vaadin.shared.communication.ServerRpc;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLPixel;

import java.util.List;

/**
 * Listener to transform events from client to server
 */
public interface OLOnClickListenerRpc extends ServerRpc {


	void onClick(OLCoordinate cooordinate, OLPixel pixel, String eventType, List<String> featureInfoUrls, List<String> featureIds, String details);
}
