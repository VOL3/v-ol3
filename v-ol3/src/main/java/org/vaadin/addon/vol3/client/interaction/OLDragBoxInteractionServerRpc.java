package org.vaadin.addon.vol3.client.interaction;

import com.vaadin.shared.communication.ServerRpc;
import org.vaadin.addon.vol3.client.OLExtent;

/**
 * Created by Mikael on 21/12/16.
 */
public interface OLDragBoxInteractionServerRpc extends ServerRpc {

    void dragBoxEvent(String type, OLExtent extent);
}
